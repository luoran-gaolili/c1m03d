package com.flj.latte.net.interceptors;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ParamersInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();


        HttpUrl httpUrl = request.url().newBuilder()
                .addQueryParameter("key", "value")
                .build();

        request = request.newBuilder().url(httpUrl).build();

        return chain.proceed(request);
    }
}
