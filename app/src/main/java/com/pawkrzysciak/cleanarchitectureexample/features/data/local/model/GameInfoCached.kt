package com.pawkrzysciak.cleanarchitectureexample.features.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo

@Entity
data class GameInfoCached(
	@PrimaryKey
	val id: Int,
	val background_image: String,
	val name: String,
) {
	constructor(gameInfo: GameInfo) : this(
		gameInfo.id,
		gameInfo.name,
		gameInfo.background_image,
	)

	companion object

	fun toGameInfo() = GameInfo(
		id = id,
		name = name,
		background_image = background_image
	)
}