package com.pawkrzysciak.cleanarchitectureexample.api

import com.pawkrzysciak.cleanarchitectureexample.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesFromApi {
	@GET("/api/games")
	suspend fun getTopGames(@Query("key") key: String = API_KEY)
}