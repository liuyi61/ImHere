package com.yiliu.imhere;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Receive BOOT_COMPLETED
 * 
 * @author Leo_Liu
 * 
 */
public class BootBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "BootBroadcastReceiver";

    /*
     * Start ImHereServer, if get the BOOT_COMPLETED.
     * 
     * @NOTE: BOOT_COMPLETED permission is needed.
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, ImHereService.class);
        context.startService(service);
        Utility.writeLog(Log.INFO, TAG,
                "Auto start ImHere service, if boot completed!");
    }

}
