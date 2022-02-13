package com.pawkrzysciak.cleanarchitectureexample.features.presentation.details.presentation

import android.webkit.WebViewClient
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pawkrzysciak.cleanarchitectureexample.core.base.BaseViewModel
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.model.GameInfoDisplayable

class GameDetailsViewModel : BaseViewModel() {
	private val _gameInfo by lazy { MutableLiveData<GameInfoDisplayable>() }
	val gameInfo: LiveData<GameInfoDisplayable> by lazy { _gameInfo }

	fun onGameInfoDataPassed(gameInfoDisplayable: GameInfoDisplayable) {
		_gameInfo.value = gameInfoDisplayable
	}

	fun getWebViewClient(): WebViewClient {
		return WebViewClient()
	}
}