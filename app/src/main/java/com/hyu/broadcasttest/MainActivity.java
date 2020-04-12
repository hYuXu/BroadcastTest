package com.hyu.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    //private IntentFilter intentFilter;
    //private NetworkChangeReceiver networkChangeReceiver;
    //private LocalReceiver localReceiver;
    //private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //localBroadcastManager = LocalBroadcastManager.getInstance(this);
        //intentFilter = new IntentFilter();
        //intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //intentFilter.addAction("com.hyu.broadcasttest.LOCAL_BROADCAST");
        //localReceiver = new LocalReceiver();
        //localBroadcastManager.registerReceiver(localReceiver, intentFilter);
        //networkChangeReceiver = new NetworkChangeReceiver();
        //registerReceiver(networkChangeReceiver, intentFilter);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:
                break;
            case R.id.button:
                //Intent intent = new Intent("com.hyu.broadcasttest.MY_BROADCAST");
                //sendBroadcast(intent);
                Intent intent = new Intent("com.hyu.broadcasttest.FORCE_OFFLINE");
                sendBroadcast(intent);
                //localBroadcastManager.sendBroadcast(intent);
                //sendOrderedBroadcast(intent, null);
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver(localReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //Toast.makeText(MainActivity.this, "Network changed!", Toast.LENGTH_SHORT).show();
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(MainActivity.this, "Network available!", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(MainActivity.this, "Network unavialable!", Toast.LENGTH_SHORT).show();
        }
    }
    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(MainActivity.this, "LocalReceiver Received!", Toast.LENGTH_SHORT).show();
        }
    }
}
