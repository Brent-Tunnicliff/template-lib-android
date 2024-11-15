// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me.demo

import dev.tunnicliff.logging.logger.Logger

/**
 * Convenient access to logging without having to use dependency injection.
 */
val AppLog: Logger
    get() = AppContainer.LOGGER