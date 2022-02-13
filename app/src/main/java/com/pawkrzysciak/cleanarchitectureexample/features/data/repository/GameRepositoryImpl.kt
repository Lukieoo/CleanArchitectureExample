package com.pawkrzysciak.cleanarchitectureexample.features.data.repository

import com.pawkrzysciak.cleanarchitectureexample.core.api.GamesFromApi
import com.pawkrzysciak.cleanarchitectureexample.core.exeption.ErrorWrapper
import com.pawkrzysciak.cleanarchitectureexample.core.exeption.callOrThrow
import com.pawkrzysciak.cleanarchitectureexample.core.network.NetworkStateProvider
import com.pawkrzysciak.cleanarchitectureexample.features.GamesRepository
import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo

class GameRepositoryImpl(
	private val api: GamesFromApi,
	private val networkStateProvider: NetworkStateProvider,
	private val errorWrapper: ErrorWrapper
) : GamesRepository {
	override suspend fun getGames(): List<GameInfo> {
		return if (networkStateProvider.isNetworkAvailable()) {
			callOrThrow(errorWrapper) {
				getGameInfoFromRemote()
			}
				.also {
					//saveCharactersToLocal(it)
				}
		} else {
			arrayListOf()
			//getCharactersFromLocal()
		}
	}

	private suspend fun getGameInfoFromRemote(): List<GameInfo> {
		return api.getTopGames()
			.results
			.map { it.toGameInfo() }
			.also {
				//saveCharactersToLocal(it)
			}
	}

/*
	private suspend fun saveCharactersToLocal(characters: List<GameInfo>) {
		characters.map { CharacterCached(it) }
			.toTypedArray()
			.let { charactersDao.saveCharacters(*it) }
	}
	private suspend fun getCharactersFromLocal(): List<GameInfo> {
		return charactersDao.getCharacters()
			.map { it.toCharacter() }
	}*/
}