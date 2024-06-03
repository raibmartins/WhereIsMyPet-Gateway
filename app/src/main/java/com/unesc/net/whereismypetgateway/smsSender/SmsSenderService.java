package com.unesc.net.whereismypetgateway.smsSender;

import android.telephony.SmsManager;

import com.unesc.net.whereismypetgateway.utils.LogListUtil;

import java.util.Date;

public class SmsSenderService {

    private static final String message = "G123456#";;
    private static final SmsManager smsManager = SmsManager.getDefault();

    public void send(final String number, final  boolean log) {
        smsManager.sendTextMessage(number, null, message, null, null);
        if (log) {
            LogListUtil.LOG(String.format("SEND: %s \nDESTINY: %s", message, number));
        }
    }

}
