package com.exequiel.challenge.beers.features.detail.datasource.repository

import android.content.Context
import com.exequiel.challenge.beers.core.datasource.TheBeerDatabaseAPI
import com.exequiel.challenge.beers.features.detail.datasource.service.BeerDetailService
import com.exequiel.challenge.beers.features.detail.usecase.model.BeerDetailItemModel
import com.exequiel.challenge.beers.features.list.datasource.entity.BeerItemApiResponse
import com.exequiel.challenge.beers.features.list.datasource.service.local.BeerListLocalService
import com.exequiel.challenge.beers.features.list.usecase.toUseCaseDetailModel

class BeerDetailRepository(
    private val beerDetailService: BeerDetailService,
    private val beerListLocalService: BeerListLocalService,
    private val context: Context
) {

    @Throws(Exception::class)
    suspend fun callGetDetail(id: Int): BeerDetailItemModel {
        val requestResult: List<BeerItemApiResponse>
        if(TheBeerDatabaseAPI.checkForInternet(context)){
            requestResult = beerDetailService.fetchDetails(id)
        }else{
            requestResult = beerListLocalService.fetchPopularBeerForId(id)
        }
        return requestResult.first().toUseCaseDetailModel()
    }
}