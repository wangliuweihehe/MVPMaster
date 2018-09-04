package com.wlw.admin.mvp.net;

import com.wlw.admin.mvp.App;
import com.wlw.admin.mvp.BuildConfig;
import com.wlw.admin.mvp.api.ApiService;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager instance;
    public ApiService service;

    public static RetrofitManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitManager.class) {
                if (instance == null) {
                    instance = new RetrofitManager();
                }
            }
        }
        return instance;
    }

    private RetrofitManager() {
        service = createService();
    }

    public <T> T create(Class<T> cls) {
        if (cls != null)
            return getRetrofit().create(cls);
        else throw new RuntimeException("Api service cannot be bull");
    }

    public ApiService createService() {
        if (service == null)
            service = getRetrofit().create(ApiService.class);
        return service;
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(getLogInterceptor())
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .cache(setCache())
                .build();

    }

    private HttpLoggingInterceptor getLogInterceptor() {
        return new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    }

    private Cache setCache() {
        return new Cache(new File(App.getAppLication().getCacheDir() + "cache"), 1024 * 1024 * 50);
    }

}
