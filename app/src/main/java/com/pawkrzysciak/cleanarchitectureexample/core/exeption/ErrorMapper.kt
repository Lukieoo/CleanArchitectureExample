package com.pawkrzysciak.cleanarchitectureexample.core.exeption

interface ErrorMapper {
    fun map(throwable: Throwable): String
}