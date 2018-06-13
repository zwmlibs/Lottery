package com.baixun.lottery.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import com.baixun.lottery.R
import com.baixun.lottery.bean.Dragon
import com.baixun.lottery.utils.LogUtils
import com.baixun.lottery.utils.OnItemClickListner
import com.baixun.lottery.widget.CustomGridView

import java.util.ArrayList

/**
 * Description 描述
 * Created by 张伟明 on 2017/5/18.
 */

class BettingAdapter2(private val context: Context, private var data: ArrayList<Dragon>?) : BaseAdapter() {


    override fun getCount(): Int {
        return data?.size ?: 0
    }

    override fun getItem(i: Int): Any? {
        return data?.get(i)
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        var bettingBall: Betting? = null
        if (view == null) {
            bettingBall = Betting()
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.item_betting, null)
            bettingBall.txtHowToPlay = view!!.findViewById(R.id.txtHowToPlay)
            bettingBall.txtEmpty = view!!.findViewById(R.id.txtEmpty)
            bettingBall.txtEven = view!!.findViewById(R.id.txtEven)
            bettingBall.txtSingular = view!!.findViewById(R.id.txtSingular)
            bettingBall.txtSmall = view!!.findViewById(R.id.txtSmall)
            bettingBall.txtBig = view!!.findViewById(R.id.txtBig)
            bettingBall.txtAll = view!!.findViewById(R.id.txtAll)
            bettingBall.gvBettingBall = view!!.findViewById(R.id.gvBettingBall)
            view.tag = bettingBall
        } else {
            bettingBall = view!!.tag as Betting
        }
        var status = data!![position]

        val (figure, bigType, bigNum, singleType, singleNum) = data!![position]
        bettingBall.txtHowToPlay!!.text = "万位"

        bettingBall.txtEmpty!!.setOnClickListener { view ->  }

        val data = ArrayList<Int>()
        data.add(0)
        data.add(1)
        data.add(2)
        data.add(3)
        data.add(4)
        data.add(5)
        data.add(6)
        data.add(7)
        data.add(8)
        data.add(9)
        val adapter = BettingBallAdapter(context, data)
        bettingBall.gvBettingBall!!.adapter = adapter
        bettingBall.gvBettingBall!!.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

            LogUtils.log("position:" + i)
        }


        return view
    }


    fun refresh(data: ArrayList<Dragon>) {
        this.data = data
        notifyDataSetChanged()
    }

    internal class Betting() {
        var txtHowToPlay: TextView? = null
        var txtEmpty: TextView? = null
        var txtEven: TextView? = null
        var txtSingular: TextView? = null
        var txtSmall: TextView? = null
        var txtBig: TextView? = null
        var txtAll: TextView? = null
        var gvBettingBall: GridView? = null
    }

}
