package com.exequiel.challenge.beers.features.list.datasource.entity

import com.google.gson.annotations.SerializedName

data class BeerItemApiResponse(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("tagline")
    var tagline: String,

    @SerializedName("first_brewed")
    var first_brewed: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("image_url")
    var image_url: String,

    @SerializedName("abv")
    var abv: Double?,

    @SerializedName("ibu")
    var ibu: Double?,

    @SerializedName("target_fg")
    var target_fg: Double?,

    @SerializedName("target_og")
    var target_og: Double?,

    @SerializedName("attenuation_level")
    var attenuation_level: Double?,

    @SerializedName("ebc")
    var ebc: Double?,

    @SerializedName("srm")
    var srm: Double?,

    @SerializedName("ph")
    var ph: Double?,

    @SerializedName("brewers_tips")
    var brewers_tips: String?,

    @SerializedName("contributed_by")
    var contributed_by: String?,

    @SerializedName("food_pairing")
    var foodPairing: List<String>
)
