// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me.demo.view

import androidx.lifecycle.ViewModel
import dev.tunnicliff.replace_me.Example

abstract class MainViewModel : ViewModel() {
    abstract fun getMessage(): String
}

class DefaultMainViewModel(
    private val example: Example
) : MainViewModel() {
    override fun getMessage(): String = example.value
}

class PreviewMainViewModel : MainViewModel() {
    override fun getMessage(): String = "Hello Preview!!"
}