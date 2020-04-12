package com.hyu.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyAnotherBroadcastReceiver extends BroadcastReceiver {
    public MyAnotherBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context, "received in AnotherbroadcastReceiver", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
