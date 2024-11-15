// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me.demo

import android.app.Application
import android.content.Context
import dev.tunnicliff.logging.model.LogLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainApplication : Application() {
    private val container = AppContainer(
        object : AppContainer.Dependencies {
            override fun applicationContext(): Context =
                this@MainApplication.applicationContext
        }
    )

    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        applicationScope.launch {
            with(container.loggingConfigurationManager()) {
                setMinimumLogLevel(LogLevel.DEBUG)
                deleteOldLogs()
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onLowMemory() {
        super.onLowMemory()
        applicationScope.cancel()
    }
}