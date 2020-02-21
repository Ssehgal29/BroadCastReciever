package com.app.broadcastreciever;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private PowerBCR powerBCR = new PowerBCR();
    private NetworkBCR networkBCR = new NetworkBCR();
    private Button btnRegPower,btnUnRegPower,btnRegNetwork,btnUnRegNetwork;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setId();
        setListener();
    }
    public void setId(){
        btnRegPower=findViewById(R.id.registerPower);
        btnUnRegPower=findViewById(R.id.unregisterPower);
        btnRegNetwork=findViewById(R.id.registerNetwork);
        btnUnRegNetwork=findViewById(R.id.unregisterNetwork);
    }
    public void setListener(){
        btnRegPower.setOnClickListener(this);
        btnUnRegPower.setOnClickListener(this);
        btnRegNetwork.setOnClickListener(this);
        btnUnRegNetwork.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(powerBCR);
        unregisterReceiver(networkBCR);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerPower:
                IntentFilter powerIF = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                registerReceiver(powerBCR,powerIF);
                break;
            case R.id.unregisterPower:
                unregisterReceiver(powerBCR);
                Toast.makeText(this, "Power BCR UnRegistered", Toast.LENGTH_SHORT).show();
                break;
            case R.id.registerNetwork:
                IntentFilter networkIF = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
                registerReceiver(networkBCR,networkIF);
                break;
            case R.id.unregisterNetwork:
                unregisterReceiver(networkBCR);
                Toast.makeText(this, "Network BCR UnRegistered", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
