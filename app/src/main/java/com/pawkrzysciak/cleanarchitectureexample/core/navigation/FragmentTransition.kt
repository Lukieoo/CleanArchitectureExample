package com.pawkrzysciak.cleanarchitectureexample.core.navigation

interface FragmentTransition {
    val enterAnim: Int
    val exitAnim: Int
    val popEnterAnim: Int
    val popExitAnim: Int
}