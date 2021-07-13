package com.dynamicdev.coronainfoapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dynamicdev.coronainfoapp.model.data.Country
import com.dynamicdev.coronainfoapp.model.data.CovidResponse
import com.dynamicdev.coronainfoapp.network.CovidRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidViewModel: ViewModel() {
    val mutableLiveData = MutableLiveData<List<Country>>()
    private val covidRetrofit= CovidRetrofit()
    fun callAPI() {

        covidRetrofit.getCovidData()
            .enqueue(object : Callback<CovidResponse> {
                override fun onResponse(
                    call: Call<CovidResponse>,
                    response: Response<CovidResponse>
                ) {
                    if (response.isSuccessful) {
                        mutableLiveData.postValue(response.body()?.Countries)
                    } else {
                        Log.d("Error", "Coudn't get the data")
                    }
                }

                override fun onFailure(call: Call<CovidResponse>, t: Throwable) {
                    Log.d("Error", "Coudn't get the data")
                }

            })

    }
}