package com.mucha.app.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mucha.app.ui.main.navigation.MainNavGraph
import com.mucha.app.ui.theme.AppTheme
import com.mucha.lib.api.DrinkCategory
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main entry point to the application's UI.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                val categories: List<DrinkCategory> by viewModel.drinkCategories.collectAsState(initial = emptyList())
                MainNavGraph(categories = categories)
            }
        }
    }
}
