package com.example.networkcallrestapi.services.model

data class SliderResponse(
    val success: Boolean = false,
    var code: Int? = null,
    var data: MutableList<Slider>? = null
)