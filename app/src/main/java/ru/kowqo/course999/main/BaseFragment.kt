package ru.kowqo.course999.main

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import ru.kowqo.course999.core.ProvideRepresentative
import ru.kowqo.course999.core.Represantative

abstract class BaseFragment<T : Represantative<*>>(
    @LayoutRes layoutId: Int,
) : Fragment(layoutId) {
    protected lateinit var representative: T

    protected abstract val clazz: Class<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        representative =
            (requireActivity() as ProvideRepresentative).provideRepresentative(
                clazz,
            )
    }
}
