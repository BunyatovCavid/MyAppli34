plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    id ("kotlin-kapt")
}



android {
    namespace = "com.example.myappli"
    compileSdk = 34

    packagingOptions {
        exclude ("META-INF/atomicfu.kotlin_module")
    }


    buildFeatures{
        viewBinding = true
        dataBinding = true
    }

    defaultConfig {
        applicationId = "com.example.myappli"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation ("androidx.appcompat:appcompat:$rootProject.appCompatVersion")
    implementation ("androidx.activity:activity-ktx:$rootProject.activityVersion")


    // Lifecycle components
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$rootProject.lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$rootProject.lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-common-java8:$rootProject.lifecycleVersion")

    // Kotlin components
   // implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$rootProject.coroutines")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$rootProject.coroutines")

    // UI
    implementation ("androidx.constraintlayout:constraintlayout:$rootProject.constraintLayoutVersion")
    implementation ("com.google.android.material:material:$rootProject.materialVersion")

    // Testing
    testImplementation ("junit:junit:$rootProject.junitVersion")
    androidTestImplementation ("androidx.arch.core:core-testing:$rootProject.coreTestingVersion")
    androidTestImplementation ("androidx.test.espresso:espresso-core:$rootProject.espressoVersion", {
        exclude( ("com.android.support"), ("support-annotations"))
    })
    androidTestImplementation ("androidx.test.ext:junit:$rootProject.androidxJunitVersion")

    implementation ("androidx.room:room-runtime:2.2.5")
    kapt ("androidx.room:room-compiler:2.2.5")
    implementation ("androidx.room:room-ktx:2.2.5")
    androidTestImplementation ("androidx.room:room-testing:2.2.5")

    implementation ("com.squareup.picasso:picasso:2.8")
    implementation ("com.github.bumptech.glide:glide:4.10.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.0")
    implementation ("androidx.cardview:cardview:1.0.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}