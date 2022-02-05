package com.pawkrzysciak.cleanarchitectureexample.core.app

import android.app.Application
import com.pawkrzysciak.cleanarchitectureexample.core.di.koinInjector
import org.koin.android.ext.koin.androidContext

class App : Application() {
	override fun onCreate() {
		super.onCreate()
		startKoin()
	}

	private fun startKoin() {
		org.koin.core.context.startKoin {
			androidContext(this@App)
			modules(koinInjector)
		}
	}
}