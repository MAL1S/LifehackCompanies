package ru.malis.core_base

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.malis.core_style.R as style

class VerticalSpaceItemDecorator: RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val verticalSpace = parent.context.resources.getDimension(style.dimen.list_vertical_margin).toInt()

        if (parent.adapter?.itemCount != null && parent.getChildAdapterPosition(view) == 0) {
            outRect.top = verticalSpace
        }
        outRect.bottom = verticalSpace
    }
}