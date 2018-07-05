package com.grayraven.mqtt_test2;

import android.app.Application;
import android.content.Context;

public class Mqtt2app extends Application {
    private static Context context;
    public void onCreate(){
        super.onCreate();
        Mqtt2app.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return Mqtt2app.context;
    }
}
