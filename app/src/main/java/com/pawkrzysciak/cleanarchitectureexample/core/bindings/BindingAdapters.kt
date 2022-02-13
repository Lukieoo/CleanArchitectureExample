package com.pawkrzysciak.cleanarchitectureexample.core.bindings

import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pawkrzysciak.cleanarchitectureexample.core.adapter.BindableAdapter
import com.pawkrzysciak.cleanarchitectureexample.core.base.UiState


object BindingAdapters {

	@BindingAdapter("app:showOnPendingState")
	@JvmStatic
	fun showOnPendingState(progressBar: ProgressBar, uiState: UiState) {
		progressBar.visibility = if (uiState == UiState.Pending) View.VISIBLE else View.INVISIBLE
	}

	@BindingAdapter("app:items")
	@JvmStatic
	fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {
		if (items.isNullOrEmpty()) return
		(recyclerView.adapter as? BindableAdapter<T>)?.setItems(items)
	}

	@BindingAdapter("setWebViewClient")
	@JvmStatic
	fun setWebViewClient(view: WebView, client: WebViewClient?) {
		view.webViewClient = client!!
	}

	@BindingAdapter("webViewUrl")
	@JvmStatic
	fun WebView.updateUrl(url: String?) {
		url?.let {
			loadUrl(url)
		}
	}
}