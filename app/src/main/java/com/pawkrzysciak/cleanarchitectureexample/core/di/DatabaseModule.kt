package com.pawkrzysciak.cleanarchitectureexample.core.di

import androidx.room.Room
import com.pawkrzysciak.cleanarchitectureexample.core.database.DatabaseHelper
import com.pawkrzysciak.cleanarchitectureexample.utils.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

	single {
		Room.databaseBuilder(
			androidContext(),
			DatabaseHelper::class.java,
			DATABASE_NAME
		).build()
	}

	single { get<DatabaseHelper>().gameInfoDao() }
}