package com.unesc.net.whereismypetgateway;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.unesc.net.whereismypetgateway.smsSender.SmsSender;
import com.unesc.net.whereismypetgateway.utils.LogListUtil;

public class MainActivity extends AppCompatActivity {

    private Button startStopBtn;
    private Intent intentSmsSender;
    private Boolean serviceOn = Boolean.FALSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogListUtil.start(findViewById(R.id.listView), getApplicationContext());

        FirebaseApp.initializeApp(this);
        FirebaseMessaging.getInstance();

        this.intentSmsSender = new Intent(getApplicationContext(), SmsSender.class);
        this.startBtn();
    }

    private void startBtn() {
        this.startStopBtn = findViewById(R.id.startStopBtn);
        this.startStopBtn.setOnClickListener(v -> {
            if (!serviceOn) {
                serviceOn = Boolean.TRUE;
                this.startStopBtn.setText("Parar");
                getApplicationContext().startService(this.intentSmsSender);
            } else {
                this.serviceOn = Boolean.FALSE;
                this.startStopBtn.setText("Iniciar");
                getApplicationContext().stopService(this.intentSmsSender);
            }
        });
    }

}