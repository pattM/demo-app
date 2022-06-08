package com.mucha.lib.api

// TODO: PoC at the moment. Subject of future changes.
sealed class RefreshStatus {
    // Initial preparation phase, for possible UI changes.
    object Preparing: RefreshStatus()

    // Downloading... In case of offline, min duration of X seconds might be helpful for better UX.
    object Downloading: RefreshStatus()

    // We have data. It is safe to access the data using desired API.
    object Success : RefreshStatus()

    // Refresh failed. It is still possible to access the data using desired API (old data).
    data class Failed(val error: RefreshError) : RefreshStatus()
}

enum class RefreshError {
    CONNECTION_TIMEOUT,
    GENERAL_ERROR,
}