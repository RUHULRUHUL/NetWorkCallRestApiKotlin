package com.example.networkcallrestapi.services.viewModel

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.networkcallrestapi.services.model.SliderResponse
import com.example.networkcallrestapi.services.repository.SliderRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class SliderViewModel(val repository: SliderRepository) : ViewModel() {

    val sliderResponseLiveData: MutableLiveData<SliderResponse> = MutableLiveData<SliderResponse>()

    fun getSliders() {
        viewModelScope.launch {
            val sliderResponse: SliderResponse = repository.getSliders()
            sliderResponseLiveData.postValue(sliderResponse)

        }

    }

}