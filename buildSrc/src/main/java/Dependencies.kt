object SdkVersions {
    const val COMPILE = 32
    const val MIN = 21
    const val TARGET = 32
}

object Versions {
    // AndroidX
    const val androidx_activity_compose = "1.4.0"
    const val androidx_compose = "1.2.0-beta03"
    const val androidx_compose_material3 = "1.0.0-alpha13"
    const val androidx_core = "1.8.0"
    const val androidx_lifecycle_runtime = "2.4.1"
    const val androidx_navigation_compose = "2.4.2"
    const val androidx_room = "2.4.2"
    const val androidx_work = "2.7.1"

    // Google
    const val google_dagger = "2.42"

    // Other 3rd party
    const val squareup_retrofit = "2.9.0"
}

object Deps {
    // AndroidX
    const val androidx_activity_compose = "androidx.activity:activity-compose:${Versions.androidx_activity_compose}"
    const val androidx_compose_material3 = "androidx.compose.material3:material3:${Versions.androidx_compose_material3}"
    const val androidx_compose_ui = "androidx.compose.ui:ui:${Versions.androidx_compose}"
    const val androidx_compose_ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.androidx_compose}"
    const val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    const val androidx_lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidx_lifecycle_runtime}"
    const val androidx_navigation_compose = "androidx.navigation:navigation-compose:${Versions.androidx_navigation_compose}"
    const val androidx_room = "androidx.room:room-ktx:${Versions.androidx_room}"
    const val androidx_room_compiler = "androidx.room:room-compiler:${Versions.androidx_room}"
    const val androidx_room_runtime = "androidx.room:room-runtime:${Versions.androidx_room}"
    const val androidx_work_runtime = "androidx.work:work-runtime-ktx:${Versions.androidx_work}"

    // Google
    const val google_dagger = "com.google.dagger:dagger:${Versions.google_dagger}"
    const val google_dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.google_dagger}"
    const val google_dagger_hilt_android = "com.google.dagger:hilt-android:${Versions.google_dagger}"
    const val google_dagger_hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.google_dagger}"

    // Other 3rd party
    const val squareup_retrofit = "com.squareup.retrofit2:retrofit:${Versions.squareup_retrofit}"
    const val squareup_retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.squareup_retrofit}"
}
