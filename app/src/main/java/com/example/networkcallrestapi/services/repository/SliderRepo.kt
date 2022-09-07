package com.example.networkcallrestapi.services.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.networkcallrestapi.services.model.Slider
import com.example.networkcallrestapi.services.model.SliderResponse
import com.example.networkcallrestapi.services.network.ApiServices
import com.example.networkcallrestapi.services.network.RetrofitIns
import com.example.networkcallrestapi.services.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SliderRepo {

    val sliderList = MutableLiveData<MutableList<Slider>>()

    fun getSliders(): MutableLiveData<MutableList<Slider>> {

        val apiServices: ApiServices = RetrofitIns.getRetrofit().create(ApiServices::class.java)
        val call = apiServices.getSliderList()

        apiServices.getSliderList().enqueue(object : Callback<SliderResponse?> {
            override fun onResponse(
                call: Call<SliderResponse?>,
                response: Response<SliderResponse?>
            ) {
                if (response.isSuccessful) {
                    Log.d("Response","Success")
                    sliderList.postValue(response.body()?.data!!)
                }else{
                    Log.d("Response","fail")

                }

            }

            override fun onFailure(call: Call<SliderResponse?>, t: Throwable) {

            }
        })

        return sliderList

    }


}