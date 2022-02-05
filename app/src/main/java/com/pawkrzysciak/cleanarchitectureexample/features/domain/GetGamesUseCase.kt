package com.pawkrzysciak.cleanarchitectureexample.features.domain

import com.pawkrzysciak.cleanarchitectureexample.core.base.UseCase
import com.pawkrzysciak.cleanarchitectureexample.features.GamesRepository
import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo

class GetGamesUseCase(private val gamesRepository: GamesRepository) :
	UseCase<List<GameInfo>, Unit>() {
	override suspend fun action(params: Unit): List<GameInfo> {
		return gamesRepository.getGames()
	}
}