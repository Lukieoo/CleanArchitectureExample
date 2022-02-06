package com.pawkrzysciak.cleanarchitectureexample.features.navigation

import com.pawkrzysciak.cleanarchitectureexample.features.presentation.model.GameInfoDisplayable

interface GameInfoNavigator {
	fun openGameDetailsScreen(gameInfo: GameInfoDisplayable)
	fun goBack()
}