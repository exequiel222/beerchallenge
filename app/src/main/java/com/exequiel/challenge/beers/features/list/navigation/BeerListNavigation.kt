package com.exequiel.challenge.beers.features.list.navigation

import android.view.View
import androidx.navigation.Navigation
import com.exequiel.challenge.beers.features.list.view.BeerListFragmentDirections

class BeerListNavigation {
    fun goToDetailMovie(view: View, id: Int){
        val action = BeerListFragmentDirections.actionBeerListEntryToBeerDetailEntry(id)
        Navigation.findNavController(view).navigate(action)
    }
}