plugins {
    id("com.android.application")

    kotlin("android")
    kotlin("kapt")

    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = SdkVersions.COMPILE

    defaultConfig {
        applicationId = "com.mucha.app"
        minSdk = SdkVersions.MIN
        targetSdk = SdkVersions.TARGET
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.androidx_compose
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(project(":library"))

    // AndroidX
    implementation(Deps.androidx_activity_compose)
    implementation(Deps.androidx_compose_material3)
    implementation(Deps.androidx_compose_ui)
    implementation(Deps.androidx_compose_ui_tooling_preview)
    implementation(Deps.androidx_core)
    implementation(Deps.androidx_lifecycle_runtime)

    // Google
    implementation(Deps.google_dagger_hilt_android)

    // Kapt
    kapt(Deps.google_dagger_hilt_compiler)
}
