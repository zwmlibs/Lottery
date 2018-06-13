package com.baixun.lottery.utils;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.baixun.lottery.R;


/**
 * Description 描述 点击动画
 * Created by 张伟明 on 2016/12/29.
 */

public class AnimUtils {

    public static ScaleInAnimation ANIMATION = new ScaleInAnimation();

    //为控件添加点击缩放动画
    public static void AddScaleAnim(final Context context,final View view){
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        beginScale(context,view, R.anim.zoom_in);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        beginScale(context,view,R.anim.zoom_out);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        beginScale(context,view,R.anim.zoom_out);
                        break;
                }
                return false;
            }
        });
    }

    private static void beginScale(Context context,View view,int animation) {
        Animation an = AnimationUtils.loadAnimation(context, animation);
        an.setDuration(80);
        an.setFillAfter(true);
        view.startAnimation(an);
    }

    public static void AddAnimation(RecyclerView.ViewHolder holder) {
        for (Animator anim : ANIMATION.getAnimators(holder.itemView)) {
            anim.setDuration(500).start();
        }
    }
}
