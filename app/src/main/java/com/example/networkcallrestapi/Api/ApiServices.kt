package com.example.networkcallrestapi.Api

import com.example.networkcallrestapi.Utils.Constant
import com.example.networkcallrestapi.model.SliderResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET(Constant.Sliders)
    fun getSliders(): Call<SliderResponse>
}