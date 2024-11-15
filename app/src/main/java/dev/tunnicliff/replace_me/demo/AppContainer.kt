// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me.demo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import dev.tunnicliff.container.Container
import dev.tunnicliff.logging.LoggingContainer
import dev.tunnicliff.logging.logger.LogUploadHandler
import dev.tunnicliff.logging.logger.Logger
import dev.tunnicliff.logging.logger.LoggingConfigurationManager
import dev.tunnicliff.logging.model.LogLevel
import dev.tunnicliff.replace_me.Example
import dev.tunnicliff.replace_me.demo.view.DefaultMainViewModel
import dev.tunnicliff.replace_me.demo.view.MainViewModel
import dev.tunnicliff.replace_me.replace_meContainer
import kotlin.reflect.KClass

class AppContainer(
    dependencies: Dependencies
) : Container() {
    // region Types

    interface Dependencies {
        fun applicationContext(): Context
    }

    object ViewModelFactory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T =
            when (modelClass) {
                MainViewModel::class -> DefaultMainViewModel(CONTAINER.example()) as T
                // Add ViewModel mappings here.
                else -> throw Exception("Unable to resolve view model of type $modelClass")
            }
    }

    // endregion

    // region Properties

    companion object {
        private lateinit var CONTAINER: AppContainer
        val LOGGER: Logger
            get() = CONTAINER.loggingContainer.logger()
    }

    private val loggingContainer: LoggingContainer = LoggingContainer(
        object : LoggingContainer.Dependencies {
            override fun applicationContext(): Context =
                dependencies.applicationContext()

            override fun uploadHandler(): LogUploadHandler =
                this@AppContainer.uploadHandler()
        }
    )

    private val libContainer: replace_meContainer = replace_meContainer(
        object : replace_meContainer.Dependencies {
            override fun logger(): Logger = LOGGER
        }
    )

    // endregion

    init {
        CONTAINER = this
    }

    // region Internal

    fun example(): Example = resolveSingleton {
        libContainer.example()
    }

    fun loggingConfigurationManager(): LoggingConfigurationManager =
        loggingContainer.loggingConfigurationManager()

    // endregion

    // region Private

    private fun uploadHandler(): LogUploadHandler = resolveSingleton {
        object : LogUploadHandler {
            override suspend fun uploadLog(
                level: LogLevel,
                tag: String,
                message: String,
                throwable: Throwable?
            ): Boolean {
                println("Uploading log, level:$level, tag:$tag, message:$message, throwable:$throwable")
                return true
            }
        }
    }

    // endregion
}
