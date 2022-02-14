package com.pawkrzysciak.cleanarchitectureexample.features.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pawkrzysciak.cleanarchitectureexample.features.data.local.model.GameInfoCached
import com.pawkrzysciak.cleanarchitectureexample.features.domain.model.GameInfo


@Dao
interface GameInfoDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun saveGames(vararg gameInfoCached: GameInfoCached)

	@Query("SELECT * FROM GameInfoCached")
	fun getGames(): List<GameInfoCached>
}
