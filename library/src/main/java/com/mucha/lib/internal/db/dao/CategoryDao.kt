package com.mucha.lib.internal.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mucha.lib.internal.db.entities.Category
import kotlinx.coroutines.flow.Flow

/**
 * [Category] related DAO definition.
 */
@Dao
internal interface CategoryDao {

    /**
     * Provides updates of all available categories.
     *
     * @return The flow of list of categories.
     */
    @Query("SELECT * FROM Category")
    fun getAll(): Flow<List<Category>>

    /**
     * Inserts given `categories` into a database. Existing values will be replaced.
     *
     * @param categories The list of categories.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(categories: List<Category>)
}
