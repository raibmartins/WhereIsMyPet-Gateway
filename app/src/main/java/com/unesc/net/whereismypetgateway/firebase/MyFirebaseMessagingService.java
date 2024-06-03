package com.unesc.net.whereismypetgateway.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.unesc.net.whereismypetgateway.smsSender.SmsSenderService;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        if (message.getNotification() != null) {
            Log.i("firebase", message.getNotification().getBody());
            new SmsSenderService().send(message.getNotification().getBody(), false);
        }
    }
//    cc1DtdSwTTu3luX4uqmx8K:APA91bF_JG3lYIPAId1kyjacCGZTn0k_azoxoSOUCFXoODZN9qh5FL5R21JwN_fZgbvi39zOifQkkW4cBfhzxTD-AlJ-oNVi2Dk8FEUZLwyWSLh5CQKw3c2L8VYBzpuvAbrPJvK90xsj
    @Override
    public void onNewToken(@NonNull String token) {
        Log.i("firebase", token);
        super.onNewToken(token);
    }
}
