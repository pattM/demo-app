package com.mucha.app.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mucha.app.ui.theme.grid_12
import com.mucha.app.ui.theme.grid_4

/**
 * Simple view for showing a title above group of views.
 *
 * @param title The title text.
 */
@Composable
fun HeaderView(title: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(grid_12)
            .padding(horizontal = grid_4)
    ) {
        Text(text = title)
    }
}
