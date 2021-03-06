package com.baixun.lottery.network;

import android.content.SharedPreferences;

import com.baixun.lottery.MyApplication;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }
            SharedPreferences.Editor config = MyApplication.Companion.instance().getSharedPreferences("config", MyApplication.Companion.instance().MODE_PRIVATE).edit();
            config.putStringSet("cookie", cookies);
            config.commit();
        }
        return originalResponse;
    }
}


