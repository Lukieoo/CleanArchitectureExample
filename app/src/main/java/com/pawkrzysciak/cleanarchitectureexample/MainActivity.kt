package com.pawkrzysciak.cleanarchitectureexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.pawkrzysciak.cleanarchitectureexample.core.api.GamesFromApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

	//val gamesFromApi: GamesFromApi by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val navHostFragment: NavHostFragment = supportFragmentManager
			.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

		navHostFragment.findNavController().setGraph(R.navigation.nav_menu)
//		GlobalScope.launch {
//			getApi()
//		}
	}
//
//	private suspend fun getApi() {
//		withContext(Dispatchers.Main) {
//			val result = getGamesFromApi()
//			Log.e("TAG", "getApi: $result")
//		}
//	}
//
//	private suspend fun getGamesFromApi() = gamesFromApi.getTopGames()
}