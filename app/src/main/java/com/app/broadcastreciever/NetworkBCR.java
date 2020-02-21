package com.app.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class NetworkBCR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
            if (noConnectivity) {
                Toast.makeText(context, "Network Dis-Connected", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Network Connected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
