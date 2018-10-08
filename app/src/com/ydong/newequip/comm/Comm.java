package com.ydong.newequip.comm;

import android.os.Environment;

/**
 * Created by siberiawolf on 15/10/23.
 */
public class Comm {

    //全局文件保存名称
    public static final String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final int RESULT_ZOOM = 10003;
    public static final String SDCARD_IMG_ROOT = SDCARD_ROOT + "/newequip/img";
    public static final String SDCARD_APK_ROOT = SDCARD_ROOT + "/newequip/apk";
    public static final String SDCARD_VIDEO_ROOT = SDCARD_ROOT + "/newequip/video";


    public static String upgreage_version =   "http://api.daydaycook.com.cn/version/updversion.do";
}
