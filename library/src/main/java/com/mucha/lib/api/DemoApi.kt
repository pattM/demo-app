package com.mucha.lib.api

import kotlinx.coroutines.flow.Flow

/**
 * Interface definition for a basic communication with a library.
 */
interface DemoApi {

    /**
     * Provides updates of all available drink categories.
     *
     * @return The flow of list of categories.
     */
    fun getAllCategories(): Flow<List<DrinkCategory>>

    /**
     * Forces the refresh of stored data. This method is intended to be called from inside the UI **ONLY** when
     * manual data refresh is required.
     */
    // TODO: PoC at the moment. Subject of future changes.
    fun refreshCategories(): Flow<RefreshStatus>
}
