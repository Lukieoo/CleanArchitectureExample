package com.pawkrzysciak.cleanarchitectureexample.features.presentation.details.presentation

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.pawkrzysciak.cleanarchitectureexample.BR
import com.pawkrzysciak.cleanarchitectureexample.R
import com.pawkrzysciak.cleanarchitectureexample.core.base.BaseFragment
import com.pawkrzysciak.cleanarchitectureexample.databinding.FragmentGameDetailsBinding
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.model.GameInfoDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameDetailsFragment : BaseFragment<GameDetailsViewModel, FragmentGameDetailsBinding>(
	BR.viewModel,
	R.layout.fragment_game_details
) {

	companion object {
		const val GAME_DETAILS_KEY = "game_details_key"
	}
	override val viewModel: GameDetailsViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		notifyAboutData()
	}

	private fun notifyAboutData() {
		arguments
			?.getParcelable<GameInfoDisplayable>(GAME_DETAILS_KEY)
			?.let { viewModel.onGameInfoDataPassed(it) }
	}

}