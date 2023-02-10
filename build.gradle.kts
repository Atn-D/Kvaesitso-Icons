plugins {
    id("com.android.application") version "7.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.45" apply false
    id("com.google.android.gms.oss-licenses-plugin") version "0.10.6" apply false
}

tasks.register("clean") {
    delete(rootProject.buildDir)
}
