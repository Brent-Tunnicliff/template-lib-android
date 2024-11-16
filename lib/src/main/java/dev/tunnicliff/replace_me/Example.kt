// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me

import dev.tunnicliff.logging.LOG

class Example internal constructor() {
    private companion object {
        const val TAG = "Example"
    }

    val value = "Hello world!"

    init {
        LOG.info(TAG, "Init done!")
    }
}
