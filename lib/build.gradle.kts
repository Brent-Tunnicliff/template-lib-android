// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("maven-publish")
}

android {
    namespace = "dev.tunnicliff.replace_me"
    compileSdk = 35

    defaultConfig {
        minSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            testCoverage {
                enableAndroidTestCoverage = true
                enableUnitTestCoverage = true
            }
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        buildConfig = true
    }
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])
                groupId = "dev.tunnicliff"
                artifactId = "lib-replace_me-android"
                version = "0.1.0-alpha.1"

                pom {
                    packaging = "aar"
                    name.set("lib-replace_me-android")
                    description.set("replace_me")
                    url.set("https://github.com/Brent-Tunnicliff/lib-replace_me-android")
                    inceptionYear.set("2024")

                    licenses {
                        license {
                            name.set("MIT License")
                            url.set("https://opensource.org/licenses/MIT")
                        }
                    }

                    developers {
                        developer {
                            id.set("brent")
                            name.set("Brent Tunnicliff")
                            email.set("brent@tunnicliff.dev")
                        }
                    }

                    scm {
                        connection.set("scm:git:https://github.com/Brent-Tunnicliff/lib-replace_me-android.git")
                        developerConnection.set("scm:git:ssh://git@github.com:Brent-Tunnicliff/lib-replace_me-android.git")
                        url.set("https://github.com/Brent-Tunnicliff/lib-replace_me-android")
                    }
                }
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.lib.container.android)
    implementation(libs.lib.logging.android)
    implementation(libs.material)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}