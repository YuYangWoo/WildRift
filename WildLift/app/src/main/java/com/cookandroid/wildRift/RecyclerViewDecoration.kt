package com.cookandroid.wildRift

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewDecoration : RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val paint = Paint()
        val height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3F, Resources.getSystem().displayMetrics)
        val margin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10F, Resources.getSystem().displayMetrics)
        paint.color = Color.parseColor("#FFFFFF")

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            if (i != parent.childCount - 1) {
                c.drawRect(child.left.toFloat() + margin, child.bottom.toFloat(), child.right.toFloat() - margin, child.bottom.toFloat() + height, paint)
            }
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val margin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10F, Resources.getSystem().displayMetrics).toInt()

        if (position != 0) {
            outRect.top = margin
        }
    }
}