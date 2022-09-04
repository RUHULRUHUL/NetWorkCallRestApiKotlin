package com.example.networkcallrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.networkcallrestapi.model.SliderResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://heshelghor.com/api/")
            .build()

        val apiServices: ApiServices = retrofit.create(ApiServices::class.java)

        val call: Call<SliderResponse> = apiServices.getSliders()

        call.enqueue(object : Callback<SliderResponse?> {
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
        })


    }
}