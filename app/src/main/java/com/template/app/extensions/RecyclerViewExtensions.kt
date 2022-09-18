package com.template.app.extensions

import androidx.recyclerview.widget.RecyclerView
import com.template.app.helpers.RecyclerViewHelper.Companion.isLastItemDisplaying
import com.template.app.models.pagenation.Meta

class RecyclerViewExtensions {
    companion object {
        fun <T : RecyclerView> T.loadNext(meta: Meta?, event: (current: Int) -> Unit): T {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!isLastItemDisplaying(recyclerView)) {
                        return
                    }

                    if (meta == null) {
                        return
                    }

                    val pagination = meta.pagination
                    if (pagination.currentPage + 1 <= pagination.totalPages) {
                        event.invoke(pagination.currentPage + 1)
                    }
                }
            })

            return this
        }
    }
}