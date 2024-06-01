package com.unesc.net.whereismypetgateway.smsReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import com.unesc.net.whereismypetgateway.http.PostSMS;
import com.unesc.net.whereismypetgateway.utils.LogListUtil;

import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsReceiver extends BroadcastReceiver {

    private static final String SMS = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
       try {
           if (SMS.equals(intent.getAction())) {
               Bundle bundle = intent.getExtras();
               if (bundle != null) {
                   Object[] smsReceived = (Object[]) bundle.get("pdus");
                   if (smsReceived != null) {
                       for (Object sms : smsReceived) {
                           SmsMessage message = SmsMessage.createFromPdu((byte[]) sms);

                           String body = message.getDisplayMessageBody();
                           String number = message.getOriginatingAddress();

                           LogListUtil.LOG("RECEBIDO: " + body + "\nDe: " + number);

                           JSONObject json = new JSONObject();
                           String bateria = this.getParameter(body, "bat:(\\d+)%");
                           String latitude = this.getParameter(body, "lat:(-\\d+\\.\\d+)");
                           String longitude = this.getParameter(body, "lon:(-\\d+\\.\\d+)");

                           json.put("numero", number);
                           json.put("bateria", bateria != null ? bateria.replace("bat:", "") : null);
                           json.put("latitude", latitude != null ? latitude.replace("lat:", "") : null);
                           json.put("longitude", longitude != null ? longitude.replace("lon:", "") : null);

                           new PostSMS().execute(json.toString());
                       }
                   }
               }
           }
       } catch (Exception e) {}
    }

    private String getParameter(String body, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(body);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return  null;
    }
}
