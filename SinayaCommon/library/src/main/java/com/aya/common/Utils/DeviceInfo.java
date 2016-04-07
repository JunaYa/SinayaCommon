package com.aya.common.Utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Single on 2016/4/7.
 */
public class DeviceInfo {
    private static DeviceInfo deviceInfo;
    private String osVersion;
    private String osModel;
    private String imei;
    private String macAddress;
    private int screenWidth;
    private int screenHeight;
    private String packageName;
    private int packageVerCode;
    private String packageVerName;

    public static DeviceInfo getInstance(Context context) {
        if(deviceInfo == null) {
            deviceInfo = new DeviceInfo(context);
        }

        return deviceInfo;
    }

    public static DeviceInfo getInstance() {
        return deviceInfo;
    }

    public DeviceInfo(Context context) {
        this.osVersion = Build.VERSION.RELEASE;
        this.osModel = Build.MANUFACTURER + "_" + Build.MODEL;
        TelephonyManager tm = (TelephonyManager)context.getSystemService("phone");
        this.imei = tm.getDeviceId();
        if(this.imei == null) {
            this.imei = "000000000000000";
        }

        WifiManager wm = (WifiManager)context.getSystemService("wifi");
        this.macAddress = wm.getConnectionInfo().getMacAddress();
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        this.screenHeight = metrics.heightPixels;
        this.screenWidth = metrics.widthPixels;

        try {
            PackageInfo e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.packageName = e.packageName;
            this.packageVerCode = e.versionCode;
            this.packageVerName = e.versionName;
        } catch (PackageManager.NameNotFoundException var7) {
            var7.printStackTrace();
        }

    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getOsModel() {
        return this.osModel;
    }

    public String getImei() {
        return this.imei;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public int getPackageVerCode() {
        return this.packageVerCode;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPackageVerName() {
        return this.packageVerName;
    }
}
