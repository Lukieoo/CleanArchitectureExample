package com.pawkrzysciak.cleanarchitectureexample.core.api.model

import com.google.gson.annotations.SerializedName

data class ResultRemote(
    @SerializedName("background_image") val background_image: String,
    @SerializedName("name") val name: String,
)