package com.example.networkcallrestapi.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.networkcallrestapi.Repository.SliderEasyMvvmRepo
import com.example.networkcallrestapi.model.Slider

class SliderEasyMvvmViewModel():ViewModel() {

    private val sliderEasyMvvmRepo = SliderEasyMvvmRepo()

    fun getSliders():MutableLiveData<List<Slider>>{
        return sliderEasyMvvmRepo.getSliders()
    }

}