rootProject.name = "FirstKMPProject"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":core-network")
include(":core-database")

include(":search:ui")
include(":search:data")
include(":search:domain")

include(":game:ui")
include(":game:data")
include(":game:domain")

include(":favourite:ui")
include(":favourite:data")
include(":favourite:domain")
include(":core-logger")

include(":common:ui")
include(":common:data")
include(":common:domain")
