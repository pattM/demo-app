package com.mucha.lib.internal.service.model

import com.mucha.lib.internal.service.api.CocktailService

/**
 * Main model class for [CocktailService.getCategories] response. Wrapper over list of categories.
 *
 * @property drinks The list of drink categories.
 */
data class Drinks(val drinks: List<DrinkCategory>)
