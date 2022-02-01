package com.exequiel.challenge.beers.features.detail.navigation

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentActivity

class BeerDetailNavigation {
    fun goToYoutubeVideo(activity: FragmentActivity, uri: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        activity.startActivity(intent)
    }
}