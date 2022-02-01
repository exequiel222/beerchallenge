package com.exequiel.challenge.beers.features.detail.usecase.fetchdetail

import com.exequiel.challenge.beers.core.usecase.BaseUseCase
import com.exequiel.challenge.beers.features.detail.datasource.repository.BeerDetailRepository
import com.exequiel.challenge.beers.features.detail.usecase.model.BeerDetailItemModel

class BeerDetailUseCase(
    private val beerDetailRepository: BeerDetailRepository
) : BaseUseCase<Int, BeerDetailItemModel>() {

    override suspend fun run(params: Int): BeerDetailItemModel {
        return beerDetailRepository.callGetDetail(params)
    }
}