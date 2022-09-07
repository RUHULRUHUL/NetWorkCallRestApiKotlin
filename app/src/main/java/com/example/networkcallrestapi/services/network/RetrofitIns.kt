package com.example.networkcallrestapi.services.network

import com.example.networkcallrestapi.services.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitIns {

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BaseUrl)
            .build()
    }

}