import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("kotlinx-serialization")
}

version = "1.0"

kotlin {

    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../iosApp/Podfile")
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:1.6.2")
                // COROUTINES
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0-native-mt")
                // MOKO - MVVM
                implementation ("dev.icerock.moko:mvvm:0.10.0")
                // KODE IN
                implementation ("org.kodein.di:kodein-di:7.1.0")
                // KTOR
                implementation ("io.ktor:ktor-client-core:1.6.2")
                implementation("io.ktor:ktor-client-json:1.6.2")
                implementation("io.ktor:ktor-client-logging:1.6.2")
                implementation("io.ktor:ktor-client-serialization:1.6.2")
                // SQL Delight
                implementation ("com.squareup.sqldelight:runtime:1.4.4")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting{
            dependencies {
                implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.5.20")
                implementation ("org.jetbrains.kotlin:kotlin-stdlib-common:1.5.20")
                // MOKO - MVVM
                implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
                // KTOR
                implementation ("io.ktor:ktor-client-android:1.6.2")
                // SQL Delight
                implementation("com.squareup.sqldelight:android-driver:1.4.4")

            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting{
            dependencies {
                implementation ("org.jetbrains.kotlin:kotlin-stdlib-common:1.5.20")
                // KTOR
                implementation ("io.ktor:ktor-client-ios:1.6.2")
                // SQL Delight
                implementation("com.squareup.sqldelight:native-driver:1.4.4")
            }
        }
        val iosTest by getting
    }


}


android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(31)
    }
}
dependencies {

}
