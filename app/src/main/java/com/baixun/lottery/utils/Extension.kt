package com.baixun.lottery.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.widget.Toast
import com.baixun.lottery.MyApplication
import com.baixun.lottery.network.UserBean
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 * Created by lvruheng on 2017/7/2.
 */
fun Context.showToast(message: String) : Toast {
    var toast : Toast = Toast.makeText(this,message,Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.CENTER,0,0)
    toast.show()
    return toast
}

inline fun <reified T: Activity> Activity.newIntent() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}
fun <T> Observable<T>.applySchedulers(): Observable<T> {
    return subscribeOn(Schedulers.io()).
            unsubscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread())
}

@Throws(Exception::class)
fun getVersionName(context: Context): String {
    //获取packagemanager的实例
    val packageManager = context.packageManager
    //getPackageName()是你当前类的包名，0代表是获取版本信息
    val packInfo = packageManager.getPackageInfo(context.packageName, 0)
    return packInfo.versionName
}

fun hasLogin(): Boolean {
    return MyApplication.instance().getUserInfo() != ""
}

fun getUser(): UserBean {
    val gson = Gson()
    return gson.fromJson(MyApplication.instance().getUserInfo(), UserBean::class.java)
}

fun setUser(user : UserBean){
    val gson = Gson()
    MyApplication.instance().setUserInfo(gson.toJson(user))
}

fun translateNumber(d: Int): String {
    //      String[] str = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
    val str = arrayOf("零", "一", "二", "三", "四", "五", "六", "七", "八", "九")
    //      String ss[] = new String[] { "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿" };
    val ss = arrayOf("", "十", "百", "千", "万", "十", "百", "千", "亿")
    val s = d.toString()
    println(s)
    var sb = StringBuffer()
    for (i in 0 until s.length) {
        val index = s[i].toString()
        sb = sb.append(str[Integer.parseInt(index)])
    }
    val sss = sb.toString()
    var i = 0
    for (j in sss.length downTo 1) {
        sb = sb.insert(j, ss[i++])
    }
    return sb.toString()
}

fun formatTagData(str: String?): ArrayList<String>? {
    var list_str: ArrayList<String>? = null
    var strResult: Array<String>? = null
    if (str != null && str.isNotEmpty()) {
        strResult = str.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    }
    if (strResult != null && strResult.isNotEmpty()) {
        list_str = ArrayList()
        for (i in strResult.indices) {
            list_str.add(strResult[i])
        }
    }
    return list_str
}


