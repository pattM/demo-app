plugins {
    id("com.android.library")

    kotlin("android")
    kotlin("kapt")

    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = SdkVersions.COMPILE

    defaultConfig {
        minSdk = SdkVersions.MIN
    }

    kapt {
        arguments {
            arg("room.schemaLocation", "$rootDir/schemas")
            arg("room.incremental", "true")
            arg("room.expandProjection", "true")
        }
    }
}

dependencies {
    // AndroidX
    implementation(Deps.androidx_room_runtime)
    implementation(Deps.androidx_room)
    implementation(Deps.androidx_work_runtime)

    // Google
    implementation(Deps.google_dagger)
    implementation(Deps.google_dagger_hilt_android)

    // 3rd party
    implementation(Deps.squareup_retrofit)
    implementation(Deps.squareup_retrofit_gson)

    // Kapt
    kapt(Deps.androidx_room_compiler)
    kapt(Deps.google_dagger_compiler)
    kapt(Deps.google_dagger_hilt_compiler)
}
