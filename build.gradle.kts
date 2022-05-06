allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.3")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")
    }
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}
