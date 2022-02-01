package com.exequiel.challenge.beers.features.list.datasource.service.local

import com.exequiel.challenge.beers.core.datasource.TheBeerDatabaseAPI.MAX_PER_PAGE
import com.exequiel.challenge.beers.features.list.datasource.entity.BeerItemApiResponse
import io.paperdb.Paper

class BeerListLocalService {

    companion object{
        const val KEY_LIST_BEER =  "listBeers"
    }

    fun writePopularBeerList(listBeers: List<BeerItemApiResponse>){
        val localList = Paper.book().read(KEY_LIST_BEER, emptyList<BeerItemApiResponse>())!!
        Paper.book().write(KEY_LIST_BEER, getUniqueList(localList, listBeers))
    }

    fun fetchPopularBeerList(page: Int): List<BeerItemApiResponse> {
        val allElements = Paper.book().read(KEY_LIST_BEER, emptyList<BeerItemApiResponse>())!!
        val fromIndex = 0 + (page-1) * MAX_PER_PAGE
        var toIndex = fromIndex + MAX_PER_PAGE
        if(allElements.isNullOrEmpty() && toIndex > allElements.lastIndex){
            toIndex = allElements.lastIndex
        }
        return allElements.subList(fromIndex, toIndex)
    }

    fun fetchPopularBeerForId(id: Int): List<BeerItemApiResponse> {
        val allElements = Paper.book().read(KEY_LIST_BEER, emptyList<BeerItemApiResponse>())!!
        val result = allElements.filter { it.id == id }
        //Omito el escenario en el caso de que llegue un id no existente en la db
        return result
    }

    private fun getUniqueList(
        listBeersA: List<BeerItemApiResponse>,
        listBeersB: List<BeerItemApiResponse>
    ): List<BeerItemApiResponse>{
        val sum = listBeersA + listBeersB
        return sum.distinctBy { it.id }
    }
}