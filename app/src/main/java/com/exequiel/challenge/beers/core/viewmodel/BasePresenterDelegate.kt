package com.exequiel.challenge.beers.core.viewmodel

abstract class BasePresenterDelegate(private val bindingDelegate: BaseBindingDelegate) {

    fun showGenericError() {
        bindingDelegate.hideProgressViewPostValue()
        bindingDelegate.hideErrorInternetConnectionPostValue()
        bindingDelegate.hideGenericErrorPostValue()
    }

    fun hideGenericError() {
        bindingDelegate.hideProgressViewPostValue()
        bindingDelegate.hideErrorInternetConnectionPostValue()
        bindingDelegate.hideGenericErrorPostValue()
    }

    fun showInternetConnectionError() {
        bindingDelegate.showErrorInternetConnectionPostValue()
    }

    fun hideInternetConnectionError() {
        bindingDelegate.hideProgressViewPostValue()
        bindingDelegate.hideErrorInternetConnectionPostValue()
        bindingDelegate.hideGenericErrorPostValue()
    }

    fun showProgressView() {
        bindingDelegate.showProgressViewPostValue()
    }

    fun hideProgressView() {
        bindingDelegate.hideProgressViewPostValue()
    }

}