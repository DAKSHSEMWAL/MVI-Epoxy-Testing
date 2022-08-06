package com.zopsmart.mobile.mvitesting.ui

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.zopsmart.mobile.mvitesting.model.CarouselItem
import com.zopsmart.mobile.mvitesting.model.HelloHiltState
import com.zopsmart.mobile.mvitesting.model.Task
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class HelloHiltViewModel @AssistedInject constructor(
    @Assisted state: HelloHiltState
) : MavericksViewModel<HelloHiltState>(state) {
    fun setListData(tasks: List<Task>, carouselItems: List<CarouselItem>) {
        setState {
            copy(
                title = "Need Assistant",
                task = tasks,
                carouselItem = carouselItems
            )
        }
    }

    init {
        setState {
            copy(
                title = "Need Assistant",
                task = emptyList(),
                carouselItem = emptyList()
            )
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<HelloHiltViewModel, HelloHiltState> {
        override fun create(state: HelloHiltState): HelloHiltViewModel
    }

    companion object :
        MavericksViewModelFactory<HelloHiltViewModel, HelloHiltState> by hiltMavericksViewModelFactory()
}
