package com.zopsmart.mobile.mvitesting.model

import com.airbnb.mvrx.MavericksState

data class HelloHiltState(
    val title: String = "",
    val task: List<Task> = emptyList(),
    val carouselItem: List<CarouselItem> = emptyList()
) : MavericksState
