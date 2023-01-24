package com.anoirdev.test.presentation.event.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anoirdev.test.presentation.event.EventPresentation

class EventAdapter : RecyclerView.Adapter<EventViewHolder>() {

    private val currentList = mutableListOf<EventPresentation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    fun setItems(data: List<EventPresentation>) {
        currentList.clear()
        currentList.addAll(data)
        notifyDataSetChanged()
    }
}