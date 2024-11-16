// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me

import dev.tunnicliff.container.Container

/**
 * Dependency injection container for the library.
 */
class replace_meContainer : Container() {
    fun example(): Example = resolveSingleton {
        Example()
    }
}