buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url  = uri("https://dl.bintray.com/kodein-framework/Kodein-DI/org/kodein/di/") }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath ("org.jetbrains.kotlin:kotlin-serialization:1.4.31")

    }
}

allprojects {
    repositories {
        google()
        mavenCentral()

        maven { url = uri("https://dl.bintray.com/icerockdev/moko") }
        maven { url = uri ("https://dl.bintray.com/florent37/maven") }
        maven { url = uri("https://dl.bintray.com/kodein-framework/Kodein-DI") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}