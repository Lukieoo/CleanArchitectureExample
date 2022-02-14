package com.pawkrzysciak.cleanarchitectureexample.core.api.model

import com.google.gson.annotations.SerializedName
import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo

data class GameInfoRemote(
	@SerializedName("background_image") val background_image: String,
	@SerializedName("name") val name: String,
	@SerializedName("id") val id: Int,
) {
	companion object

	fun toGameInfo() =
		GameInfo(
			background_image = background_image,
			name = name,
			id = id
		)
}