package ru.kowqo.course999.core

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View

class CustomTextView : androidx.appcompat.widget.AppCompatTextView, HideAndShow {
    constructor(context: Context) : super(
        context,
    )

    constructor(context: Context, attrs: AttributeSet?) : super(
        context,
        attrs,
    )

    constructor(context: Context, attrs: AttributeSet?, defStyleAtr: Int) : super(
        context,
        attrs,
        defStyleAtr,
    )

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val visibilityState = VisibilityState(it)
            visibilityState.visible = visibility
            return visibilityState
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        super.onRestoreInstanceState(state)
        val visibilityState = state as VisibilityState?

        visibilityState?.let {
            visibility = it.visible
        }
    }

    override fun show() {
        visibility = View.VISIBLE
    }

    override fun hide() {
        visibility = View.GONE
    }
}
