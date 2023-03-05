package com.example.laba2.Interface

import com.example.laba2.model.CityModel
import retrofit2.Call
import retrofit2.http.*



    interface RetrofitServices {
        @GET("Weather2022.json")
        fun getMovieList(): Call<MutableList<CityModel>>
    }