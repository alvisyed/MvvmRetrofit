package com.dynamicdev.coronainfoapp.network

import com.dynamicdev.coronainfoapp.model.data.Country
import com.dynamicdev.coronainfoapp.model.data.CovidResponse
import com.dynamicdev.coronainfoapp.util.Constants.Companion.BASE_URL
import com.dynamicdev.coronainfoapp.util.Constants.Companion.END_POINT
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

class CovidRetrofit {

    private val covidApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CovidApiService::class.java)
    fun getCovidData()=covidApiService.fetchData()



    interface CovidApiService{
        @GET(END_POINT)
        fun fetchData(): Call<CovidResponse>
    }
}