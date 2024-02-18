package ru.kowqo.course999.core

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View

class CustomButton : androidx.appcompat.widget.AppCompatButton, HideAndShow {
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

class VisibilityState : View.BaseSavedState {
    var visible: Int = View.VISIBLE

    constructor(parcelable: Parcelable) : super(parcelable)

    private constructor(parcel: Parcel) : super(parcel) {
        visible = parcel.readInt()
    }

    override fun writeToParcel(
        out: Parcel,
        flags: Int,
    ) {
        super.writeToParcel(out, flags)
        out.writeInt(visible)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<VisibilityState> {
        override fun createFromParcel(parcel: Parcel): VisibilityState = VisibilityState(parcel)

        override fun newArray(size: Int): Array<VisibilityState?> = arrayOfNulls(size)
    }
}
