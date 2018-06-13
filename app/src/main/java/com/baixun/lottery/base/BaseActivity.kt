package com.baixun.lottery.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.cnbs.smartLoadingLayout.widgit.DefaultLoadingLayout
import com.cnbs.smartLoadingLayout.widgit.SmartLoadingLayout
import me.imid.swipebacklayout.lib.app.SwipeBackActivity

/**
 * Created by zwm on 2018/1/22.
 */
abstract class BaseActivity : SwipeBackActivity() {

    var box: DefaultLoadingLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResources())
        initData()
    }

    fun initBox(contentView : View){
        box = SmartLoadingLayout.createDefaultLayout(this@BaseActivity, contentView)
        box?.setErrorButtonListener {
            box?.onLoading()
            onRefresh()
        }
    }

    open fun onRefresh(){}

    fun onBack(view: View) {
        finish()
    }

    abstract fun getLayoutResources(): Int

    abstract fun initData()

}