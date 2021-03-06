package com.baixun.lottery.network

import android.content.Context
import android.util.Log
import java.io.File
import okhttp3.Cache
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import okhttp3.Interceptor
import okhttp3.Request
import java.io.IOException
import okhttp3.logging.HttpLoggingInterceptor



class RetrofitClient private constructor(context: Context,baseUrl: String){
    var httpCacheDirectory : File? = null
    val mContext : Context = context
    var cache : Cache? = null
    var okHttpClient : OkHttpClient? = null
    var retrofit : Retrofit? = null
    val DEFAULT_TIMEOUT : Long = 20
    val url = baseUrl

    init {
        //缓存地址
        if (httpCacheDirectory == null) {
            httpCacheDirectory = File(mContext.cacheDir, "app_cache")
        }
        try {
            if (cache == null) {
                cache = Cache(httpCacheDirectory, 10 * 1024 * 1024)
            }
        } catch (e: Exception) {
            Log.e("OKHttp", "Could not create http cache", e)
        }
        //okhttp创建了

        okHttpClient = OkHttpClient.Builder()
//                .addNetworkInterceptor(
//                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                .cache(cache)
                //.addInterceptor(CacheInterceptor(context))
                //.addNetworkInterceptor(CacheInterceptor(context))
//                .addInterceptor { chain ->
//                    val request = chain.request()
//                            .newBuilder()
//                            .addHeader("Content-Type", "application/json;charset=UTF-8")
//                            .addHeader("Accept-Encoding", "gzip, deflate")
//                            .addHeader("Connection", "keep-alive")
//                            .addHeader("Accept", "application/json, text/plain, */*")
//                            .build()
//                    chain.proceed(request)
//                }
                .addInterceptor(AddCookiesInterceptor())
                .addInterceptor(ReceivedCookiesInterceptor())
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build()
        //retrofit创建了
        retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build()

    }

    companion object{
        @Volatile
        var instance: RetrofitClient? = null
        val pageSize: String = "20"


        fun getInstance(context: Context,baseUrl: String) : RetrofitClient {
            if (instance == null) {
                synchronized(RetrofitClient::class) {
                    if (instance == null) {
                        instance = RetrofitClient(context,baseUrl)
                    }
                }
            }
            return instance!!
        }



    }

    fun <T> create(service: Class<T>?): T? {
        if (service == null) {
            throw RuntimeException("Api service is null!")
        }
        return retrofit?.create(service)
    }


}