package com.mucha.lib.internal.db.entities

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a drink.
 *
 * @property id The identifier of the drink.
 * @property name The name of the drink.
 * @property thumbnailUrl The url to the thumbnail of the drink.
 */
@Keep
@Entity
internal data class Drink(@PrimaryKey val id: Int, val name: String, val thumbnailUrl: String)
