package com.exequiel.challenge.beers.features.detail.datasource.service

import com.exequiel.challenge.beers.features.list.datasource.entity.BeerItemApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BeerDetailService {

    @GET("beers/{id}")
    suspend fun fetchDetails(@Path("id") id: Int): List<BeerItemApiResponse>

}