package com.baixun.lottery.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.baixun.lottery.R
import com.baixun.lottery.base.BaseActivity
import com.baixun.lottery.network.ApiService
import com.baixun.lottery.network.HttpResult
import com.baixun.lottery.network.RetrofitClient
import com.baixun.lottery.utils.*
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), View.OnClickListener {

    override fun getLayoutResources(): Int {
        return R.layout.activity_register
    }

    override fun initData() {
        btnRegister.setOnClickListener(this)
        btnTrialPlay.setOnClickListener(this)
        btnForgetPassword.setOnClickListener(this)
        btnLogin.setOnClickListener(this)

        AnimUtils.AddScaleAnim(applicationContext,btnRegister)
        AnimUtils.AddScaleAnim(applicationContext,btnTrialPlay)
        AnimUtils.AddScaleAnim(applicationContext,btnForgetPassword)
        AnimUtils.AddScaleAnim(applicationContext,btnLogin)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnRegister -> register()
            R.id.btnTrialPlay -> {

            }
            R.id.btnForgetPassword -> {

            }
            R.id.btnLogin -> newIntent<LoginActivity>()
        }
    }

    private fun register(){
        val account = MyTextUtil.checkText(editAccount)
        val password = MyTextUtil.checkText(editPassword)
        val confirmPassword = MyTextUtil.checkText(editConfirmPassword)
        val verificationCode = MyTextUtil.checkText(editVerificationCode)

        val options = mapOf("account" to account,"password" to password,"verificationCode" to verificationCode)
        val observable : Observable<HttpResult.RegisterResponse>? = let { RetrofitClient.getInstance(applicationContext, ApiService.BASE_URL).create(ApiService::class.java)!!.register(options) }
        observable?.applySchedulers()?.subscribe ({ response : HttpResult.RegisterResponse ->
            showToast(response?.msg!!)
        },{ showToast(resources.getString(R.string.msg_request_error)) })

    }
}
