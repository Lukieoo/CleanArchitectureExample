package com.pawkrzysciak.cleanarchitectureexample.features.data.repository

import com.pawkrzysciak.cleanarchitectureexample.core.api.GamesFromApi
import com.pawkrzysciak.cleanarchitectureexample.features.GamesRepository
import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo

class GameRepositoryImpl(
	private val api: GamesFromApi,
) : GamesRepository {
	override suspend fun getGames(): List<GameInfo> {
		return api.getTopGames().results
			.map { it.toGameInfo() }
	}
}