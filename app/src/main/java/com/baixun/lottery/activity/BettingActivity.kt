package com.baixun.lottery.activity

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Message
import android.widget.TextView
import com.baixun.lottery.R
import com.baixun.lottery.adapter.RecordBallAdapter
import com.baixun.lottery.base.BaseActivity
import com.baixun.lottery.fragment.BettingFfcFragment
import com.baixun.lottery.network.ApiService
import com.baixun.lottery.network.HttpResult
import com.baixun.lottery.network.RetrofitClient
import com.baixun.lottery.utils.*
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_betting.*


/**
 * 投注页面
 */
class BettingActivity : BaseActivity() {

    var recordBallAdapter: RecordBallAdapter? = null
    lateinit var data: List<Int>
    private var countDownHandler : CountDownHandler? = null
    var initTimer : Boolean = false

    override fun getLayoutResources(): Int {
        return R.layout.activity_betting
    }

    override fun initData() {

        txtCountdown.typeface = Typeface.createFromAsset(assets, "fonts/digitalism.ttf")

        data = listOf(6, 5, 7, 9, 2)
        recordBallAdapter = RecordBallAdapter(this, data)
        gvRecordBall.adapter = recordBallAdapter

        countDownHandler = CountDownHandler(this)

        splitPoints()
        initContent()
    }

    public fun splitPoints() {
        val observable: Observable<HttpResult.SplitPointsResponse>? = let { RetrofitClient.getInstance(applicationContext, ApiService.BASE_URL).create(ApiService::class.java)!!.splitPoints() }
        observable?.applySchedulers()?.subscribe({ response: HttpResult.SplitPointsResponse ->
            when (response?.code) {
                0 -> {
                    if(!initTimer){
                        var distanceTime = TimeUtils.getDiff(response.data!!.currentTime,response.data!!.nextTime)
                        var msg = Message()
                        msg.what = 88888
                        msg.obj = distanceTime
                        countDownHandler!!.sendMessage(msg)
                        initTimer = true
                    }

                }
            }

        }, { showToast(resources.getString(R.string.msg_request_error)) })
    }

    private fun initContent(){
        supportFragmentManager.beginTransaction().replace(R.id.flContent,BettingFfcFragment()).commit()
    }

    public fun getmCountNumber() : TextView {
        return txtCountdown
    }

    @SuppressLint("MissingSuperCall")
    override fun onDestroy() {
        super.onDestroy()
        countDownHandler?.removeCallbacksAndMessages(null)
    }
}
