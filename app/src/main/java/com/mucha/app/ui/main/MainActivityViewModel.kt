package com.mucha.app.ui.main

import androidx.lifecycle.ViewModel
import com.mucha.lib.api.DemoApi
import com.mucha.lib.api.DrinkCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of a [ViewModel] for [MainActivity].
 */
@HiltViewModel
class MainActivityViewModel @Inject constructor(demoApi: DemoApi) : ViewModel() {

    /**
     * Provides live updates of list of [DrinkCategory] items.
     */
    val drinkCategories: Flow<List<DrinkCategory>> = demoApi.getAllCategories()
}
