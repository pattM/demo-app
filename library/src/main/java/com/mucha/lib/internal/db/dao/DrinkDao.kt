package com.mucha.lib.internal.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mucha.lib.internal.db.entities.Category
import com.mucha.lib.internal.db.entities.Drink
import kotlinx.coroutines.flow.Flow

/**
 * [Drink] related DAO definition.
 */
@Dao
internal interface DrinkDao {

    /**
     * Provides updates of all drinks inside given `category`.
     *
     * @param categoryId The id of a category. Use [Category.id].
     *
     * @return The flow of list of drinks.
     */
    @Query("SELECT * FROM Drink WHERE id = :categoryId")
    fun getAllForCategory(categoryId: String): Flow<List<Drink>>

    /**
     * Inserts given `drinks` into a database. Existing values will be replaced.
     *
     * @param drinks The list of drinks.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(drinks: List<Drink>)
}
