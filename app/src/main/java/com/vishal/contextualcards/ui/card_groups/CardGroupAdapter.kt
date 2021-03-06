package com.vishal.contextualcards.ui.card_groups

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vishal.contextualcards.R
import com.vishal.contextualcards.data.models.CardGroup
import com.vishal.contextualcards.databinding.CardviewHc1Binding
import com.vishal.contextualcards.databinding.CardviewHc5Binding
import com.vishal.contextualcards.databinding.CardviewHc6Binding
import com.vishal.contextualcards.databinding.CardviewHc9Binding
import com.vishal.contextualcards.utils.BindUtils

class CardGroupAdapter(private val cardGroup: CardGroup, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val tag = "CardGroupAdapter"

    private lateinit var rootView: View

    override fun getItemCount(): Int = cardGroup.cards.size

    override fun getItemViewType(position: Int): Int {
        return when (cardGroup.design_type) {
            "HC1" -> 1
            "HC3" -> 3
            "HC5" -> 5
            "HC6" -> 6
            "HC9" -> 9
            else -> throw IllegalStateException("No card matches with design type: ${cardGroup.design_type}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        rootView = parent.rootView
        return when (viewType) {
            1 -> HC1CardGroupHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.cardview_hc1, parent, false)
            )
            5 -> HC5CardGroupHolder(
                DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.cardview_hc5, parent, false)
            )
            9 -> HC9CardGroupHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.cardview_hc9, parent, false)
            )
            else -> throw IllegalStateException("No card maps with view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HC1CardGroupHolder -> BindUtils.bindHC1(holder, position, cardGroup, rootView, context)
            is HC9CardGroupHolder -> BindUtils.bindHC9(holder, position, cardGroup, rootView, context)
            is HC5CardGroupHolder -> BindUtils.bindHC5(holder, position, cardGroup, rootView, context)
            else -> throw IllegalStateException("No card matches with holder type: $holder")
        }
    }

    inner class HC1CardGroupHolder(val binding: CardviewHc1Binding) : RecyclerView.ViewHolder(binding.root)

    inner class HC5CardGroupHolder(val binding: CardviewHc5Binding) : RecyclerView.ViewHolder(binding.root)

    inner class HC9CardGroupHolder(val binding: CardviewHc9Binding) : RecyclerView.ViewHolder(binding.root)
}