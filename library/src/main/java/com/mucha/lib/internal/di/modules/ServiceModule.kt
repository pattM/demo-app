package com.mucha.lib.internal.di.modules

import com.mucha.lib.internal.service.api.CocktailService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * Dagger module for providing Retrofit services related classes.
 */
@Module
internal object ServiceModule {

    private const val NAME_COCKTAILS: String = "cocktails"

    private const val URL_COCKTAILS: String = "http://www.thecocktaildb.com/"

    @Provides
    @Reusable
    fun cocktailsService(@Named(NAME_COCKTAILS) retrofit: Retrofit): CocktailService =
        retrofit.create(CocktailService::class.java)

    @Provides
    @Reusable
    @Named(NAME_COCKTAILS)
    fun retrofitClient(okhttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(URL_COCKTAILS)
            .client(okhttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Reusable
    fun okHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
}
