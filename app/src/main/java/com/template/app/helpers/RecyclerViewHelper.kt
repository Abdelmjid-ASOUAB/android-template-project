package com.template.app.helpers

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHelper {
    companion object {
        fun isLastItemDisplaying(recyclerView: RecyclerView): Boolean {
            if (recyclerView.adapter!!.itemCount != 0) {
                val lastVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
                if (lastVisibleItemPosition != RecyclerView.NO_POSITION && lastVisibleItemPosition == recyclerView.adapter!!.itemCount - 1) {
                    return true
                }
            }

            return false
        }
    }
}