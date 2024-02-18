package ru.kowqo.course999.main

import ru.kowqo.course999.core.Core
import ru.kowqo.course999.core.Module

class MainModule(private val core: Core) : Module<MainRepresentative> {
    override fun representative(): MainRepresentative {
        return MainRepresentative.Base(core.navigation())
    }
}
