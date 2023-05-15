package com.example.laundry.Api

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    const val baseUrl = "https://jsonplaceholder.typicode.com/"
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()

        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return  okHttpClient
    }

    fun getRetrofit() : Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getService() : ApiService{
        return getRetrofit().create(ApiService::class.java)
    }
}