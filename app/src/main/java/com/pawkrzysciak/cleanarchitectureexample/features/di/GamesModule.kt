package com.pawkrzysciak.cleanarchitectureexample.features.di

import android.webkit.WebView
import com.pawkrzysciak.cleanarchitectureexample.features.GamesRepository
import com.pawkrzysciak.cleanarchitectureexample.features.data.repository.GameRepositoryImpl
import com.pawkrzysciak.cleanarchitectureexample.features.domain.GetGamesUseCase
import com.pawkrzysciak.cleanarchitectureexample.features.navigation.GameInfoNavigator
import com.pawkrzysciak.cleanarchitectureexample.features.navigation.GameInfoNavigatorImpl
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.GameAdapter
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.MainGamesFragment
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.MainGamesViewModel
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.details.presentation.GameDetailsFragment
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.details.presentation.GameDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val gameModule = module {

	// data
	factory<GamesRepository> { GameRepositoryImpl(get(), get(), get(), get()) }

	// domain
	factory { GetGamesUseCase(get()) }

	// navigation
	factory<GameInfoNavigator> { GameInfoNavigatorImpl(get()) }

	// presentation
	viewModel { MainGamesViewModel(get(), get(), get()) }
	factory { MainGamesFragment() }
	factory { GameAdapter() }
	viewModel { GameDetailsViewModel() }
	factory { GameDetailsFragment() }
}