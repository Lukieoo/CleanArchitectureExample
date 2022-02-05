package com.pawkrzysciak.cleanarchitectureexample.core.api

import com.pawkrzysciak.cleanarchitectureexample.utils.API_KEY
import com.pawkrzysciak.cleanarchitectureexample.core.api.model.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesFromApi {
	@GET("/api/games")
	suspend fun getTopGames(@Query("key") key: String = API_KEY): GamesResponse
}