package com.mucha.lib.internal

import com.mucha.lib.api.DemoRepository
import com.mucha.lib.api.Drink
import com.mucha.lib.api.DrinkCategory
import com.mucha.lib.api.RefreshStatus
import com.mucha.lib.internal.db.dao.CategoryDao
import com.mucha.lib.internal.db.dao.DrinkDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import com.mucha.lib.internal.db.entities.CategoryEntity as CategoryEntity
import com.mucha.lib.internal.db.entities.DrinkEntity as DrinkEntity

/**
 * Default [DemoRepository] implementation.
 *
 * @param categoryDao The [CategoryEntity] related DAO implementation.
 * @param drinkDao The [DrinkEntity] related DAO implementation.
 */
internal class DefaultDemoRepository(
    private val categoryDao: CategoryDao,
    private val drinkDao: DrinkDao,
) : DemoRepository {

    override fun getAllCategories(): Flow<List<DrinkCategory>> =
        categoryDao.getAll().map { entities ->
            entities.map { entity ->
                DrinkCategory(id = entity.id, name = entity.name)
            }
        }

    override fun getDrinks(category: DrinkCategory): Flow<List<Drink>> =
        drinkDao.getAllForCategory(category.id).map { entities ->
            entities.map { entity ->
                Drink(name = entity.name)
            }
        }

    // TODO: Replace dummy implementation with real one. Extract logic from DatabaseRefreshWorker into internal
    //  "RefreshManager" and integrate onto both places.
    override fun refreshCategories(): Flow<RefreshStatus> =
        flow {
            emit(RefreshStatus.Preparing)
            delay(500)
            emit(RefreshStatus.Downloading)
            delay(5000)
            emit(RefreshStatus.Success)
        }
}
