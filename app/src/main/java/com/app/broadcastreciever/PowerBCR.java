package com.app.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class PowerBCR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // Are we charging / charged?
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING
                        || status == BatteryManager.BATTERY_STATUS_FULL;
        boolean isFull = status == BatteryManager.BATTERY_STATUS_FULL;

        // How are we charging?
        int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

        if (isCharging&&usbCharge){
            Toast.makeText(context, "Charging with usb", Toast.LENGTH_SHORT).show();
        }else if (isCharging && acCharge){
            Toast.makeText(context, "Charging with ac", Toast.LENGTH_SHORT).show();
        }else if (isFull){
            Toast.makeText(context, "Fully Charged", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Not Charging", Toast.LENGTH_SHORT).show();
        }
    }
}
