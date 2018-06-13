package com.baixun.lottery.fragment


import android.view.ViewGroup
import com.baixun.lottery.R
import com.baixun.lottery.base.BaseFragment
import com.baixun.lottery.widget.MyViewGroup
import kotlinx.android.synthetic.main.fragment_betting_ffc.*
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.baixun.lottery.adapter.BettingHistoryAdapter
import android.support.v7.widget.LinearLayoutManager
import android.view.MotionEvent
import com.baixun.lottery.adapter.BettingAdapter
import com.baixun.lottery.adapter.BettingAdapter2
import com.baixun.lottery.bean.Dragon
import com.baixun.lottery.bean.Win
import com.baixun.lottery.utils.LogUtils
import com.baixun.lottery.utils.OnItemClickListner
import java.util.ArrayList


/**
 * 分分彩
 */
class BettingFfcFragment : BaseFragment() , MyViewGroup.MyViewGroupListener{

    private var params: ViewGroup.MarginLayoutParams? = null

    private var dataHistory: ArrayList<Win>? = null
    private var adapterHistory : BettingHistoryAdapter? = null
    private var lmHistory: LinearLayoutManager? = null

    private var dataBetting: ArrayList<Dragon>? = null
    private var adapterBetting : BettingAdapter2? = null
    private var lmBetting: LinearLayoutManager? = null

    override fun getLayoutResources(): Int {
        return R.layout.fragment_betting_ffc
    }

    override fun initData() {
        myViewGroup.setListener(this);
        params = myViewGroup.layoutParams as ViewGroup.MarginLayoutParams

        dataHistory = ArrayList();
        var win : Win = Win(12,"456","64","45")
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        dataHistory?.add(win)
        adapterHistory = BettingHistoryAdapter(applicationContext(),dataHistory, OnItemClickListner { v, position ->

        })


        listHistory.adapter = adapterHistory
        lmHistory = LinearLayoutManager(applicationContext())
        lmHistory?.orientation = LinearLayoutManager.VERTICAL
        listHistory.layoutManager = lmHistory
        //listHistory.addItemDecoration(DividerItemDecoration(applicationContext(), DividerItemDecoration.VERTICAL_LIST))
        setHeader(listHistory)


        dataBetting = ArrayList()
        var dragon = Dragon("1","2","3","4","5")
        dataBetting?.add(dragon)
        dataBetting?.add(dragon)
        dataBetting?.add(dragon)
        dataBetting?.add(dragon)
        dataBetting?.add(dragon)
        adapterBetting = BettingAdapter2(applicationContext(),dataBetting)
        listBetting.adapter = adapterBetting
//        lmBetting = LinearLayoutManager(applicationContext())
//        lmBetting?.orientation = LinearLayoutManager.VERTICAL
//        listBetting.layoutManager = lmBetting
        //listBetting.addItemDecoration(DividerItemDecoration(applicationContext(), DividerItemDecoration.VERTICAL_LIST))
    }

    private fun setHeader(view: RecyclerView) {
        val header = LayoutInflater.from(applicationContext()).inflate(R.layout.list_header_betting_history, view, false)
        header.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        adapterHistory?.headerView = header
    }

    override fun marginTop(slide: Int): Int {
        params!!.topMargin += slide
        myViewGroup.layoutParams = params
        return params!!.topMargin
    }

    override fun reset() {
        params!!.topMargin = 0
        myViewGroup.layoutParams = params
    }

    override fun location() {
        params!!.topMargin = 1000
        myViewGroup.layoutParams = params
    }
}
