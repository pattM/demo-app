package com.mucha.lib.internal.service.model

import com.google.gson.annotations.SerializedName
import com.mucha.lib.internal.service.api.CocktailService

/**
 * Model class for [CocktailService.getCategories] response. Represents the drink category.
 *
 * @property categories Holder of the list of categories.
 */
internal data class CategoryResponse(@SerializedName("drinks") val categories: List<Category>)

/**
 * Represents the category item inside [CategoryResponse].
 *
 * @property name The name of the category.
 */
internal data class Category(@SerializedName("strCategory") val name: String)
