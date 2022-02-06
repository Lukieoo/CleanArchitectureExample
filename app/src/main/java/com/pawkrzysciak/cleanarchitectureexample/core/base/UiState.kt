package com.pawkrzysciak.cleanarchitectureexample.core.base

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}