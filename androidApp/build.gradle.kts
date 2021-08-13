

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    // MULTI DEX
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    implementation ("androidx.core:core-ktx:1.6.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")


    // ARCHITECTURE COMPONENTS

    implementation("dev.icerock.moko:mvvm:0.10.0")
    // RECYCLER VIEW
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "com.example.myloginkmm.android"
        minSdkVersion(16)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }


}