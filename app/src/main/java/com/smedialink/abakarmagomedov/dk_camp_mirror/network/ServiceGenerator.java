package com.smedialink.abakarmagomedov.dk_camp_mirror.network;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.CookieManager;
import java.net.CookiePolicy;


import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceGenerator {
    private static CookieManager sCookieManager = new CookieManager();
    private static OkHttpClient.Builder sHttpClient = new OkHttpClient.Builder();
    private static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create();

    public static <S> S createService(Class<S> serviceClass, Retrofit.Builder sBuilder) {
        sCookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        sBuilder.addConverterFactory(GsonConverterFactory.create(gson));
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        sHttpClient.addInterceptor(loggingInterceptor);
        sHttpClient.cookieJar(new JavaNetCookieJar(sCookieManager));

        Retrofit retrofit = sBuilder.client(sHttpClient.build()).build();
        return retrofit.create(serviceClass);
    }

}
