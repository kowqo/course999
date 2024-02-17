package ru.kowqo.course999.main

import android.content.SharedPreferences

interface UserPremiumCache {
    interface Save {
        fun saveUserPremium()
    }

    interface Read {
        fun isUserPremium(): Boolean
    }

    interface Mutable : Save, Read

    class Base(
        private val sharedPreferences: SharedPreferences,
        private val key: String = "isUserPremium",
    ) : Mutable {
        /** @function
         * @name saveUserPremium - Сохранение состояния подписки */
        override fun saveUserPremium() {
            sharedPreferences.edit().putBoolean(key, true).apply()
        }

        /** @function
         * @name isUserPremium - Получение состояния премиум подписки */
        override fun isUserPremium(): Boolean = sharedPreferences.getBoolean(key, false)
    }
}
