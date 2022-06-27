package com.mucha.lib.internal.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mucha.lib.internal.db.entities.CategoryEntity
import com.mucha.lib.internal.db.entities.DrinkEntity
import kotlinx.coroutines.flow.Flow

/**
 * [DrinkEntity] related DAO definition.
 */
@Dao
internal interface DrinkDao {

    /**
     * Provides updates of all drinks inside given `category`.
     *
     * @param categoryId The id of a category. Use [CategoryEntity.id].
     *
     * @return The flow of list of drinks.
     */
    @Query("SELECT * FROM drinks WHERE id = :categoryId")
    fun getAllForCategory(categoryId: String): Flow<List<DrinkEntity>>

    /**
     * Inserts given `drinks` into a database. Existing values will be replaced.
     *
     * @param drinks The list of drinks.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(drinks: List<DrinkEntity>)
}
