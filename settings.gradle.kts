pluginManagement {

    pluginManagement {
        buildscript {
            repositories {
                mavenCentral()
                maven {
                    url = uri("https://storage.googleapis.com/r8-releases/raw")
                }
            }
            dependencies {
                classpath("com.android.tools:r8:8.2.24")
            }
        }
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "RecipeApp"
include(":app")}


 