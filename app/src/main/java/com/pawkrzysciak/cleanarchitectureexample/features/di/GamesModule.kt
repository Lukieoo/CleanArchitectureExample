package com.pawkrzysciak.cleanarchitectureexample.features.di

import com.pawkrzysciak.cleanarchitectureexample.features.GamesRepository
import com.pawkrzysciak.cleanarchitectureexample.features.data.repository.GameRepositoryImpl
import com.pawkrzysciak.cleanarchitectureexample.features.domain.GetGamesUseCase
import com.pawkrzysciak.cleanarchitectureexample.features.navigation.GameInfoNavigator
import com.pawkrzysciak.cleanarchitectureexample.features.navigation.GameInfoNavigatorImpl
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.GameAdapter
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.MainGamesFragment
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.MainGamesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val gameModule = module {

	// data
	factory<GamesRepository> { GameRepositoryImpl(get()) }

	// domain
	factory { GetGamesUseCase(get()) }

	// navigation
	//factory<GameInfoNavigator> { GameInfoNavigatorImpl(get()) }

	// presentation
	viewModel { MainGamesViewModel(get()) }
	factory { MainGamesFragment() }
	factory { GameAdapter() }
}