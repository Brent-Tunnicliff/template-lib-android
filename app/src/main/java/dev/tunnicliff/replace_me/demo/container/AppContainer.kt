// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me.demo.container

import dev.tunnicliff.container.Container
import dev.tunnicliff.replace_me.Example
import dev.tunnicliff.replace_me.RenameMeContainer

class AppContainer private constructor() : Container() {
    companion object {
        private lateinit var _SHARED: AppContainer

        val SHARED: AppContainer
            get() = _SHARED

        /**
         * Initialises the container.
         *
         * After which `SHARED` will be safe to use.
         */
        fun initialise() {
            _SHARED = AppContainer()
            RenameMeContainer.initialise(object : RenameMeContainer.Dependencies {})
        }
    }

    fun example(): Example = RenameMeContainer.SHARED.example()
}