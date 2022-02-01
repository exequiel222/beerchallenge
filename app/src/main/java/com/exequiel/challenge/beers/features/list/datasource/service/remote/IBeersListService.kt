package com.exequiel.challenge.beers.features.list.datasource.service.remote

import com.exequiel.challenge.beers.core.datasource.TheBeerDatabaseAPI.MAX_PER_PAGE
import com.exequiel.challenge.beers.features.list.datasource.entity.BeerItemApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IBeersListService {

    @GET("beers")
    suspend fun fetchPopularBeerList(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int = MAX_PER_PAGE
    ): List<BeerItemApiResponse>
}