// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me

import dev.tunnicliff.container.Container

/**
 * Dependency injection container for the library.
 */
class RenameMeContainer private constructor(
    private val dependencies: Dependencies
) : Container() {
    interface Dependencies

    companion object {
        private lateinit var _SHARED: RenameMeContainer

        /**
         * Shared instance of the container.
         *
         * `initialise()` must be called before this can be referenced otherwise
         *
         * @throws UninitializedPropertyAccessException if `initialise()` has not been called first.
         */
        val SHARED: RenameMeContainer
            get() = _SHARED

        /**
         * Initialises the container.
         *
         * After which `SHARED` will be safe to use.
         *
         * @property dependencies the external dependencies required by the container.
         */
        fun initialise(dependencies: Dependencies) {
            _SHARED = RenameMeContainer(dependencies)
        }
    }

    fun example(): Example = resolveSingleton {
        Example()
    }
}