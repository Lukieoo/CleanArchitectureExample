package com.pawkrzysciak.cleanarchitectureexample.features.presentation.model

import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class GameInfoDisplayable(
	val background_image: String,
	val name: String,
) : Parcelable {
	constructor(
		gameInfo: GameInfo
	) : this(
		background_image = gameInfo.background_image,
		name = gameInfo.name
	)
}