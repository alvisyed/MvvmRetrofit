package com.dynamicdev.coronainfoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.dynamicdev.coronainfoapp.R
import com.dynamicdev.coronainfoapp.viewmodel.CovidViewModel

class MainActivity : AppCompatActivity() {
    private val adapter = CovidListAdapter()

    private val viewModel: CovidViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter

        viewModel.mutableLiveData.observe(this,{
            adapter.listCovid=it
        })
        viewModel.callAPI()
    }
}