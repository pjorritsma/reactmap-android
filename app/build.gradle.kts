plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.firebaseCrashlytics)
    alias(libs.plugins.googleServices)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "be.mygod.reactmap"
    compileSdk = 34

    defaultConfig {
        applicationId = "be.mygod.reactmap"
        minSdk = 24
        targetSdk = 34
        versionCode = 12
        versionName = "0.4.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isPseudoLocalesEnabled = true
        }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures.buildConfig = true
    val javaVersion = JavaVersion.VERSION_11
    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
    kotlinOptions.jvmTarget = javaVersion.toString()
    packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
}

dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.activity)
    implementation(libs.browser)
    implementation(libs.core.ktx)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    implementation(libs.fragment)   // update to 1.3+ to suppress lint
    implementation(libs.play.services.location)
    implementation(libs.lifecycle.common)
    implementation(libs.timber)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
