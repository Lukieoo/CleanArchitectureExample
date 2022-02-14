package com.pawkrzysciak.cleanarchitectureexample.core.di

import com.pawkrzysciak.cleanarchitectureexample.features.di.gameModule
import org.koin.core.module.Module

val koinInjector: List<Module> = listOf(
	networkModule,
	appModule,
	gameModule,
	databaseModule
)