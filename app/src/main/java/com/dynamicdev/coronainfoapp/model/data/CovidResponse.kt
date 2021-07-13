package com.dynamicdev.coronainfoapp.model.data

 data class CovidResponse(
    val Countries: List<Country>,
    val Date: String,
    val Global: Global,
    val ID: String,
    val Message: String
)