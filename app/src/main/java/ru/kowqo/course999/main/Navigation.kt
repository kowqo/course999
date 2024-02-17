package ru.kowqo.course999.main

import ru.kowqo.course999.core.UiObservable
import ru.kowqo.course999.core.UiUpdate
import ru.kowqo.course999.core.UpdateObserver

interface Navigation {
    interface Navigate : UiUpdate<Screen>

    interface Observe : UpdateObserver<Screen>

    interface Mutable : Navigate, Observe

    class Base : UiObservable.Single<Screen>(), Mutable
}
