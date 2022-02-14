package com.pawkrzysciak.cleanarchitectureexample.features.data.repository

import com.pawkrzysciak.cleanarchitectureexample.core.api.GamesFromApi
import com.pawkrzysciak.cleanarchitectureexample.core.exeption.ErrorWrapper
import com.pawkrzysciak.cleanarchitectureexample.core.exeption.callOrThrow
import com.pawkrzysciak.cleanarchitectureexample.core.network.NetworkStateProvider
import com.pawkrzysciak.cleanarchitectureexample.features.GamesRepository
import com.pawkrzysciak.cleanarchitectureexample.features.data.local.GameInfoDao
import com.pawkrzysciak.cleanarchitectureexample.features.data.local.model.GameInfoCached
import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo

class GameRepositoryImpl(
	private val api: GamesFromApi,
	private val gameInfoDao: GameInfoDao,
	private val networkStateProvider: NetworkStateProvider,
	private val errorWrapper: ErrorWrapper
) : GamesRepository {
	override suspend fun getGames(): List<GameInfo> {
		return if (networkStateProvider.isNetworkAvailable()) {
			callOrThrow(errorWrapper) {
				getGameInfoFromRemote()
			}
				.also {
					saveGamesToLocal(it)
				}
		} else {
			getCharactersFromLocal()
		}
	}

	private suspend fun getGameInfoFromRemote(): List<GameInfo> {
		return api.getTopGames()
			.results
			.map { it.toGameInfo() }
			.also {
				saveGamesToLocal(it)
			}
	}

	private suspend fun saveGamesToLocal(games: List<GameInfo>) {
		games.map { GameInfoCached(it) }
			.toTypedArray()
			.let { gameInfoDao.saveGames(*it) }
	}

	private suspend fun getCharactersFromLocal(): List<GameInfo> {
		return gameInfoDao.getGames()
			.map { it.toGameInfo() }
	}
}