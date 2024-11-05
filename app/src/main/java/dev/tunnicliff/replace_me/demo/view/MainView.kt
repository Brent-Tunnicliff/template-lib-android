// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me.demo.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.tunnicliff.replace_me.demo.container.ViewModelFactory
import dev.tunnicliff.ui.theme.ThemedPreviewer

@Composable
fun MainView(
    viewModel: MainViewModel = viewModel(factory = ViewModelFactory)
) {
    Text(
        text = "Value: ${viewModel.getMessage()}"
    )
}

@Preview
@Composable
private fun Preview() = ThemedPreviewer {
    MainView(viewModel = PreviewMainViewModel())
}