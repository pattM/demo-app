package com.mucha.lib.internal.service.model

import com.mucha.lib.internal.service.api.CocktailService

/**
 * Model class for [CocktailService.getCategories] response. Represents the drink category.
 *
 * @property strCategory The name of the category.
 */
data class DrinkCategory(val strCategory: String)
