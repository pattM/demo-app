package com.mucha.lib.internal.service.api

import com.mucha.lib.internal.service.model.CategoryResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Interface definition for a Retrofit client for communication with remote Cocktails database.
 *
 * See: [Cocktails database](https://www.thecocktaildb.com/api.php)
 */
internal interface CocktailService {

    /**
     * Returns the list of all drink categories.
     */
    @GET("/api/json/v1/1/list.php?c=list")
    suspend fun getCategories(): Response<CategoryResponse>
}
