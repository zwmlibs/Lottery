package com.baixun.lottery.fragment


import android.opengl.Visibility
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.baixun.lottery.R
import com.baixun.lottery.activity.BettingActivity
import com.baixun.lottery.activity.LoginActivity
import com.baixun.lottery.activity.MainActivity
import com.baixun.lottery.base.BaseFragment
import com.baixun.lottery.network.UserBean
import com.baixun.lottery.utils.AnimUtils
import com.baixun.lottery.utils.getUser
import com.baixun.lottery.utils.hasLogin
import com.baixun.lottery.utils.newIntent
import kotlinx.android.synthetic.main.fragment_home.*



/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : BaseFragment(), View.OnClickListener {

    var userBean : UserBean? = null

    override fun getLayoutResources(): Int {
        return R.layout.fragment_home
    }

    override fun onResume() {
        super.onResume()
        //if(isFragmentVisiable) {
        userBean = getUser()
        if (hasLogin() && null != getUser()) {
            btnLogin.visibility = View.GONE
            btnRegister.visibility = View.GONE
            btnTrialPlay.visibility = View.GONE
            txtUserName.text = "用户:${userBean?.nickName}"
            txtBalance.text = "余额:${userBean?.accountBalance}"
        } else {
            // "未登录"
            btnLogin.visibility = View.VISIBLE
            btnRegister.visibility = View.VISIBLE
            btnTrialPlay.visibility = View.VISIBLE
            txtUserName.text = ""
            txtBalance.text = ""
        }
        //}
    }

    override fun initData() {

        //点击监听
        btnMenu.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        btnRegister.setOnClickListener(this)
        btnTrialPlay.setOnClickListener(this)
        btnCqssc.setOnClickListener(this)
        btnAhks.setOnClickListener(this)
        btnWaitTing.setOnClickListener(this)
        btnBjsc.setOnClickListener(this)
        btn11x5.setOnClickListener(this)
        btnFfc.setOnClickListener(this)
        btnSfc.setOnClickListener(this)
        btnWfc.setOnClickListener(this)
        btnFtc.setOnClickListener(this)
        btnPl3.setOnClickListener(this)
        btnMore.setOnClickListener(this)

        //点击动画
        AnimUtils.AddScaleAnim(applicationContext(),btnMenu)
        AnimUtils.AddScaleAnim(applicationContext(),btnLogin)
        AnimUtils.AddScaleAnim(applicationContext(),btnRegister)
        AnimUtils.AddScaleAnim(applicationContext(),btnTrialPlay)
        AnimUtils.AddScaleAnim(applicationContext(),btnCqssc)
        AnimUtils.AddScaleAnim(applicationContext(),btnAhks)
        AnimUtils.AddScaleAnim(applicationContext(),btnWaitTing)
        AnimUtils.AddScaleAnim(applicationContext(),btnBjsc)
        AnimUtils.AddScaleAnim(applicationContext(),btn11x5)
        AnimUtils.AddScaleAnim(applicationContext(),btnFfc)
        AnimUtils.AddScaleAnim(applicationContext(),btnSfc)
        AnimUtils.AddScaleAnim(applicationContext(),btnWfc)
        AnimUtils.AddScaleAnim(applicationContext(),btnFfc)
        AnimUtils.AddScaleAnim(applicationContext(),btnPl3)
        AnimUtils.AddScaleAnim(applicationContext(),btnMore)
    }

    override fun onClick(v: View?) {
        //if(hasLogin() || v?.id == R.id.btnMenu){
            when(v?.id){
                R.id.btnMenu -> (activity as MainActivity).openMenu();
                R.id.btnLogin -> activity.newIntent<LoginActivity>()
                R.id.btnRegister -> startActivity()
                R.id.btnTrialPlay -> startActivity()
                R.id.btnCqssc -> activity.newIntent<BettingActivity>()
                R.id.btnAhks -> startActivity()
                R.id.btnWaitTing -> startActivity()
                R.id.btnBjsc -> startActivity()
                R.id.btn11x5 -> startActivity()
                R.id.btnFfc -> startActivity()
                R.id.btnSfc -> startActivity()
                R.id.btnWfc -> startActivity()
                R.id.btnFtc -> startActivity()
                R.id.btnPl3 -> startActivity()
                R.id.btnMore -> startActivity()
            }
//        }else{
//            activity.newIntent<LoginActivity>()
//        }

    }

    fun startActivity(){

    }
}
