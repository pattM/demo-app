package com.mucha.lib.internal.db.entities

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents the categorization of a drink.
 *
 * @property id The identifier of the category. Local Id.
 * @property id The identifier of the category for fetching additional information from backend.
 * @property name The human-readable name of the category.
 */
@Keep
@Entity(tableName = "categories")
internal data class CategoryEntity(@PrimaryKey val id: String, val fetchId: String, val name: String)
