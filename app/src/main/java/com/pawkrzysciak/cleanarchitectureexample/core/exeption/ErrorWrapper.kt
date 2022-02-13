package com.pawkrzysciak.cleanarchitectureexample.core.exeption

interface ErrorWrapper {

    fun wrap(throwable: Throwable): Throwable
}