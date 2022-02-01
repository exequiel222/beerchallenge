package com.exequiel.challenge.beers.core

import com.exequiel.challenge.beers.core.viewmodel.Event

/**
 * Interface for basic actions for View
 */
interface BaseViewActionsInterface{
    /**
     * Initialize views
     */
    fun viewOnReady() {
        //Sometimes there is nothing to bind
        //that's why the default behavior
    }

    /**
     * Set observers on ViewModel
     */
    fun bindObserversToLiveData() {
        //Sometimes there is nothing to bind
        //that's why the default behavior
    }

    //region Generic actions
    //region Progress view
    fun showProgressView(event: Event<Unit>){}
    fun hideProgressView(event: Event<Unit>){}
    //endregion
    //region Internet Connection Error
    /**
     * We show default view
     * to when internet connection is out
     */
    fun showErrorInternetConnection(event: Event<Unit>){}
    fun hideErrorInternetConnection(event: Event<Unit>){}
    //endregion
    //endregion
}
