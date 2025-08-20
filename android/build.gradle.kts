plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "org.burnoutcrew.android"

    compileSdk = rootProject.extra["compileSdkVersion"] as Int

    defaultConfig {
        applicationId = "org.burnoutcrew.android"
        minSdk = rootProject.extra["minSdkVersion"] as Int
        targetSdk = rootProject.extra["targetSdkVersion"] as Int

        versionCode = 1
        versionName = "1.0"
    }

    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
        // Для стабильной работы с Kotlin 1.9+
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

dependencies {
    implementation(project(":reorderable"))

    implementation("androidx.compose.runtime:runtime:1.8.3")
    implementation("androidx.compose.material:material:1.8.3")

    implementation("androidx.compose.material:material-icons-core:1.7.8")
    implementation("androidx.compose.material:material-icons-extended:1.7.8")

    implementation("androidx.activity:activity-compose:1.10.1")

    implementation("com.google.android.material:material:1.12.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.2")

    implementation("androidx.navigation:navigation-compose:2.9.3")

    implementation("io.coil-kt:coil-compose:2.7.0")
}
