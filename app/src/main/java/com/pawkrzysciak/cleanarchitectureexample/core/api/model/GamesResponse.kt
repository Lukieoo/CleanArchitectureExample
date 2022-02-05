package com.pawkrzysciak.cleanarchitectureexample.core.api.model

import com.google.gson.annotations.SerializedName

data class GamesResponse(
    @SerializedName("results") val results: List<ResultRemote>,
)