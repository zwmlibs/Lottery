package com.baixun.lottery.network

import com.baixun.lottery.network.HttpResult
import io.reactivex.Observable
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

interface ApiService{
    companion object{
        val BASE_URL : String
            get() = "http://192.168.0.103:8082/"

        val PIC_URL : String
            get() = "http://114.55.218.4:8080/kingbailePlatform/"
    }

    //验证码
    @GET("inter/user/validateCode")
    fun verificationCode(): Observable<ResponseBody>

    //注册
    @Multipart
    @POST("inter/user/register")
    fun register(@PartMap options :Map<String, String>): Observable<HttpResult.RegisterResponse>

    //登录
    @POST("inter/user/userLogin")
    fun login(@Body  options : RequestBody): Observable<HttpResult.LoginResponse>

    //分分彩
    @GET("inter/ticket/winsDragon/m5ffc")
    fun splitPoints(): Observable<HttpResult.SplitPointsResponse>

//    //登录 |注册   |我的评论
//    @GET("inter/user/userLogin.do")
//    fun login(@Query("username") username :String,@Query("password") password :String,@Query("validationCode") validationCode :String): Observable<HttpResult.LoginResponse>


}