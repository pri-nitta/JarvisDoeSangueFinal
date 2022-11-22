package com.jarvis.jarvisdoesangue.API

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactoryAws {
    private val URL: String = "https://7kx27kccw4.execute-api.sa-east-1.amazonaws.com"
    private val client = OkHttpClient.Builder().build()

    private val retrofitFactoryAws: Retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun retrofitServiceAws(): RetrofitServiceAws{
        return retrofitFactoryAws.create(RetrofitServiceAws::class.java)
    }
}