// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.replace_me.demo.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.tunnicliff.replace_me.demo.container.ViewModelFactory
import dev.tunnicliff.ui.theme.ThemedPreviewer

@Composable
fun MainView(
    viewModel: MainViewModel = viewModel(factory = ViewModelFactory)
) {
    Text(
        text = "Value: ${viewModel.getMessage()}",
        modifier = Modifier.padding(8.dp)
    )
}

@Preview
@Composable
private fun Preview() = ThemedPreviewer {
    MainView(viewModel = PreviewMainViewModel())
}