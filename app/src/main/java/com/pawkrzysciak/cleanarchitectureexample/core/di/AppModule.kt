package com.pawkrzysciak.cleanarchitectureexample.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.pawkrzysciak.cleanarchitectureexample.R
import com.pawkrzysciak.cleanarchitectureexample.core.exeption.ErrorMapper
import com.pawkrzysciak.cleanarchitectureexample.core.exeption.ErrorMapperImpl
import com.pawkrzysciak.cleanarchitectureexample.core.exeption.ErrorWrapper
import com.pawkrzysciak.cleanarchitectureexample.core.exeption.ErrorWrapperImpl
import com.pawkrzysciak.cleanarchitectureexample.core.navigation.FragmentNavigator
import com.pawkrzysciak.cleanarchitectureexample.core.navigation.FragmentNavigatorImpl
import com.pawkrzysciak.cleanarchitectureexample.core.network.NetworkStateProvider
import com.pawkrzysciak.cleanarchitectureexample.core.network.NetworkStateProviderImpl
import com.pawkrzysciak.cleanarchitectureexample.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
	factory { LinearLayoutManager(androidContext()) }
	factory { GridLayoutManager(androidContext(), 2) }
	factory { DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL) }


	factory {
		androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
	}
	factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
	factory<ErrorWrapper> { ErrorWrapperImpl() }
	factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
	single(createdAtStart = true) { ActivityProvider(androidApplication()) }

	factory<FragmentNavigator> {
		FragmentNavigatorImpl(
			activityProvider = get(),
			navHostFragmentRes = R.id.nav_host_fragment,
			homeDestinationRes = R.id.main,
			defaultNavOptions = get()
		)
	}
	factory {
		navOptions {}
	}
}