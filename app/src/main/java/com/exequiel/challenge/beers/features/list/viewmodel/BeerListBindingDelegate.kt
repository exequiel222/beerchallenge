package com.exequiel.challenge.beers.features.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exequiel.challenge.beers.core.viewmodel.BaseBindingDelegate
import com.exequiel.challenge.beers.core.viewmodel.Event
import com.exequiel.challenge.beers.features.list.usecase.model.BeerItemModel

class BeerListBindingDelegate : BaseBindingDelegate() {
    //region updateListItems
    private val _updateListItems = MutableLiveData<Event<List<BeerItemModel>>>()
    val updateListItems: LiveData<Event<List<BeerItemModel>>> get() = _updateListItems
    fun updateListItemsPostValue(listItems: List<BeerItemModel>) {
        _updateListItems.value = Event(listItems)
    }
    //endregion
}