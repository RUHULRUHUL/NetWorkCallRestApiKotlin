package com.example.networkcallrestapi.services.repository

import com.example.networkcallrestapi.services.model.SliderResponse
import com.example.networkcallrestapi.services.network.RetrofitInstance

class SliderRepository {

    suspend fun getSliders(): SliderResponse {
        return RetrofitInstance.api.getSliders()
    }

}