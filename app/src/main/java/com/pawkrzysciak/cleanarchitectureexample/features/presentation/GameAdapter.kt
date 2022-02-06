package com.pawkrzysciak.cleanarchitectureexample.features.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pawkrzysciak.cleanarchitectureexample.core.adapter.BindableAdapter
import com.pawkrzysciak.cleanarchitectureexample.databinding.GameItemBinding
import com.pawkrzysciak.cleanarchitectureexample.features.presentation.model.GameInfoDisplayable

class GameAdapter : BindableAdapter<GameInfoDisplayable>,
    RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    var listener: ((GameInfoDisplayable) -> Unit)? = null
    private val games by lazy {
        mutableListOf<GameInfoDisplayable>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GameItemBinding.inflate(inflater, parent, false)

        return GameViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.bind(game, listener)
    }

    override fun setItems(items: List<GameInfoDisplayable>) {
        if (items.isNotEmpty()) {
            this.games.clear()
        }

        this.games.addAll(items)
        notifyDataSetChanged()
    }

    fun setOnGameClickListener(listener: (GameInfoDisplayable) -> Unit) {
        this.listener = listener
    }

    inner class GameViewHolder(private val binding: GameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            gameInfo: GameInfoDisplayable,
            listener: ((GameInfoDisplayable) -> Unit)?
        ) {
            with(binding) {
                binding.item = gameInfo
                listener?.let { root.setOnClickListener { it(gameInfo) } }
                binding.executePendingBindings()
            }
        }
    }
}