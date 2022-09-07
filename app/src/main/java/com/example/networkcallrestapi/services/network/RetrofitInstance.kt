package com.example.networkcallrestapi.services.network

import com.example.networkcallrestapi.services.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BaseUrl)
            .build()
    }

    val api: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }

}