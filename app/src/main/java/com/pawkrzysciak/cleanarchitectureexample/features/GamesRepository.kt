package com.pawkrzysciak.cleanarchitectureexample.features

import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo

interface GamesRepository {
	suspend fun getGames(): List<GameInfo>
}