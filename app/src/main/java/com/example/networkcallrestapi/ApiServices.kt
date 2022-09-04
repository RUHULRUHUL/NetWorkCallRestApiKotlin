package com.example.networkcallrestapi

import com.example.networkcallrestapi.model.SliderResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("sliders")
    fun getSliders(): Call<SliderResponse>


}