package com.unesc.net.whereismypetgateway.http;

import android.os.AsyncTask;

import com.unesc.net.whereismypetgateway.utils.Constants;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetNumeros extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(Constants.PATH + "/pets/getNumeros");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() == HttpsURLConnection.HTTP_OK){
                return  new BufferedReader(new InputStreamReader(conn.getInputStream())).readLine();
            }
        } catch (Exception e) {}
        return null;
    }
}
