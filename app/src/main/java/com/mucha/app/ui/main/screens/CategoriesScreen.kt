package com.mucha.app.ui.main.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mucha.app.R
import com.mucha.app.ui.main.views.CategoryListItem
import com.mucha.app.ui.theme.grid_2
import com.mucha.app.ui.views.HeaderView
import com.mucha.lib.api.DrinkCategory

/**
 * Screen with the list of drink categories.
 *
 * @param categories The list of drink categories.
 * @param onCategoryClick Action to be invoked on drink category item click.
 */
@Composable
fun CategoriesScreen(
    categories: List<DrinkCategory>,
    onCategoryClick: (DrinkCategory) -> Unit
) {
    Column {
        HeaderView(title = stringResource(id = R.string.categories_title))
        LazyColumn(
            contentPadding = PaddingValues(all = grid_2),
            verticalArrangement = Arrangement.spacedBy(grid_2),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items = categories) { category ->
                CategoryListItem(category = category, onClick = onCategoryClick)
            }
        }
    }
}
