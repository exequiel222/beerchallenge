package com.exequiel.challenge.beers.features.detail.module

import com.exequiel.challenge.beers.core.datasource.ServiceBuilder
import com.exequiel.challenge.beers.features.detail.datasource.repository.BeerDetailRepository
import com.exequiel.challenge.beers.features.detail.datasource.service.BeerDetailService
import com.exequiel.challenge.beers.features.detail.navigation.BeerDetailNavigation
import com.exequiel.challenge.beers.features.detail.usecase.fetchdetail.BeerDetailUseCase
import com.exequiel.challenge.beers.features.detail.viewmodel.BeerDetailBindingDelegate
import com.exequiel.challenge.beers.features.detail.viewmodel.BeerDetailViewModel
import com.exequiel.challenge.beers.features.list.datasource.service.local.BeerListLocalService
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val beerDetailModule: Module =  module {
    
    //Inject viewModel
    viewModel { BeerDetailViewModel(
        bindingDelegate = get(),
        beerDetailUseCase = get()
    ) }
    factory { providerMoviesListBindingDelegate() }
    
    //Inject repository
    single {  BeerDetailRepository(get(), BeerListLocalService(), androidContext()) }
    
    //Inject useCase
    single { BeerDetailUseCase(get()) }
    
    //Inject service
    single { providerMoviesListService() }

    //Routing component
    single { BeerDetailNavigation() }

}

fun providerMoviesListBindingDelegate(): BeerDetailBindingDelegate {
    return BeerDetailBindingDelegate()
}

fun providerMoviesListService(): BeerDetailService {
    return ServiceBuilder.buildService(BeerDetailService::class.java)
}
        