package com.opentechspace.quotemvp.Contract

import com.opentechspace.quotemvp.ApiModel.Result

interface Contracts {
    interface Model{
        interface OnFinishedListener{
            fun finished(list: List<Result>?)
            fun onFailure(throwable: Throwable)
        }
        fun getQuoteList(onFinishedListener: OnFinishedListener, page : Int)
    }
    interface View{
        //the list data will come from model with finished function to presenter and then
        //this function will to take the data from presenter to view
        fun setDataToRecyclerView(list: List<Result>?)
        fun onResponseFailure(throwable: Throwable)
    }
    interface Presenter{
        fun onDestroy()
        //This function will take the value from view in presenter and send it to model
        fun sendViewDataToServer(page : Int)
    }
}