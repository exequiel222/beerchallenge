package com.exequiel.challenge.beers.features.list.viewmodel

import androidx.lifecycle.*
import com.exequiel.challenge.beers.core.viewmodel.BaseViewModel
import com.exequiel.challenge.beers.features.list.usecase.BeerListUseCase
import androidx.lifecycle.viewModelScope
import com.exequiel.challenge.beers.core.appendList
import com.exequiel.challenge.beers.features.list.usecase.model.BeerItemModel
import kotlinx.coroutines.launch
import com.exequiel.challenge.beers.core.usecase.support.BaseResultWrapper

class BeerListViewModel(
        override val bindingDelegate: BeerListBindingDelegate,
        private val presenterDelegate: MoviesListPresenterDelegate = MoviesListPresenterDelegate(bindingDelegate),
        private val beerListUseCase: BeerListUseCase
): BaseViewModel(bindingDelegate,presenterDelegate) {

    private val beerList = MediatorLiveData<MutableList<BeerItemModel>>()
    private var page: Int = 1

    fun loadMoreMovies() {
        callPopularMovies()
        page++
    }

    private fun callPopularMovies(){
        viewModelScope.launch{
            presenterDelegate.initRemoteRequest()
            when (val response = beerListUseCase.invoke(page)) {
                is BaseResultWrapper.ApiError -> {
                    presenterDelegate.onErrorRequest()
                }
                is BaseResultWrapper.ApiSuccess -> {
                    beerList.appendList(response.value)
                    presenterDelegate.onSuccessRequest(beerList.value?.toList()!!)
                }
            }
        }
    }
}