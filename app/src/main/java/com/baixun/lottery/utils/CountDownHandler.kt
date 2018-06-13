package com.baixun.lottery.utils

import android.os.Handler
import android.os.Message
import com.baixun.lottery.activity.BettingActivity
import java.lang.ref.WeakReference

/**
 * 处理倒计时的Handler
 */
class CountDownHandler(activity: BettingActivity?) : Handler() {
    private val bettingActivityWeakReference: WeakReference<BettingActivity> = WeakReference<BettingActivity>(activity)

    override fun handleMessage(msg: Message) {
        var msg = msg
        super.handleMessage(msg)
        val bettingActivity = bettingActivityWeakReference.get()
        when (msg.what) {
            88888 -> {
                val value = msg.obj as Long
                val second = if(value / 1000 < 10){ "0${value / 1000}" }else{value / 1000}
                bettingActivity?.getmCountNumber()!!.text = "00:$second"
                msg = Message.obtain()
                //重新获取消息
                msg.arg1 = 0
                msg.arg2 = 1
                msg.what = 88888
                msg.obj = value - 1000
                if (value > 0) {
                    sendMessageDelayed(msg, 1000)
                }else{
                    bettingActivity?.splitPoints()
                    msg = Message.obtain()
                    //重新获取消息
                    msg.arg1 = 0
                    msg.arg2 = 1
                    msg.what = 88888
                    msg.obj = 59000L
                    sendMessageDelayed(msg, 1000)
                }
            }
        }
    }
}