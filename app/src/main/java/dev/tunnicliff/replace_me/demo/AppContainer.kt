// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import dev.tunnicliff.container.Container
import dev.tunnicliff.replace_me.Example
import dev.tunnicliff.replace_me.demo.view.DefaultMainViewModel
import dev.tunnicliff.replace_me.demo.view.MainViewModel
import dev.tunnicliff.replace_me.replace_meContainer
import kotlin.reflect.KClass

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
            replace_meContainer.initialise(object : replace_meContainer.Dependencies {})
        }
    }

    object ViewModelFactory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T =
            when (modelClass) {
                MainViewModel::class -> DefaultMainViewModel(SHARED.example()) as T
                // Add ViewModel mappings here.
                else -> throw Exception("Unable to resolve view model of type $modelClass")
            }
    }

    fun example(): Example = replace_meContainer.SHARED.example()
}
