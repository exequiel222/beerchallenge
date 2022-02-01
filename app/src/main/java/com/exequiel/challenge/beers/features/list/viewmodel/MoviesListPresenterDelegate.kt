package com.exequiel.challenge.beers.features.list.viewmodel

import com.exequiel.challenge.beers.core.viewmodel.BasePresenterDelegate
import com.exequiel.challenge.beers.features.list.usecase.model.BeerItemModel

class MoviesListPresenterDelegate(
    private val bindingDelegate: BeerListBindingDelegate
): BasePresenterDelegate(bindingDelegate) {

    fun initRemoteRequest(){
        bindingDelegate.showProgressViewPostValue()
    }

    fun onSuccessRequest(listItems: List<BeerItemModel>){
        if (listItems.isNotEmpty())
            bindingDelegate.updateListItemsPostValue(listItems)
        bindingDelegate.hideProgressViewPostValue()
    }

    fun onErrorRequest(){
        bindingDelegate.hideProgressViewPostValue()
    }
}