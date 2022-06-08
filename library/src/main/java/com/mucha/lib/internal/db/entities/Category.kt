package com.mucha.lib.internal.db.entities

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents the categorization of a drink.
 *
 * @property name The name of the category.
 */
@Keep
@Entity
internal data class Category(@PrimaryKey val name: String)
