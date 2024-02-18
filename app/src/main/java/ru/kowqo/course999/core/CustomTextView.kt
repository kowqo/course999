package ru.kowqo.course999.core

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet

class CustomTextView : androidx.appcompat.widget.AppCompatTextView {
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
        val progressState = state as VisibilityState?
        super.onRestoreInstanceState(state)
        progressState?.let {
            visibility = it.visible
        }
    }
}
