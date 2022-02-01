package com.exequiel.challenge.beers.features.list.datasource.repository

import android.content.Context
import com.exequiel.challenge.beers.core.datasource.TheBeerDatabaseAPI
import com.exequiel.challenge.beers.features.list.datasource.entity.BeerItemApiResponse
import com.exequiel.challenge.beers.features.list.datasource.service.local.BeerListLocalService
import com.exequiel.challenge.beers.features.list.datasource.service.remote.IBeersListService
import com.exequiel.challenge.beers.features.list.usecase.model.BeerItemModel
import com.exequiel.challenge.beers.features.list.usecase.toUseCaseModel

class BeersListRepository(
    private val beersListService: IBeersListService,
    private val beerListLocalService: BeerListLocalService,
    private val context: Context
) {

    @Throws(Exception::class)
    suspend fun callGetPopularList(page: Int): List<BeerItemModel> {
        val requestResult: List<BeerItemApiResponse>
        if(TheBeerDatabaseAPI.checkForInternet(context)){
            requestResult = beersListService.fetchPopularBeerList(page)
            beerListLocalService.writePopularBeerList(requestResult)
        }else{
            requestResult = beerListLocalService.fetchPopularBeerList(page)
        }
        return requestResult.map { it.toUseCaseModel() }
    }

}