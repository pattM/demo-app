package com.mucha.lib.internal.service.api

import com.mucha.lib.internal.service.model.Drinks
import retrofit2.Call
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
    fun getCategories(): Call<Drinks>
}
