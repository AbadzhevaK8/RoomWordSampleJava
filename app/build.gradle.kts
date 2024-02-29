plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.abadzheva.roomwordsamplejava"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.abadzheva.roomwordsamplejava"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Dependencies for working with Architecture components
    // You'll probably have to update the version numbers in build.gradle (Project)

    // Room components
    implementation (libs.room.runtime)
    annotationProcessor (libs.room.compiler)
    androidTestImplementation (libs.room.testing)

    // Lifecycle components
    implementation (libs.lifecycle.viewmodel)
    implementation (libs.lifecycle.livedata)
    implementation (libs.lifecycle.common.java8)

    // UI
    implementation (libs.constraintlayout)
    implementation (libs.material)

    // Testing

    androidTestImplementation (libs.core.testing)
    androidTestImplementation(libs.espresso.core)

    androidTestImplementation("androidx.test.espresso:espresso-core:$rootProject.espressoVersion") {
        exclude(group = "com.android.support", module = "support-annotations")
    }

}