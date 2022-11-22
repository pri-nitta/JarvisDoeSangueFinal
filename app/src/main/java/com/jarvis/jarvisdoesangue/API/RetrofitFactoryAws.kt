package com.jarvis.jarvisdoesangue.API

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactoryAws {
    val URL: String = "https://lmf09uq2aa.execute-api.sa-east-1.amazonaws.com"
    private val client = OkHttpClient.Builder().build()

    val retrofitFactoryAws = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun retrofitServiceAws(): RetrofitServiceAws{
        return retrofitFactoryAws.create(RetrofitServiceAws::class.java)
    }
}