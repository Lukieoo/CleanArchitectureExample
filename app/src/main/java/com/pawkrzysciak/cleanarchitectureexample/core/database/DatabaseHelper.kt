package com.pawkrzysciak.cleanarchitectureexample.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pawkrzysciak.cleanarchitectureexample.features.data.local.GameInfoDao
import com.pawkrzysciak.cleanarchitectureexample.features.data.local.model.GameInfoCached

@Database(
	entities = [GameInfoCached::class],
	version = 1
)

@TypeConverters(ListConverter::class)
abstract class DatabaseHelper : RoomDatabase() {

	abstract fun gameInfoDao(): GameInfoDao
}