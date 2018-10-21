package com.gary.weatherdemo.network;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public class RetrofitManager {
    private static final int DEFAULT_CONNECT_TIME = 20;
    private static final int DEFAULT_WRITE_TIME = 50;
    private static final int DEFAULT_READ_TIME = 30;

    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;
    private static RetrofitManager retrofitManager;
    private static ApiService apiService;

    private RetrofitManager() {
        initOkHttpClient();
        initRetrofit();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiContants.AMAP_BASE_URL)//设置服务器路径
                .client(okHttpClient)//设置使用okhttp网络请求
                .addConverterFactory(GsonConverterFactory.create())//添加转化库，默认是Gson
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加回调库，采用RxJava
                .build();
    }

    private void initOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIME, TimeUnit.SECONDS)//连接超时时间
                .writeTimeout(DEFAULT_WRITE_TIME, TimeUnit.SECONDS)//设置写操作超时时间
                .readTimeout(DEFAULT_READ_TIME, TimeUnit.SECONDS)//设置读操作超时时间
                /*.addInterceptor(httpLoggingInterceptor)*/
                .build();
    }

    public synchronized static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager();
        }
        return retrofitManager;
    }

    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }

    public ApiService getApiClient() {
        if (apiService == null) {
            apiService = getInstance().create(ApiService.class);
        }
        return apiService;
    }
}