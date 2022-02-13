package com.pawkrzysciak.cleanarchitectureexample.features.navigation

import com.pawkrzysciak.cleanarchitectureexample.R
import com.pawkrzysciak.cleanarchitectureexample.core.navigation.FragmentNavigator
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.details.presentation.GameDetailsFragment
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.model.GameInfoDisplayable

class GameInfoNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : GameInfoNavigator {

	override fun openGameDetailsScreen(gameInfo: GameInfoDisplayable) {
		fragmentNavigator.navigateTo(
			R.id.action_navigate_from_character_screen_to_character_details_screen,
			GameDetailsFragment.GAME_DETAILS_KEY to gameInfo
		)
	}

	override fun goBack() {
		fragmentNavigator.goBack()
	}
}