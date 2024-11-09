// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me.demo

import android.app.Application

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // We need to initialise the DI container asap.
        AppContainer.initialise()
    }
}