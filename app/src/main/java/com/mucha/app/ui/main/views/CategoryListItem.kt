package com.mucha.app.ui.main.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mucha.app.ui.theme.grid_10
import com.mucha.app.ui.theme.grid_2
import com.mucha.app.ui.theme.grid_4
import com.mucha.lib.api.DrinkCategory

/**
 * Represents the list item for drink category.
 *
 * @param category Drink category holder.
 * @param onClick Action to be invoked on category item click.
 */
@Composable
fun CategoryListItem(category: DrinkCategory, onClick: (category: DrinkCategory) -> Unit) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 1.dp,
        modifier = Modifier.clickable { onClick(category) }
    ) {
        Row(
            modifier = Modifier.padding(horizontal = grid_4, vertical = grid_2),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(color = Color.Red, shape = CircleShape)
                    .size(grid_10)
            ) {
                Text(
                    text = category.name.firstOrNull()?.toString().orEmpty().uppercase(),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light
                )
            }

            Spacer(modifier = Modifier.width(grid_4))

            Text(
                text = category.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
