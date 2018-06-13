package com.baixun.lottery.utils;

import android.util.Log;

/**
 * Created by Administrator on 2017/12/22 0022.
 */

public class LogUtils {
    private static boolean openLog = true;//控制是否打印日志

    public static void log(String content) {
        if (openLog) {
            Log.i("zwm", content);
        }
    }

    public static void infoLog(String tag, String content) {
        if (openLog) {
            Log.i(tag, content);
        }
    }

    public static void errorLog(String tag, String content) {
        if (openLog) {
            Log.e(tag, content);
        }
    }
}
