package com.exequiel.challenge.beers.features.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exequiel.challenge.beers.core.viewmodel.BaseBindingDelegate
import com.exequiel.challenge.beers.core.viewmodel.Event

class BeerDetailBindingDelegate : BaseBindingDelegate() {
    //region showImageBackground
    private val _showImageBackground = MutableLiveData<Event<String>>()
    val showImageBackground: LiveData<Event<String>> get() = _showImageBackground
    fun showImageBackgroundPostValue(urlImage: String) {
        _showImageBackground.value = Event(urlImage)
    }
    //endregion

    //region showTitle
    private val _showTitle = MutableLiveData<Event<String>>()
    val showTitle: LiveData<Event<String>> get() = _showTitle
    fun showTitlePostValue(text: String) {
        _showTitle.value = Event(text)
    }
    //endregion

    //region showTagline
    private val _showTagline = MutableLiveData<Event<String>>()
    val showTagline: LiveData<Event<String>> get() = _showTagline
    fun showTaglinePostValue(text: String) {
        _showTagline.value = Event(text)
    }
    //endregion

    //region showDate
    private val _showDate = MutableLiveData<Event<String>>()
    val showDate: LiveData<Event<String>> get() = _showDate
    fun showDatePostValue(text: String) {
        _showDate.value = Event(text)
    }
    //endregion

    //region showFoodParing
    private val _showFoodParing = MutableLiveData<Event<String>>()
    val showFoodParing: LiveData<Event<String>> get() = _showFoodParing
    fun showFoodParingPostValue(text: String) {
        _showFoodParing.value = Event(text)
    }
    //endregion

    //region showDescription
    private val _showDescription = MutableLiveData<Event<String>>()
    val showDescription: LiveData<Event<String>> get() = _showDescription
    fun showDescriptionPostValue(text: String) {
        _showDescription.value = Event(text)
    }
    //endregion
}