package com.ydong.newequip;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;

import java.util.HashMap;

/**
 * Created by Yanbin on 2018/9/6.
 * 描述:
 */
public class NewEquipApplication extends Application {

    private static NewEquipApplication mContext;
    public Handler handler;

    public static HashMap<String, Activity> activityHashMap;

    public static NewEquipApplication getIntance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        handler = new Handler();
    }

    public HashMap<String, Activity> getActivityHashMap() {
        if (activityHashMap == null) {
            activityHashMap = new HashMap<>();
        }
        return activityHashMap;
    }
}
