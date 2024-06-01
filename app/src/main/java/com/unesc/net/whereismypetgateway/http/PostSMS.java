package com.unesc.net.whereismypetgateway.http;

import android.os.AsyncTask;

import com.unesc.net.whereismypetgateway.utils.Constants;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class PostSMS extends AsyncTask<String, String, String>{

    @Override
    protected String doInBackground(String... uri) {
        String responseString = null;
        try {
            URL url = new URL(Constants.PATH + "/petsLocation");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = uri[0].getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            if (conn.getResponseCode() == HttpsURLConnection.HTTP_OK){
                System.out.println("enviado");
            }
        } catch (Exception e) {
        }
        return responseString;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }
}