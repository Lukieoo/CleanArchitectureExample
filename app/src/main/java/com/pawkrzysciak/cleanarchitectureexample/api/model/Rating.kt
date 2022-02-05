package com.pawkrzysciak.cleanarchitectureexample.api.model

data class Rating(
    val count: Int,
    val id: Int,
    val percent: Double,
    val title: String
)