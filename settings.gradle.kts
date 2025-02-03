rootProject.name = "article-unit-tests"
include(":article-TestMobile")
include(":article_1")
include(":article_2")
include(":article_3")

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
}