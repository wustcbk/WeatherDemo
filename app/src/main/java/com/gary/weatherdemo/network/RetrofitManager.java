package com.gary.weatherdemo.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GaryCao on 2018/10/25.
 */
public class RetrofitManager {
    private static final int DEFAULT_CONNECT_TIME = 20;
    private static final int DEFAULT_WRITE_TIME = 50;
    private static final int DEFAULT_READ_TIME = 30;

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private static RetrofitManager retrofitManager;

    private RetrofitManager() {
        initOkHttpClient();
        initRetrofit();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiContants.AMAP_BASE_URL)//设置服务器路径
                .client(okHttpClient)//设置使用okhttp网络请求
                .addConverterFactory(GsonConverterFactory.create())//添加转化库，默认是Gson
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加回调库，采用RxJava
                .build();
    }

    private void initOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIME, TimeUnit.SECONDS)//连接超时时间
                .writeTimeout(DEFAULT_WRITE_TIME, TimeUnit.SECONDS)//设置写操作超时时间
                .readTimeout(DEFAULT_READ_TIME, TimeUnit.SECONDS)//设置读操作超时时间
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public synchronized static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager();
        }
        return retrofitManager;
    }

    /**
     * 泛型方法
     */
    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }
}