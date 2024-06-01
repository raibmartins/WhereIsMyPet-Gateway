package com.unesc.net.whereismypetgateway.smsSender;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unesc.net.whereismypetgateway.http.GetNumeros;

public class SmsSender extends Service {
    private Handler handler = new Handler();
    private SmsSenderService smsSenderService = new SmsSenderService();

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                String response = new GetNumeros().execute().get();
//
                String[] numbers = new ObjectMapper().readValue(response, String[].class);

                for (String number : numbers) {
                    smsSenderService.send(number);
                }
//                handler.postDelayed(this, 20000);
                handler.postDelayed(this, 900000);
            } catch (Exception e) {}
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.postDelayed(runnable, 0);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
