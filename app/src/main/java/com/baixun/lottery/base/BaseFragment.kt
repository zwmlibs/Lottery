package com.baixun.lottery.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cnbs.smartLoadingLayout.widgit.DefaultLoadingLayout
import com.cnbs.smartLoadingLayout.widgit.SmartLoadingLayout

/**
 * Created by zwm on 2018/1/22.
 */
abstract class BaseFragment : Fragment() {

    var isFirstIn : Boolean = true
    var isFirst : Boolean = false
    var rootView : View? = null
    var isFragmentVisiable : Boolean = false
    var box: DefaultLoadingLayout? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(rootView==null){
            rootView = inflater?.inflate(getLayoutResources(),container,false)
        }
        return  rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(isFirstIn) {
            initData()

            isFirstIn = false
        }

    }
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            isFragmentVisiable = true
        }
        if (rootView == null) {
            return
        }
        //可见，并且没有加载过
        if (!isFirst&&isFragmentVisiable) {
            onFragmentVisiableChange(true)
            return
        }
        //由可见——>不可见 已经加载过
        if (isFragmentVisiable) {
            onFragmentVisiableChange(false)
            isFragmentVisiable = false
        }
    }
    open fun onFragmentVisiableChange(b: Boolean) {

    }

    fun initBox(contentView : View){
        box = SmartLoadingLayout.createDefaultLayout(activity, contentView)
        box?.setErrorButtonListener {
            box?.onLoading()
            onRefresh()
        }
    }

    open fun onRefresh(){}

    fun applicationContext() : Context{
        return context!!.applicationContext
    }

    abstract fun getLayoutResources(): Int

    abstract fun initData()


}