package com.exequiel.challenge.beers.features.detail.usecase.model

data class BeerDetailItemModel(
    val id: Int,
    val name: String,
    val tagline: String,
    val imageUrl: String,
    val date: String,
    val foodParing: String,
    val description: String
)

