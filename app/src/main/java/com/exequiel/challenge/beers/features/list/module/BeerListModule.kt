package com.exequiel.challenge.beers.features.list.module

import com.exequiel.challenge.beers.core.datasource.ServiceBuilder
import com.exequiel.challenge.beers.features.list.datasource.repository.BeersListRepository
import com.exequiel.challenge.beers.features.list.datasource.service.local.BeerListLocalService
import com.exequiel.challenge.beers.features.list.datasource.service.remote.IBeersListService
import com.exequiel.challenge.beers.features.list.navigation.BeerListNavigation
import com.exequiel.challenge.beers.features.list.usecase.BeerListUseCase
import com.exequiel.challenge.beers.features.list.viewmodel.BeerListBindingDelegate
import com.exequiel.challenge.beers.features.list.viewmodel.BeerListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val beerListModule: Module =  module {
    
    //Inject viewModel
    viewModel { BeerListViewModel(bindingDelegate = get(), beerListUseCase = get()) }
    factory { providerBeerListBindingDelegate() }
    
    //Inject repository
    single {  BeersListRepository(get(), BeerListLocalService(), androidContext()) }
    
    //Inject useCase
    single { BeerListUseCase(get()) }
    
    //Inject service
    single { providerBeerListService() }

    //Routing component
    single { BeerListNavigation() }

}

fun providerBeerListBindingDelegate(): BeerListBindingDelegate {
    return BeerListBindingDelegate()
}

fun providerBeerListService(): IBeersListService {
    return ServiceBuilder.buildService(IBeersListService::class.java)
}
        