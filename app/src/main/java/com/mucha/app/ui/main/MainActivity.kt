package com.mucha.app.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.lifecycle.lifecycleScope
import com.mucha.app.ui.main.views.CategoryListItem
import com.mucha.app.ui.theme.AppTheme
import com.mucha.lib.DemoLib
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Main entry point to the application's UI.
 */
class MainActivity : ComponentActivity() {

    // TODO: Tmp data
    private val categories: List<String> =
        listOf(
            "Beer",
            "Cocktail",
            "Cocoa",
            "Coffee / Tea",
            "Homemade Liqueur",
            "Ordinary Drink",
            "Other/Unknown",
            "Punch / Party Drink",
            "Shake",
            "Shot",
            "Soft Drink",
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                LazyColumn {
                    items(categories) { category ->
                        CategoryListItem(category)
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        // TODO: WM
        DemoLib.demoApi.getAllCategories()
            .onEach { Log.d("tagis", "categories = ${it.joinToString()}") }
            .launchIn(lifecycleScope)
    }
}
