package com.unesc.net.whereismypetgateway.utils;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unesc.net.whereismypetgateway.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LogListUtil implements Serializable {

    private static ListView listView;
    private static List<String> LOG = new ArrayList<>();
    private static ArrayAdapter<String> stringArrayAdapter;

    public static void start(ListView listView, Context context) {
        LogListUtil.listView = listView;
        LogListUtil.stringArrayAdapter = new ArrayAdapter<>(context, R.layout.list_view, R.id.idTextList, LOG);
        LogListUtil.listView.setAdapter(LogListUtil.stringArrayAdapter);
    }

    public static void LOG(String message) {
        LOG.add(message);
        stringArrayAdapter.notifyDataSetChanged();
    }
}
