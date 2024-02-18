package ru.kowqo.course999.core

interface Module<T : Represantative<*>> {
    fun representative(): T
}
