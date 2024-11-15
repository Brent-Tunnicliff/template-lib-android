// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me

import dev.tunnicliff.container.Container
import dev.tunnicliff.logging.logger.Logger

/**
 * Dependency injection container for the library.
 */
class replace_meContainer(
    dependencies: Dependencies
) : Container() {
    interface Dependencies {
        fun logger(): Logger
    }

    companion object {
        private lateinit var _LOGGER: () -> Logger
        val LOGGER: Logger
            get() = _LOGGER()
    }

    init {
        _LOGGER = { dependencies.logger() }
    }

    fun example(): Example = resolveSingleton {
        Example()
    }
}