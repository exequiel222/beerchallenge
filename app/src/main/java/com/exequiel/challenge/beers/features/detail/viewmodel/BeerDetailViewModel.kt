package com.exequiel.challenge.beers.features.detail.viewmodel

import androidx.lifecycle.viewModelScope
import com.exequiel.challenge.beers.core.viewmodel.BaseViewModel
import com.exequiel.challenge.beers.features.detail.usecase.fetchdetail.BeerDetailUseCase
import kotlinx.coroutines.launch
import com.exequiel.challenge.beers.core.usecase.support.BaseResultWrapper

class BeerDetailViewModel(
        override val bindingDelegate: BeerDetailBindingDelegate,
        private val presenterDelegate: BeerDetailPresenterDelegate = BeerDetailPresenterDelegate(bindingDelegate),
        private val beerDetailUseCase: BeerDetailUseCase
): BaseViewModel(bindingDelegate,presenterDelegate) {

    fun callDetailMovie(id: Int){
        viewModelScope.launch{
            presenterDelegate.initRemoteRequest()
            when (val response = beerDetailUseCase.invoke(id)) {
                is BaseResultWrapper.ApiError -> {
                    presenterDelegate.onErrorRequest()
                }
                is BaseResultWrapper.ApiSuccess -> {
                    presenterDelegate.onSuccessDetailMovieRequest(response.value)
                }
            }
        }
    }
}