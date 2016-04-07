package com.aya.common.Utils;

import android.content.Context;

/**
 * Created by Single on 2016/4/7.
 */
public class DPUtils {
    public DPUtils() {
    }
    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5F);
    }

    public static int px2dp(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5F);
    }
}
