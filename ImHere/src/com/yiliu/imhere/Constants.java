package com.yiliu.imhere;

import android.os.Environment;

public class Constants {

    /**
     * SD card direction.
     */
    public static final String SD_DIR = Environment
            .getExternalStorageDirectory().toString();
    /**
     * ImHere direction.
     */
    public static final String IM_HERE_DIR = SD_DIR + "/ImHere";
    /**
     * ImHere log direction.
     */
    public static final String IM_HERE_LOG_DIR = IM_HERE_DIR + "/client.log";
    
    /**
     * The uniquely identifies in notification bar.
     */
    public static final int NOTIFICIATION_ID = 1988226110;
}
