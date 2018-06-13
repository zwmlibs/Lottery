package com.baixun.lottery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

import com.baixun.lottery.R

class BettingBallAdapter(var context: Context, var data: List<Int>?) : BaseAdapter() {

    override fun getCount(): Int {
        return data?.size ?: 0
    }

    override fun getItem(i: Int): Any? {
        return data?.get(i)
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        var bettingBall: BettingBall? = null
        if (view == null) {
            bettingBall = BettingBall()
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.item_bettingball, null)
            bettingBall.imgBall = view!!.findViewById(R.id.imgBall)
            bettingBall.txtNumber = view!!.findViewById(R.id.txtNumber)
            bettingBall.txtCount = view!!.findViewById(R.id.txtCount)
            view.tag = bettingBall
        } else {
            bettingBall = view!!.tag as BettingBall
        }
        var status = data!![i]
        bettingBall?.txtNumber!!.text = "$status"
        return view
    }
}

internal class BettingBall {
    var imgBall: ImageView? = null
    var txtNumber: TextView? = null
    var txtCount: TextView? = null
}