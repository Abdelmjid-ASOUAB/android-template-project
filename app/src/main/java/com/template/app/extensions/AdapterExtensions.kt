package com.template.app.extensions

import androidx.recyclerview.widget.RecyclerView

class AdapterExtensions {
    companion object {
        fun <T : RecyclerView.ViewHolder> T.onTap(event: (position: Int, type: Int) -> Unit): T {
            itemView.setOnClickListener {
                event.invoke(adapterPosition, itemViewType)
            }
            return this
        }
    }
}