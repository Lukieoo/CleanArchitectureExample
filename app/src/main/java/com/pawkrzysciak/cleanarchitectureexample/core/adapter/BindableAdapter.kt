package com.pawkrzysciak.cleanarchitectureexample.core.adapter

interface BindableAdapter<T> {

    fun setItems(items: List<T>)
}