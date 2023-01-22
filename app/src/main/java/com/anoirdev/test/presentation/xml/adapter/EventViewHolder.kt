package com.anoirdev.test.presentation.xml.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anoirdev.test.databinding.ItemEventBinding
import com.anoirdev.test.presentation.xml.EventPresentation

class EventViewHolder(
    private val binding: ItemEventBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(event: EventPresentation) {
        binding.event = event
        binding.executePendingBindings()
    }

    companion object {
        fun create(
            parent: ViewGroup,
        ): EventViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemEventBinding.inflate(inflater, parent, false)
            return EventViewHolder(binding)
        }
    }

}