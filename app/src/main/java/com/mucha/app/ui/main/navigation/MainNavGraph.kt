package com.mucha.app.ui.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mucha.app.ui.main.MainActivity
import com.mucha.app.ui.main.screens.CategoriesScreen
import com.mucha.app.ui.main.screens.DetailScreen
import com.mucha.app.ui.main.screens.DrinksScreen
import com.mucha.lib.api.DrinkCategory
import com.mucha.utils.requireStringArgument

/**
 * Main navigation graph for [MainActivity].
 */
@Composable
fun MainNavGraph(categories: List<DrinkCategory>) {
    val navController = rememberNavController()

    val onCategoryItemClick: (DrinkCategory) -> Unit = { category ->
        navController.navigate("$ROUTE_DRINKS/${category.id}")
    }

    val onDrinkItemClick: (String) -> Unit = { drinkName ->
        navController.navigate("$ROUTE_DRINK_DETAIL/$drinkName")
    }

    NavHost(navController = navController, startDestination = ROUTE_CATEGORIES, route = ROUTE_MAIN) {
        composable(route = ROUTE_CATEGORIES) {
            CategoriesScreen(
                categories = categories,
                onCategoryClick = onCategoryItemClick
            )
        }

        composable(route = "$ROUTE_DRINKS/{$PARAM_CATEGORY_NAME}") { backStackEntry ->
            DrinksScreen(
                categoryName = backStackEntry.requireStringArgument(PARAM_CATEGORY_NAME),
                onDrinkClick = onDrinkItemClick
            )
        }

        composable(route = "$ROUTE_DRINK_DETAIL/{$PARAM_DRINK_NAME}") { backStackEntry ->
            DetailScreen(
                drinkName = backStackEntry.requireStringArgument(PARAM_DRINK_NAME)
            )
        }
    }
}

private const val ROUTE_MAIN: String = "main"
private const val ROUTE_CATEGORIES: String = "categories"
private const val ROUTE_DRINKS: String = "drinks"
private const val ROUTE_DRINK_DETAIL: String = "drink_detail"

private const val PARAM_CATEGORY_NAME: String = "categoryName"
private const val PARAM_DRINK_NAME: String = "drinkName"
