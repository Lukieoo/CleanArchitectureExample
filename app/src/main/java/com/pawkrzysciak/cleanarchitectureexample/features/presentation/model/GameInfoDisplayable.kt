package com.pawkrzysciak.cleanarchitectureexample.features.presentation.model

import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo

data class GameInfoDisplayable(
	val background_image: String,
	val name: String,
) {
	constructor(
		gameInfo: GameInfo
	) : this(
		background_image = gameInfo.background_image,
		name = gameInfo.name
	)
}