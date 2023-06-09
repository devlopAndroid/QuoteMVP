package com.opentechspace.quotemvp.ApiNetwork

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInterface {
    private val BASE_URL = "https://quotable.io/"
    fun getInstance() : Retrofit{
        val value =  Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return value
    }
}
    val api = ApiInterface.getInstance().create(ApiService::class.java)