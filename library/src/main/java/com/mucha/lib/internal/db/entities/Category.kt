package com.mucha.lib.internal.db.entities

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents the categorization of a drink.
 *
 * @property id The identifier of the category.
 * @property name The name of the category.
 */
@Keep
@Entity
internal data class Category(@PrimaryKey val id: String, val name: String)
