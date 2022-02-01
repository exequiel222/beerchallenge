package com.exequiel.challenge.beers.core

interface BasePageListResponse<T> {
    var page: Int
    var results: List<T>
}

interface BaseListResponse<T> {
    var results: List<T>
}