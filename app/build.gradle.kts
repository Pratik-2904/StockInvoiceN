plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
    id("com.google.devtools.ksp") version "1.9.20-1.0.14"
}

android {
    namespace = "com.example.stockinvoice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.stockinvoice"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.auth)  //firebase auth
    implementation(libs.firebase.database)  //firebase //storage
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.storage.ktx)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.firebase.auth.ktx)//firebase //storage
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // ViewModel utilities for Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    // Feature module Support
    implementation(libs.androidx.navigation.dynamic.features.fragment)
    // Testing Navigation
    androidTestImplementation(libs.androidx.navigation.testing)
    // Jetpack Compose Integration
    implementation(libs.androidx.navigation.compose)

    //Splash Api
    implementation(libs.androidx.core.splashscreen)

//for image insertion
    implementation(libs.coil.compose)
    implementation(kotlin("script-runtime"))

    //Room data
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.core.ktx.v1120)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    //android testing
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(libs.androidx.junit.v115)
}