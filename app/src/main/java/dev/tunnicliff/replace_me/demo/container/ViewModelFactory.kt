// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me.demo.container

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import dev.tunnicliff.replace_me.demo.view.DefaultMainViewModel
import dev.tunnicliff.replace_me.demo.view.MainViewModel
import kotlin.reflect.KClass

object ViewModelFactory : ViewModelProvider.Factory {
    private val resolver: AppContainer
        get() = AppContainer.SHARED

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T =
        when (modelClass) {
            MainViewModel::class -> DefaultMainViewModel(resolver.example()) as T
            // Add ViewModel mappings here.
            else -> throw Exception("Unable to resolve view model of type $modelClass")
        }
}