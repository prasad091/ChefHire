object RootVersion{
    val compileSdk   = 29
    val buildVersion = "29.0.2"
    val minSdk       = 21
    val targetSdk    = 29
    val versionCode  = 1
    val versionName  = "1.0"
}

object Versions{
val kotlin      = "1.3.61"
val appCompat   = "1.1.0"
val coreKtx     = "1.1.0"
val constraint  = "1.1.3"
val junit4      = "4.12"
val junitExt    = "1.1.1"
val espresso    = "3.2.0"
val material    = "1.0.0"
val lottie      = "3.3.0"
val playCore    = "1.6.4"
val navigation  = "2.1.0"
val dynamicFeatureFrag  = "2.3.0-SNAPSHOT"
}


object Deps{
    val kotlin_stdlib_jdk7  = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val appCompat           = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx             = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraint          = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    val material            = "com.google.android.material:material:${Versions.material}"
    val lottie              = "com.airbnb.android:lottie:${Versions.lottie}"
    val playCore            = "com.google.android.play:core:${Versions.playCore}"
    val navFragment         = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    val navUI               = "androidx.navigation:navigation-ui:${Versions.navigation}"
    val lifecycleExt        = "androidx.lifecycle:lifecycle-extensions:${Versions.navigation}"
    val navKtx              = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navUIKtx            = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val dynamicFeatureFrag  = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.dynamicFeatureFrag}"
}

object TestDeps{
    val junit4      = "junit:junit:${Versions.junit4}"
    val junitExt    = "androidx.test.ext:junit:${Versions.junitExt}"
    val espresso    = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}