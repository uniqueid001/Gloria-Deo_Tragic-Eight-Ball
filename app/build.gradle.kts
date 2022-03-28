plugins {
    id("com.android.application")
    kotlin("android")
    }

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "org.gloriadeocooperative.tragic_eight_ball"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
        }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
        }

    buildFeatures {
        viewBinding = true
        }

    kotlinOptions {
        jvmTarget = "11"
        }

    sourceSets {
        getByName("main") {
            java {
                // Add this directory to the defaults
                srcDir("src/main/kotlin")
                }
            } // main
        } // sourceSets
    } // android

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.preference:preference:1.1.1")
    implementation("com.google.android.material:material:1.5.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    }
