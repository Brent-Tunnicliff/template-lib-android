// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me

import dev.tunnicliff.logging.logger.Logger

/**
 * Convenient access to logging without having to use dependency injection.
 */
internal val LibLog: Logger
    get() = replace_meContainer.LOGGER