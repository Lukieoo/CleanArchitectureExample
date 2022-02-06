package com.pawkrzysciak.cleanarchitectureexample.features.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.akademiaandroida.core.base.BaseViewModel
import com.pawkrzysciak.cleanarchitectureexample.features.domain.GetGamesUseCase
import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo
import com.pawkrzysciak.cleanarchitectureexample.features.navigation.GameInfoNavigator
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.model.GameInfoDisplayable

class MainGamesViewModel(
	private val getGamesUseCase: GetGamesUseCase
) : BaseViewModel() {
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