rootProject.name = "article-unit-tests"
include(":article-TestMobile")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    versionCatalogs {
        create("libs") {
            library("kotlin-core", "androidx.core:core-ktx:1.12.0")
            library("kotlin-coroutines-test", "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
            library("androidx-lifecycle", "androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
            library("androidx-lifecycle-compose", "androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
            library("androidx-lifecycle-viewmodel-compose", "androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
            library("androidx-activity-compose", "androidx.activity:activity-compose:1.9.0")
            library("androidx-compose-material", "androidx.compose.material:material:1.6.6")
            library("androidx-compose-material3", "androidx.compose.material3:material3:1.2.1")
            library("androidx-compose-tooling", "androidx.compose.ui:ui-tooling:1.6.4")
            library("androidx-fragment", "androidx.fragment:fragment-ktx:1.6.2")
            library("androidx-material", "com.google.android.material:material:1.5.0")
            library("google-truth", "com.google.truth:truth:1.2.0")
            library("junit-jupiter-api", "org.junit.jupiter:junit-jupiter-api:5.8.2")
            library("junit-jupiter-engine", "org.junit.jupiter:junit-jupiter-engine:5.8.2")
            library("junit-jupiter-params", "org.junit.jupiter:junit-jupiter-params:5.10.0")
            library("mockk", "io.mockk:mockk:1.13.10")
        }
    }
}