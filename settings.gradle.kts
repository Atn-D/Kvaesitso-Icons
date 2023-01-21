include(":app")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()

    }
    resolutionStrategy {
        eachPlugin {
            // https://github.com/google/play-services-plugins/issues/223
            if (requested.id.id == "com.google.android.gms.oss-licenses-plugin") {
                useModule("com.google.android.gms:oss-licenses-plugin:${requested.version}")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(
            "https://jitpack.io"
        )
    }
}
