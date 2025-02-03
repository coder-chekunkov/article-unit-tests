plugins {
    alias(libs.plugins.kapt)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "cdr.article_2"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions { jvmTarget = "21" }
    composeOptions { kotlinCompilerExtensionVersion = "1.4.3" }
    buildFeatures { compose = true }
    tasks.withType<Test> { useJUnitPlatform() }
}

dependencies {
    implementation(libs.kotlin.core)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.lifecycle.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.material)
    debugImplementation(libs.androidx.compose.tooling)

    kapt(libs.dagger.compiler)
    implementation(libs.dagger)

    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.jwt.worker)

    testImplementation(libs.google.truth)
    testImplementation(libs.junit.jupiter.api)
    testImplementation(libs.junit.jupiter.params)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlin.coroutines.test)
    testRuntimeOnly(libs.junit.jupiter.engine)
}