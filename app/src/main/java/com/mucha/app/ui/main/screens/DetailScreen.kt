package com.mucha.app.ui.main.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mucha.app.R
import com.mucha.app.ui.views.HeaderView

/**
 * Screen with the details of a given drink.
 *
 * @param drinkName The name of a drink.
 */
@Composable
fun DetailScreen(drinkName: String) {
    Column {
        HeaderView(title = stringResource(id = R.string.drink_detail_title))
        Text(text = drinkName)
    }
}
