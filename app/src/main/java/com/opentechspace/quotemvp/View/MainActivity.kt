package com.opentechspace.quotemvp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opentechspace.quotemvp.Contract.Contracts
import com.opentechspace.quotemvp.ApiModel.Result
import com.opentechspace.quotemvp.Presenter.QuotePresenter
import com.opentechspace.quotemvp.R

class MainActivity : AppCompatActivity(),Contracts.View {

    private lateinit var myAdapter : CustomAdapter
    private lateinit var presenter: QuotePresenter
    private lateinit var recycler : RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById<RecyclerView>(R.id.recycler)
        //list = ArrayList<Result>()
        linearLayoutManager = LinearLayoutManager(this)
        recycler.layoutManager = linearLayoutManager
        recycler.setHasFixedSize(true)
        presenter = QuotePresenter(this)
        presenter.sendViewDataToServer(1)
    }

    override fun setDataToRecyclerView(list: List<Result>?) {
        if (list != null) {
            myAdapter = CustomAdapter(this,list)
            recycler.adapter = myAdapter
        }
    }
    override fun onResponseFailure(throwable: Throwable) {
       Log.e("Failed",throwable.message.toString())
    }
}