package com.example.networkcallrestapi.Repository

import androidx.lifecycle.MutableLiveData
import com.example.networkcallrestapi.Api.ApiServices
import com.example.networkcallrestapi.Api.RetrofitInstance
import com.example.networkcallrestapi.model.Slider
import com.example.networkcallrestapi.model.SliderResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SliderEasyMvvmRepo {
    private val sliderList = MutableLiveData<List<Slider>>()

    fun getSliders(): MutableLiveData<List<Slider>> {
        val apiServices = RetrofitInstance.getRetrofit().create(ApiServices::class.java)
        apiServices.getSliders().enqueue(object : Callback<SliderResponse?> {
            override fun onResponse(
                call: Call<SliderResponse?>,
                response: Response<SliderResponse?>
            ) {
                if (response.isSuccessful) {
                    sliderList.postValue(response.body()?.data)
                }

            }

            override fun onFailure(call: Call<SliderResponse?>, t: Throwable) {

            }
        })


        return sliderList
    }
}