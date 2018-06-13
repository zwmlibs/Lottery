package com.baixun.lottery.utils;

/**
 * Created by Administrator on 2017/9/1 0001.
 */

import android.content.Context;
import android.content.SharedPreferences;


public class SpUtil {
    private static SharedPreferences mSp = null;
    private static SharedPreferences.Editor mEdit = null;

    /**
     * 缓存数据
     *
     * @param context
     * @param key
     * @param text
     */
    public static void saveString(Context context, String key, String text) {
        if (mSp == null) {
            mSp = context.getSharedPreferences(Constants.SP_FILENAME, Context.MODE_PRIVATE);
        }
        if (mEdit == null) {
            mEdit = mSp.edit();
        }
        mEdit.putString(key, text);
        mEdit.commit();
    }

    /**
     * 获取缓存数据
     *
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context, String key) {
        if (mSp == null) {
            mSp = context.getSharedPreferences(Constants.SP_FILENAME, Context.MODE_PRIVATE);
        }
        return mSp.getString(key, "");
    }

    /**
     * 保存用户token
     *
     * @param context
     */
    public static void saveToken(Context context, String token) {
        if (mSp == null) {
            mSp = context.getSharedPreferences(Constants.SP_FILENAME, Context.MODE_PRIVATE);
        }
        if (mEdit == null) {
            mEdit = mSp.edit();
        }
        mEdit.putString(Constants.TOKEN, token);
        mEdit.commit();
    }

    /**
     * 获取用户token
     *
     * @param context
     * @return
     */
    public static String getToken(Context context) {
        if (mSp == null) {
            mSp = context.getSharedPreferences(Constants.SP_FILENAME, Context.MODE_PRIVATE);
        }
        return mSp.getString(Constants.TOKEN, "");
    }

    /**
     * 缓存用户id
     * @param context
     * @param user_id
     */
    public static void saveUserID(Context context,String user_id){
        if (mSp == null) {
            mSp = context.getSharedPreferences(Constants.SP_FILENAME, Context.MODE_PRIVATE);
        }
        if (mEdit == null) {
            mEdit = mSp.edit();
        }
        mEdit.putString(Constants.USER_ID, user_id);
        mEdit.commit();
    }

    /**
     * 获取用户id
     * @param context
     * @return
     */
    public static String getUserID(Context context) {
        if (mSp == null) {
            mSp = context.getSharedPreferences(Constants.SP_FILENAME, Context.MODE_PRIVATE);
        }
        return mSp.getString(Constants.USER_ID, "");
    }
}