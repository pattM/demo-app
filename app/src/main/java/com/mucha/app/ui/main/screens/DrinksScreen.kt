package com.mucha.app.ui.main.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mucha.app.R
import com.mucha.app.ui.views.HeaderView

/**
 * Screen with the list of drinks in a given category.
 *
 * @param categoryName The name of drink category.
 * @param onDrinkClick Action to be invoked on drink item click.
 */
@Composable
fun DrinksScreen(categoryName: String, onDrinkClick: (drinkName: String) -> Unit) {
    Column {
        HeaderView(title = stringResource(id = R.string.drinks_title))
        // TODO: Dummy item, read from DB instead.
        Text(
            text = categoryName,
            modifier = Modifier.clickable { onDrinkClick("Drink 1") }
        )
//        LazyColumn {
//
//        }
    }
}
