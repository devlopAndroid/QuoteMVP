package com.opentechspace.quotemvp.ApiNetwork

import com.opentechspace.quotemvp.ApiModel.Quote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/quotes")
    fun getData(@Query("page") page : Int) : Call<Quote>
}