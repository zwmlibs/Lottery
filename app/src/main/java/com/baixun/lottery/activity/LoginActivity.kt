package com.baixun.lottery.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import com.baixun.lottery.MyApplication
import com.baixun.lottery.R
import com.baixun.lottery.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import com.baixun.lottery.network.ApiService
import com.baixun.lottery.network.HttpResult
import com.baixun.lottery.network.RetrofitClient
import com.baixun.lottery.utils.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.StringSignature
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.util.*


class LoginActivity : BaseActivity(), View.OnClickListener{


    override fun getLayoutResources(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        imgVerificationCode.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        btnTrialPlay.setOnClickListener(this)
        btnForgetPassword.setOnClickListener(this)
        btnRegister.setOnClickListener(this)

        AnimUtils.AddScaleAnim(applicationContext,btnLogin)
        AnimUtils.AddScaleAnim(applicationContext,btnTrialPlay)
        AnimUtils.AddScaleAnim(applicationContext,btnForgetPassword)
        AnimUtils.AddScaleAnim(applicationContext,btnRegister)

        loadVerificationCode()
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.imgVerificationCode -> loadVerificationCode()
            R.id.btnLogin -> login()
            R.id.btnTrialPlay -> {

            }
            R.id.btnForgetPassword -> {

            }
            R.id.btnRegister -> newIntent<RegisterActivity>()
        }
    }

    private fun loadVerificationCode(){

        val observable : Observable<ResponseBody>? = let { RetrofitClient.getInstance(applicationContext, ApiService.BASE_URL).create(ApiService::class.java)!!.verificationCode() }
        observable?.applySchedulers()?.subscribe ({ body : ResponseBody ->
            var bm: Bitmap? = null
            var inputStream: InputStream? = null
            var bis: BufferedInputStream? = null
            try {
                inputStream = body.byteStream()
                bis = BufferedInputStream(inputStream);
                bm = BitmapFactory.decodeStream(bis);
                imgVerificationCode.setImageBitmap(bm)
            } catch (e : IOException) {
                e.printStackTrace()
            } finally {
                bis?.close()
                inputStream?.close()
            }
        },{
            showToast(resources.getString(R.string.msg_request_error))
        })
    }

    private fun login(){
        val account = MyTextUtil.checkText(editAccount)
        val password = MyTextUtil.checkText(editPassword)
        val verificationCode = MyTextUtil.checkText(editVerificationCode)

        val root = JSONObject()
        try {
            root.put("username", account)
            root.put("password", CommonUtils.str2md5(password))
            root.put("validationCode", verificationCode)
            root.put("loginFrom", "3")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val requestBody = RequestBody.create(MediaType.parse("application/json"), root.toString())

        val observable : Observable<HttpResult.LoginResponse>? = let { RetrofitClient.getInstance(applicationContext, ApiService.BASE_URL).create(ApiService::class.java)!!.login(requestBody) }
        observable?.applySchedulers()?.subscribe ({ response : HttpResult.LoginResponse ->
            showToast(response?.msg!!)
            when(response?.code){
                0 -> {
                    setUser(response?.data!!)
                    finish()
                }
            }

        },{ showToast(resources.getString(R.string.msg_request_error)) })

    }
}
