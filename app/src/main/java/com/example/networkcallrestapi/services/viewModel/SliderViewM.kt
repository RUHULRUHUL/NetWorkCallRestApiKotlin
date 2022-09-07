package com.example.networkcallrestapi.services.viewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.networkcallrestapi.services.model.Slider
import com.example.networkcallrestapi.services.repository.SliderRepo


class SliderViewM : ViewModel() {

    private val sliderRepo = SliderRepo()

    fun getSliders(): MutableLiveData<MutableList<Slider>> {
        return sliderRepo.getSliders()
    }


}