package com.pawkrzysciak.cleanarchitectureexample.features.navigation

import com.pawkrzysciak.cleanarchitectureexample.R
import com.pawkrzysciak.cleanarchitectureexample.core.navigation.FragmentNavigator
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.model.GameInfoDisplayable

class GameInfoNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : GameInfoNavigator {

	override fun openGameDetailsScreen(gameInfo: GameInfoDisplayable) {

	}

	override fun goBack() {
		fragmentNavigator.goBack()
	}
}