package com.cookandroid.wildRift.view

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class FullRecyclerView : RecyclerView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val Int.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

    override fun canScrollHorizontally(direction: Int): Boolean {
        return false
    }

    override fun canScrollVertically(direction: Int): Boolean {
        return false
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        var height = 0
        children.forEach { view ->
            height += view.height
        }

        super.onMeasure(widthSpec, height.dp)
    }
}