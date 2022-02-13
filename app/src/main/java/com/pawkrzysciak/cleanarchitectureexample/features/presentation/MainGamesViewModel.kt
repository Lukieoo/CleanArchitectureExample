package com.pawkrzysciak.cleanarchitectureexample.features.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.pawkrzysciak.cleanarchitectureexample.core.base.BaseViewModel
import com.pawkrzysciak.cleanarchitectureexample.core.exeption.ErrorMapper
import com.pawkrzysciak.cleanarchitectureexample.features.domain.GetGamesUseCase
import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo
import com.pawkrzysciak.cleanarchitectureexample.features.navigation.GameInfoNavigator
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.model.GameInfoDisplayable

class MainGamesViewModel(
	private val getGamesUseCase: GetGamesUseCase,
	private val gameInfoNavigator: GameInfoNavigator,
	errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {
	private val _gameInfo by lazy {
		MutableLiveData<List<GameInfo>>()
			.also { getGameInfo(it) }
	}

	val gameInfo by lazy {
		_gameInfo.map { gameInfo ->
			gameInfo.map { GameInfoDisplayable(it) }
		}
	}

	private fun getGameInfo(gameInfoLiveData: MutableLiveData<List<GameInfo>>) {
		setPendingState()
		getGamesUseCase(
			params = Unit,
			scope = viewModelScope
		) { result ->
			setIdleState()
			result.onSuccess { gameInfoLiveData.value = it }
			result.onFailure { handleFailure(it) }
		}
	}

}