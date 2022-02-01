package com.exequiel.challenge.beers.core.viewmodel

import androidx.lifecycle.ViewModel

abstract class BaseViewModel(
    open val bindingDelegate: BaseBindingDelegate,
    private val presentationDelegate: BasePresenterDelegate
) : ViewModel() {

}