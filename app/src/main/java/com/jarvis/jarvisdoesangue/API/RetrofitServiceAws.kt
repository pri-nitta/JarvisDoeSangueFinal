package com.jarvis.jarvisdoesangue.API

import com.jarvis.jarvisdoesangue.model.Address
import com.jarvis.jarvisdoesangue.model.Donation
import com.jarvis.jarvisdoesangue.model.Profile
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitServiceAws {
    @GET("/usuarios/{id}")
    fun getUserInfo(@Path("id") userId: Int): Call<Profile>

    @POST("/usuarios")
    fun postUserInfo(@Body profile: Profile): Call<Profile>

    @GET("/enderecos/{id}")
    fun getAddress(@Path("id") userId: Int): Call<Address>

    @POST("/enderecos")
    fun postAddress(@Body address: Address):Call<Address>

    @GET("/doacoes/{id}")
    fun getDonations(@Path("id") userId: Int): Call<Array<Donation>>

    @POST("/doacoes")
    fun postDonation(@Body donation: Donation): Call<Donation>
}