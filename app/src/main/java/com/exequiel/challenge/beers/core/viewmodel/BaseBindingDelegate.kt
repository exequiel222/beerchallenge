package com.exequiel.challenge.beers.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class BaseBindingDelegate{
    //region Generic actions
    //region Show progress view
    private val _showProgressView = MutableLiveData<Event<Unit>>()
    val showProgressView: LiveData<Event<Unit>> get() = _showProgressView
    fun showProgressViewPostValue() {
        _showProgressView.postValue(Event(Unit))
    }
    //endregion
    //region Hide progress view
    private val _hideProgressView = MutableLiveData<Event<Unit>>()
    val hideProgressView: LiveData<Event<Unit>> get() = _hideProgressView
    fun hideProgressViewPostValue() {
        _hideProgressView.postValue(Event(Unit))
    }
    //endregion
    //region Show Error Internet Connection
    private val _showErrorInternetConnection = MutableLiveData<Event<Unit>>()
    val showErrorInternetConnection: LiveData<Event<Unit>> get() = _showErrorInternetConnection
    fun showErrorInternetConnectionPostValue() {
        _showErrorInternetConnection.postValue(Event(Unit))
    }
    //endregion
    //region Hide Error Internet Connection
    private val _hideErrorInternetConnection = MutableLiveData<Event<Unit>>()
    val hideErrorInternetConnection: LiveData<Event<Unit>> get() = _hideErrorInternetConnection
    fun hideErrorInternetConnectionPostValue() {
        _hideErrorInternetConnection.postValue(Event(Unit))
    }
    //endregion
    //region Show Generic error
    private val _showGenericError = MutableLiveData<Event<String>>()
    val showGenericError: LiveData<Event<String>> get() = _showGenericError
    fun showGenericErrorPostValue(text: String) {
        _showGenericError.postValue(Event(text))
    }
    //endregion
    //region Hide Generic error
    private val _hideGenericError = MutableLiveData<Event<Unit>>()
    val hideGenericError: LiveData<Event<Unit>> get() = _hideGenericError
    fun hideGenericErrorPostValue() {
        _hideGenericError.postValue(Event(Unit))
    }
    //endregion
    //endregion
}