package com.exequiel.challenge.beers.features.list.usecase

import com.exequiel.challenge.beers.features.detail.usecase.model.BeerDetailItemModel
import com.exequiel.challenge.beers.features.list.datasource.entity.BeerItemApiResponse
import com.exequiel.challenge.beers.features.list.usecase.model.BeerItemModel

fun BeerItemApiResponse.toUseCaseModel() = BeerItemModel(
        id = id,
        name = name,
        tagline = tagline,
        imageUrl = image_url
)

fun BeerItemApiResponse.toUseCaseDetailModel() = BeerDetailItemModel(
        id = id,
        name = name,
        tagline = tagline,
        imageUrl = image_url,
        date = first_brewed,
        foodParing = foodPairing.joinToString(separator = ", "),
        description = description
)