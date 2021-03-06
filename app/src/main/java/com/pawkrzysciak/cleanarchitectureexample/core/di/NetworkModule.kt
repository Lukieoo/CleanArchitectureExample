package com.pawkrzysciak.cleanarchitectureexample.core.di

import com.pawkrzysciak.cleanarchitectureexample.core.api.GamesFromApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
	single<Interceptor> {
		HttpLoggingInterceptor()
			.apply {
				level =
					if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
					else HttpLoggingInterceptor.Level.NONE
			}
	}
	single {
		OkHttpClient.Builder()
			.addInterceptor(get<Interceptor>())
			.build()
	}

	single {
		Retrofit.Builder()
			.baseUrl("https://api.rawg.io")
			.addConverterFactory(GsonConverterFactory.create())
			.client(get<OkHttpClient>())
			.build()
	}
	single {
		get<Retrofit>().create(GamesFromApi::class.java)
	}
}
