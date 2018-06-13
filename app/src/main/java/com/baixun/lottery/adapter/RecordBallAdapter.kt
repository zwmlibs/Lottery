package com.baixun.lottery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ProgressBar

import com.baixun.lottery.R
import com.baixun.lottery.utils.LogUtils

class RecordBallAdapter(var context: Context, var data: List<Int>?) : BaseAdapter() {

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
        var recordBall: RecordBall? = null
        if (view == null) {
            recordBall = RecordBall()
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.item_recordball, null)
            recordBall.imgNumber = view!!.findViewById(R.id.imgNumber)
            recordBall.imgMark = view!!.findViewById(R.id.imgMark)
            recordBall.imgWhirl = view!!.findViewById(R.id.imgWhirl)
            recordBall.pbRun = view!!.findViewById(R.id.pbRun)
            view.tag = recordBall
        } else {
            recordBall = view!!.tag as RecordBall
        }
        var status = data!![position]
        when (status) {
            0 -> {
                recordBall.imgNumber!!.setImageResource(R.drawable.item0);
                recordBall.imgMark!!.visibility = View.GONE
                recordBall.imgWhirl!!.visibility = View.GONE
                recordBall.pbRun!!.visibility = View.GONE
            }
            1 -> {
                recordBall.imgNumber!!.setImageResource(R.drawable.item1);
                recordBall.imgMark!!.visibility = View.GONE
                recordBall.imgWhirl!!.visibility = View.GONE
                recordBall.pbRun!!.visibility = View.GONE
            }
            2 -> {
                recordBall.imgNumber!!.setImageResource(R.drawable.item2);
                recordBall.imgMark!!.visibility = View.GONE
                recordBall.imgWhirl!!.visibility = View.GONE
                recordBall.pbRun!!.visibility = View.GONE
            }
            3 -> {
                recordBall.imgNumber!!.setImageResource(R.drawable.item3);
                recordBall.imgMark!!.visibility = View.GONE
                recordBall.imgWhirl!!.visibility = View.GONE
                recordBall.pbRun!!.visibility = View.GONE
            }
            4 -> {
                recordBall.imgNumber!!.setImageResource(R.drawable.item4);
                recordBall.imgMark!!.visibility = View.GONE
                recordBall.imgWhirl!!.visibility = View.GONE
                recordBall.pbRun!!.visibility = View.GONE
            }
            5 -> {
                recordBall.imgNumber!!.setImageResource(R.drawable.item5);
                recordBall.imgMark!!.visibility = View.GONE
                recordBall.imgWhirl!!.visibility = View.GONE
                recordBall.pbRun!!.visibility = View.GONE
            }
            6 -> {
                recordBall.imgNumber!!.setImageResource(R.drawable.item6);
                recordBall.imgMark!!.visibility = View.GONE
                recordBall.imgWhirl!!.visibility = View.GONE
                recordBall.pbRun!!.visibility = View.GONE
            }
            7 -> {
                recordBall.imgNumber!!.setImageResource(R.drawable.item7);
                recordBall.imgMark!!.visibility = View.GONE
                recordBall.imgWhirl!!.visibility = View.GONE
                recordBall.pbRun!!.visibility = View.GONE
            }
            8 -> {
                recordBall.imgNumber!!.setImageResource(R.drawable.item8);
                recordBall.imgMark!!.visibility = View.GONE
                recordBall.imgWhirl!!.visibility = View.GONE
                recordBall.pbRun!!.visibility = View.GONE
            }
            9 -> {
                recordBall.imgNumber!!.setImageResource(R.drawable.item9);
                recordBall.imgMark!!.visibility = View.GONE
                recordBall.imgWhirl!!.visibility = View.GONE
                recordBall.pbRun!!.visibility = View.GONE
            }
            66 -> {
                recordBall.imgNumber!!.visibility = View.GONE
                recordBall.imgMark!!.visibility = View.GONE
                recordBall.imgWhirl!!.visibility = View.GONE
                recordBall.pbRun!!.visibility = View.VISIBLE
            }
        }

        return view
    }
}

internal class RecordBall {
    var imgNumber: ImageView? = null
    var imgMark: ImageView? = null
    var imgWhirl: ImageView? = null
    var pbRun: ProgressBar? = null
}