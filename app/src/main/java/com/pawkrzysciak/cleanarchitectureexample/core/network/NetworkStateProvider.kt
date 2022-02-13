package com.pawkrzysciak.cleanarchitectureexample.core.network

interface NetworkStateProvider {

    fun isNetworkAvailable(): Boolean

}