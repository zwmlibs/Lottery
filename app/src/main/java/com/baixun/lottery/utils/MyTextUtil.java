package com.baixun.lottery.utils;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class MyTextUtil {
    private static final String TAG = "MyTextUtil";

    /**
     * 检查编辑框内容是否为空，返回内容
     *
     * @param et
     * @return
     */
    public static String checkText(EditText et) {
        if (et == null) {
            LogUtils.errorLog(TAG, "TextView is null");
            return "";
        }
        if (et.getText() != null && !et.getText().toString().trim().equals("")) {
            return et.getText().toString().trim();
        } else {
            return "";
        }
    }

    /**
     * 检查textview内容是否为空，返回内容
     *
     * @param tv
     * @return
     */
    public static String checkText(TextView tv) {
        if (tv == null) {
            LogUtils.errorLog(TAG, "EditText is null");
            return "";
        }
        if (tv.getText() != null && !tv.getText().toString().trim().equals("")) {
            return tv.getText().toString().trim();
        } else {
            return "";
        }
    }

    /**
     * 设置文字到TextView
     *
     * @param tv
     * @param text
     */
    public static void setStr(TextView tv, String text) {
        if (tv == null) {
            LogUtils.errorLog(TAG, "TextView is null");
            return;
        }
        if (text == null) {
            tv.setText("");
        } else {
            tv.setText(text);
        }
    }

    /**
     * 设置文字到EditText
     *
     * @param et
     * @param text
     */
    public static void setStr(EditText et, String text) {
        if (et == null) {
            LogUtils.errorLog(TAG, "EditText is null");
            return;
        }
        if (text == null) {
            et.setText("");
        } else {
            et.setText(text);
        }
    }

    /**
     * 获取文字长度
     *
     * @param context
     * @param text
     * @return
     */
    public static float getTextLength(Context context, String text) {
        if (context == null || text == null || text.equals("")) {
            return 0;
        } else {
            return new TextView(context).getPaint().measureText(text);
        }
    }

    /**
     * 设置大量文字，超出部分加省略号
     *
     * @param context
     * @param textView
     * @param content  字符串内容
     * @param width    保留字符串中长度
     */
    public static void setMoreText(Context context, TextView textView, String content, int width) {
        float textLength = getTextLength(context, content);
        if (textLength <= width) {
            setStr(textView, content);
        } else {
            int cutPoint = 0;
            float totalLength = 0;
            char[] chars = content.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                cutPoint = i;
                totalLength += getTextLength(context, chars[i] + "");
                if (totalLength > width) {
                    break;
                }
            }
            setStr(textView, content.substring(0, cutPoint - 2) + "...");
        }
    }

    /**
     * 多行显示内容
     *
     * @param context
     * @param topTv
     * @param bottomTv
     * @param content
     * @param width
     */
    public static void setDoubleText(Context context, TextView topTv, TextView bottomTv, String content, int width) {
        float textLength = getTextLength(context, content);
        if (textLength <= width) {
            setStr(topTv, content);
            bottomTv.setVisibility(View.GONE);
        } else {
            int cutPoint = 0;
            float totalLength = 0;
            char[] chars = content.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                cutPoint = i;
                totalLength += getTextLength(context, chars[i] + "");
                if (totalLength > width) {
                    break;
                }
            }
            setStr(topTv, content.substring(0, cutPoint));
            bottomTv.setVisibility(View.VISIBLE);
            setStr(bottomTv, content.substring(cutPoint, content.length()));

        }
    }
}