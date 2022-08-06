package com.zopsmart.mobile.mvitesting

import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.MavericksViewModelComponent
import com.airbnb.mvrx.hilt.ViewModelKey
import com.zopsmart.mobile.mvitesting.ui.HelloHiltViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap

@Module
@InstallIn(MavericksViewModelComponent::class)
interface ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(HelloHiltViewModel::class)
    fun helloViewModelFactory(factory: HelloHiltViewModel.Factory): AssistedViewModelFactory<*, *>
}
