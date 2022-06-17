package com.mucha.lib.internal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mucha.lib.internal.db.DemoDatabase.Companion.create
import com.mucha.lib.internal.db.dao.CategoryDao
import com.mucha.lib.internal.db.dao.DrinkDao
import com.mucha.lib.internal.db.entities.Category
import com.mucha.lib.internal.db.entities.Drink

/**
 * Main database of a library module. Use provided [create] method to create an instance.
 */
@Database(
    entities = [
        Category::class,
        Drink::class,
    ],
    version = VERSION
)
internal abstract class DemoDatabase : RoomDatabase() {
    abstract val categoryDao: CategoryDao
    abstract val drinkDao: DrinkDao

    companion object {

        /**
         * Convenient method for creating a [DemoDatabase] instance.
         *
         * @param context The context.
         *
         * @return The instance of a database.
         */
        fun create(context: Context): DemoDatabase =
            Room.databaseBuilder(context, DemoDatabase::class.java, DB_NAME).build()
    }
}

private const val VERSION: Int = 1
private const val DB_NAME: String = "demo.db"
