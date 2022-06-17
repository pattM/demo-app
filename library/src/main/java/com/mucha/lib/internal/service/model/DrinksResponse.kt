package com.mucha.lib.internal.service.model

import com.google.gson.annotations.SerializedName
import com.mucha.lib.internal.service.api.CocktailService

/**
 * Model class for [CocktailService.getDrinks] response.
 *
 * @property drinks Holder of the list of drinks.
 */
internal data class DrinksResponse(@SerializedName("drinks") val drinks: List<Drink>)

/**
 * Represents the drink item inside [DrinksResponse].
 *
 * @property name The name of the drink.
 * @property thumbnailUrl The url to the drink thumbnail.
 * @property id The id of the drink.
 */
internal data class Drink(
    @SerializedName("strDrink") val name: String,
    @SerializedName("strDrinkThumb") val thumbnailUrl: String,
    @SerializedName("idDrink") val id: Int
)
