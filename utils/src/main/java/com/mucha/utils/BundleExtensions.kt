package com.mucha.utils

import android.os.Bundle

/**
 * Returns the value associated with the given `key`. Use in case of return value should never be `null`.
 *
 * @see Bundle.getString
 */
fun Bundle.requireString(key: String): String = requireNotNull(getString(key))
