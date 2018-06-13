package com.baixun.lottery.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;

import com.baixun.lottery.utils.LogUtils;

import kotlin.Unit;

/**
 * Author：Biligle.
 * 自定义布局
 */

public class MyViewGroup extends ViewGroup {

    private MyViewGroupListener listener;//接口，监听滑动事件

    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    private int Y = 0;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {

//        int action = e.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_MOVE:
//                if(slide < 0){//下滑
//                    return true;
//                }else if(slide > 0){//上滑
//                    return true;
//                }
//        }
        return super.onInterceptTouchEvent(e);
//        return true;
    }

    private int downY = 0;//按下时的点
    private int slide = 0;//最终移动距离
    private int distance = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                slide = downY - (int)event.getY();
                if(slide < 0){//下滑
                    distance = listener.marginTop(Math.abs(slide));
                }else if(slide > 0){//上滑
                    distance = listener.marginTop(-slide);
                }
                break;
            case MotionEvent.ACTION_UP:
                if(slide < 0){//下滑
                    if(distance > 0) listener.location();
                }else if(slide > 0){//上滑
                    if(distance > 0) listener.reset();
                }
                break;
        }
        return true;
    }

    /**
     * 测量子View
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            //系统测量
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }
    }

    /**
     * 安排子View的位置
     * @param changed
     * @param l 左边距
     * @param t 上边距
     * @param r 右边距
     * @param b 下边距
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = 0, top = 0, right = 0, bottom = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            right = left + child.getMeasuredWidth();
            bottom = top + child.getMeasuredHeight();
            child.layout(left, top, right, bottom);
        }
    }

    public void setListener(MyViewGroupListener listener){
        this.listener = listener;
    }

    public interface MyViewGroupListener {
        /**
         * 设置topMargin，上下滑动时触发
         * @param slide 滑动距离
         * @return 当前上边距
         */
        int marginTop(int slide);

        Unit reset();

        Unit location();
    }
}
