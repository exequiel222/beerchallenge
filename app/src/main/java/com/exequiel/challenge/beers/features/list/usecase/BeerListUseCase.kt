package com.exequiel.challenge.beers.features.list.usecase

import com.exequiel.challenge.beers.core.usecase.BaseUseCase
import com.exequiel.challenge.beers.features.list.datasource.repository.BeersListRepository
import com.exequiel.challenge.beers.features.list.usecase.model.BeerItemModel

class BeerListUseCase(
    private val beersListRepository: BeersListRepository
) : BaseUseCase<Int, List<BeerItemModel>>() {

    override suspend fun run(params: Int): List<BeerItemModel> {
        return beersListRepository.callGetPopularList(params)
    }
}