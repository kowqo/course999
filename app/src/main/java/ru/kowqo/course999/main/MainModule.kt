package ru.kowqo.course999.main

import ru.kowqo.course999.core.Module

class MainModule : Module<MainRepresentative> {
    override fun representative(): MainRepresentative {
        return MainRepresentative.Base(Navigation.Base)
    }
}
