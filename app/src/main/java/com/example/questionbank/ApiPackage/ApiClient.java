package com.example.questionbank.ApiPackage;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit retrofit = null;
    public static final String BASE_URL="https://c6e7-115-99-89-94.ngrok.io";

    public static Retrofit getRetrofit(){
        if (retrofit == null) {

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .build();
        }

        return retrofit;
    }

    public static LoginService loginService(){
        LoginService loginService = getRetrofit().create(LoginService.class);
        return loginService;
    }
}
