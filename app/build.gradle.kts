import com.android.build.gradle.internal.api.ApkVariantOutputImpl
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.android.gms.oss-licenses-plugin")
}

android {
    compileSdk = 33
    namespace = "de.kvaesitso.icons"

    defaultConfig {
        applicationId = "de.kvaesitso.icons"
        minSdk = 26
        targetSdk = 33
        versionCode = 6
        versionName = "1.5.0"
        resourceConfigurations.addAll(listOf("en", "de", "es", "fr", "hi", "ja", "pl", "ru", "tr"))
    }

    val keystorePropertiesFile = rootProject.file("keystore.properties")
    val releaseSigning = if (keystorePropertiesFile.exists()) {
        val keystoreProperties = Properties()
        keystoreProperties.load(FileInputStream(keystorePropertiesFile))
        signingConfigs.create("release") {
            keyAlias = keystoreProperties["keyAlias"].toString()
            keyPassword = keystoreProperties["keyPassword"].toString()
            storeFile = rootProject.file(keystoreProperties["storeFile"].toString())
            storePassword = keystoreProperties["storePassword"].toString()
        }
    } else {
        signingConfigs["debug"]
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            signingConfig = releaseSigning
            proguardFiles("proguard-rules.pro")
        }
        debug {
            signingConfig = releaseSigning
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }

    applicationVariants.all {
        outputs.all {
            (this as? ApkVariantOutputImpl)?.outputFileName =
                "Kvaesitso-Icons_${versionName}_${buildType.name}.apk"
        }
    }
}

dependencies {
    val accompanistVersion = "0.28.0"
    val hiltVersion = "2.44.2"
    val retrofitVersion = "2.9.0"

    implementation(platform("androidx.compose:compose-bom:2023.01.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material")
    implementation("androidx.core:core-splashscreen:1.0.0")
    implementation("androidx.compose.material3:material3:1.1.0-alpha06")
    implementation("com.google.accompanist:accompanist-insets:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-placeholder-material:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-navigation-animation:$accompanistVersion")
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("com.github.LawnchairLauncher:oss-notices:1.0.2")
    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
}
