package com.example.networkcallrestapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.networkcallrestapi.services.network.ApiServices
import com.example.networkcallrestapi.R
import com.example.networkcallrestapi.services.model.SliderResponse
import com.example.networkcallrestapi.services.viewModel.SliderViewM
import com.example.networkcallrestapi.services.viewModel.SliderViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var sliderViewModel: SliderViewModel
    private lateinit var sliderViewM: SliderViewM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //  getSliderRawdata()
        getSliderStatic()

        // getSlidersWithMvvm()


    }

    private fun getSliderRawdata() {
        //        val retrofit = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("https://heshelghor.com/api/")
//            .build()


        //val apiServices: ApiServices = retrofit.create(ApiServices::class.java)

        //   val call: Call<SliderResponse> = apiServices.getSliders()

        /*call.enqueue(object : Callback<SliderResponse?> {
            override fun onResponse(
                call: Call<SliderResponse?>,
                response: Response<SliderResponse?>
            ) {

                if (response.isSuccessful) {
                    Log.d("Slider", "Response Success: " + response.body()?.success)
                    //   Log.d("Slider", "Response Success: " + response.body()?.data.toString())


                    for (slider in response.body()?.data!!) {
                        Log.d("Slider", slider.image.toString())

                    }
                }


            }

            override fun onFailure(call: Call<SliderResponse?>, t: Throwable) {

            }
        })*/
    }

    private fun getSliderStatic() {
        sliderViewM = ViewModelProvider(this).get(SliderViewM::class.java)
        sliderViewM.getSliders()
        sliderViewM.getSliders().observe(this, Observer {
            for (item in it) {
                Log.d("ImageData", "Image: " + item.image)
            }
        })

    }

    private fun getSlidersWithMvvm() {
        sliderViewModel = ViewModelProvider(this).get(SliderViewModel::class.java)
        sliderViewModel.sliderResponseLiveData.observe(this, Observer { sliderResponse ->
            for (slider in sliderResponse?.data!!) {
                Log.d("SliderBanner", "Image - " + slider.image)
            }

        })
    }


}