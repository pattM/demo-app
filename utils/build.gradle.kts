plugins {
    id("com.android.library")

    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = SdkVersions.COMPILE

    defaultConfig {
        minSdk = SdkVersions.MIN
        targetSdk = SdkVersions.TARGET
    }
}

dependencies {

    // AndroidX
    implementation(Deps.androidx_navigation_compose)
}