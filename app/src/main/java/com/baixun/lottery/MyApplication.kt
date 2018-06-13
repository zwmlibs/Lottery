package com.baixun.lottery

import android.app.Application
import android.content.Context
import android.content.SharedPreferences


/**
 * Description 描述
 * Created by 张伟明 on 2018/1/22.
 */

class MyApplication : Application() {
    private var sp: SharedPreferences? = null
    private var spCache: SharedPreferences? = null

    var guide: String
        get() = sp!!.getString("guide", "")
        set(guide) {
            sp!!.edit().putString("guide", guide).commit()
        }

    fun clear() {
        sp!!.edit().clear().commit()
    }

    fun getUserInfo(): String {
        return sp!!.getString("userInfo", "")
    }

    fun setUserInfo(userInfo: String) {
        sp!!.edit().putString("userInfo", userInfo).commit()
    }


    var intermediateMax: String
        get() = sp!!.getString("intermediate_max", "")
        set(intermediateMax) {
            sp!!.edit().putString("intermediate_max", intermediateMax).commit()
        }

    var advancedMax: String
        get() = sp!!.getString("advanced_max", "")
        set(advancedMax) {
            sp!!.edit().putString("advanced_max", advancedMax).commit()
        }

    var primaryProgress: String
        get() = sp!!.getString("primary_progress", "")
        set(primaryProgress) {
            sp!!.edit().putString("primary_progress", primaryProgress).commit()
        }

    var intermediateProgress: String
        get() = sp!!.getString("intermediate_progress", "")
        set(intermediateProgress) {
            sp!!.edit().putString("intermediate_progress", intermediateProgress).commit()
        }

    var advancedProgress: String
        get() = sp!!.getString("advanced_progress", "")
        set(advancedProgress) {
            sp!!.edit().putString("advanced_progress", advancedProgress).commit()
        }

    override fun onCreate() {
        super.onCreate()
        instance = this
        sp = getSharedPreferences("log", Context.MODE_PRIVATE)
        spCache = getSharedPreferences("cache", Context.MODE_PRIVATE)

    }

    fun getCache(page: Int): String {
        return spCache!!.getString("cache_page" + page, "")
    }

    fun setCache(cache: String, page: Int) {
        spCache!!.edit().putString("cache_page" + page, cache).commit()
    }

    companion object {

        var instance: MyApplication? = null

        fun instance() : MyApplication {
            if (instance == null) {
                synchronized(MyApplication::class) {
                    if (instance == null) {
                        instance = MyApplication()
                    }
                }
            }
            return instance!!
        }

    }



}
