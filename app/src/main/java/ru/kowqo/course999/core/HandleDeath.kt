package ru.kowqo.course999.core

interface HandleDeath {
    fun firstOpening()

    fun handleDeath()

    fun wasDeathHappened(): Boolean

    class Base : HandleDeath {
        private var deathHappened = true

        override fun handleDeath() {
            deathHappened = false
        }

        override fun wasDeathHappened(): Boolean {
            return deathHappened
        }

        override fun firstOpening() {
            deathHappened = false
        }
    }
}
