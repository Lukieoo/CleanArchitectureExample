package com.pawkrzysciak.cleanarchitectureexample.features.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import com.pawkrzysciak.cleanarchitectureexample.BR
import com.pawkrzysciak.cleanarchitectureexample.R
import com.pawkrzysciak.cleanarchitectureexample.core.base.BaseFragment
import com.pawkrzysciak.cleanarchitectureexample.databinding.FragmentMainGamesBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainGamesFragment : BaseFragment<MainGamesViewModel, FragmentMainGamesBinding>(
	BR.viewModel, R.layout.fragment_main_games
) {

	override val viewModel: MainGamesViewModel by viewModel()
	private val gameAdapter: GameAdapter by inject()
	private val divider: DividerItemDecoration by inject()

	override fun initViews(binding: FragmentMainGamesBinding) {
		super.initViews(binding)
		initRecycler(binding)
	}

	override fun onDestroyView() {
		binding?.recyclerViewGames?.let {
			it.layoutManager = null
			it.adapter = null
		}
		super.onDestroyView()
	}

	private fun initRecycler(binding: FragmentMainGamesBinding) {
		with(binding.recyclerViewGames) {
			addItemDecoration(divider)
			setHasFixedSize(true)
			adapter = gameAdapter
		}
	}

	override fun initObservers() {
		super.initObservers()
		observeGames()
	}

	private fun observeGames() {
		viewModel.gameInfo.observe(this) {
			gameAdapter.setItems(it)
		}
	}
}