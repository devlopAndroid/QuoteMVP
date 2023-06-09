package com.opentechspace.quotemvp.Presenter

import com.opentechspace.quotemvp.Contract.Contracts
import com.opentechspace.quotemvp.ApiModel.Result
import com.opentechspace.quotemvp.Model.QuoteModel

class QuotePresenter(private var view: Contracts.View?)
    : Contracts.Presenter,Contracts.Model.OnFinishedListener {

    private val model: Contracts.Model = QuoteModel()

    override fun finished(list: List<Result>?) {
        view?.setDataToRecyclerView(list)
    }

    override fun onFailure(throwable: Throwable) {
        view?.onResponseFailure(throwable)
    }

    override fun onDestroy() {
        view = null
    }

    //In presenter we need a function which can take data from view and send to model
    //Here this function is taking data from view and sending it to model

    override fun sendViewDataToServer(page: Int) {
        model.getQuoteList(this,page)
    }


}