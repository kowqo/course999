package ru.kowqo.course999.core

import android.content.Context
import android.content.SharedPreferences
import ru.kowqo.course999.main.Navigation

interface ProvideSharedPreferences {
    fun sharedPrefrerences(): SharedPreferences
}

interface ProvideNavigation {
    fun navigation(): Navigation.Mutable
}

interface Core : ProvideNavigation, ProvideSharedPreferences {
    class Base(private val context: Context) : Core {
        private val navigation = Navigation.Base()

        override fun navigation(): Navigation.Mutable = navigation

        override fun sharedPrefrerences(): SharedPreferences {
            return context.getSharedPreferences("project999", Context.MODE_PRIVATE)
        }
    }
}
