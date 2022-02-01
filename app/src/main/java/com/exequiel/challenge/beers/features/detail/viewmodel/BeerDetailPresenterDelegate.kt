package com.exequiel.challenge.beers.features.detail.viewmodel

import com.exequiel.challenge.beers.core.viewmodel.BasePresenterDelegate
import com.exequiel.challenge.beers.features.detail.usecase.model.BeerDetailItemModel

class BeerDetailPresenterDelegate(
    private val bindingDelegate: BeerDetailBindingDelegate
): BasePresenterDelegate(bindingDelegate) {

    fun initRemoteRequest(){
        bindingDelegate.showProgressViewPostValue()
    }

    fun onSuccessDetailMovieRequest(detailMovie: BeerDetailItemModel){
        with(bindingDelegate){
            detailMovie.let {
                showImageBackgroundPostValue(it.imageUrl)
                showTitlePostValue(it.name)
                showTaglinePostValue(it.tagline)
                showFoodParingPostValue(it.foodParing)
                showDatePostValue(it.date)
                showDescriptionPostValue(it.description)
                hideProgressViewPostValue()
            }
        }
    }

    fun onErrorRequest(){
        bindingDelegate.hideProgressViewPostValue()
    }


}