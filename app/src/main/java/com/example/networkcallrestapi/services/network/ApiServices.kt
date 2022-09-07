package com.example.networkcallrestapi.services.network

import com.example.networkcallrestapi.services.model.SliderResponse
import com.example.networkcallrestapi.services.utils.Constant
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("sliders")
    suspend fun getSliders(): SliderResponse

    @GET(Constant.Sliders)
    fun getSliderList(): Call<SliderResponse>

}