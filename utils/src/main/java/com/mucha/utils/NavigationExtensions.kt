package com.mucha.utils

import android.os.Bundle
import androidx.navigation.NavBackStackEntry

/**
 * Returns the arguments used for this entry.
 *
 * @return The arguments used when this entry was created.
 */
fun NavBackStackEntry.requireArguments(): Bundle = requireNotNull(arguments)

/**
 * Returns the value associated with the given `key`. Use in case of return value should never be `null`.
 *
 * @see requireArguments
 * @see Bundle.requireString
 */
fun NavBackStackEntry.requireStringArgument(key: String): String = requireArguments().requireString(key)
