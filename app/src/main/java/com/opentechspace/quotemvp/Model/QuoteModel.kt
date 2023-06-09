package com.opentechspace.quotemvp.Model

import android.util.Log
import com.opentechspace.quotemvp.Contract.Contracts
import com.opentechspace.quotemvp.ApiModel.Quote
import com.opentechspace.quotemvp.ApiNetwork.api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuoteModel : Contracts.Model {

    private val TAG = "QuoteList"
    override fun getQuoteList(onFinishedListener: Contracts.Model.OnFinishedListener, page: Int) {

        api.getData(page).enqueue(object : Callback<Quote>{
            override fun onResponse(call: Call<Quote>, response: Response<Quote>) {
               if(response!= null)
               {
                   val data = response.body()?.results
                   onFinishedListener.finished(data)
                   Log.e(TAG,"Movie List"+data?.size)
               }
            }

            override fun onFailure(call: Call<Quote>, t: Throwable) {
               onFinishedListener.onFailure(t)
            }
        })
    }
}