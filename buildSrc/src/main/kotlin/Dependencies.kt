/**
 * This file contains all the dependencies we need in our project. Because we placed
 * them inside the buildSrc module we get auto code completion inside the rest of the project.
 * More information about this dependency management technique is available at:
 * https://handstandsam.com/2018/02/11/kotlin-buildsrc-for-better-gradle-dependency-management/
 *
 * @author Dennis Wehrle
 */
@Suppress("unused")
object Versions {

    // Android
    const val androidCompileSdk = 27
    const val androidMinSdk = 16
    const val androidTargetSdk = 27

    const val constraintLayout = "1.0.2"
    const val supportLibrary = "27.1.0"

    // App Libraries
    const val dagger = "2.15"
    const val glassfishAnnotation = "10.0-b28"
    const val glide = "4.6.1"
    const val gson = "2.8.1"
    const val javaxAnnotation = "1.0"
    const val javaxInject = "1"
    const val kotlin = "1.2.41"
    const val leakCanary = "1.5.4"
    const val okHttp = "3.8.1"
    const val retrofit = "2.4.0"
    const val room = "1.0.0"
    const val rxAndroid = "2.0.2"
    const val rxJava = "2.1.12"
    const val rxKotlin = "2.2.0"
    const val stetho = "1.5.0"
    const val timber = "4.6.1"
    const val pageIndicatorView = "0.2.0"
    const val moshi = "1.6.0"
    const val lifecycle = "1.1.1"
    const val lifecycleCompiler = "1.1.1"

    // Test Libraries
    const val androidSupportRules = "1.0.0"
    const val androidSupportRunner = "1.0.0"
    const val assertJ = "3.8.0"
    const val dexmakerMockito = "2.16.0"
    const val dexopener = "0.12.1"
    const val espresso = "3.0.1"
    const val jUnit = "4.12"
    const val mockitoKotlin = "1.5.0"
    const val robolectric = "3.4.2"
    const val runner = "0.5"
}

@Suppress("unused")
object AppDependencies {

    const val androidSupportAnnotations = "com.android.support:support-annotations:${Versions.supportLibrary}"
    const val androidSupportAppCompatV7 = "com.android.support:appcompat-v7:${Versions.supportLibrary}"
    const val androidSupportConstraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"
    const val androidSupportDesign = "com.android.support:design:${Versions.supportLibrary}"
    const val androidSupportRecyclerView = "com.android.support:recyclerview-v7:${Versions.supportLibrary}"
    const val androidSupportV13 = "com.android.support:support-v13:${Versions.supportLibrary}"
    const val androidSupportCardView = "com.android.support:cardview-v7:${Versions.supportLibrary}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val glassfishAnnotation = "org.glassfish:javax.annotation:${Versions.glassfishAnnotation}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val javaxAnnotation = "javax.annotation:jsr250-api:${Versions.javaxAnnotation}"
    const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInject}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val leakCanaryDebug = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val leakCanaryRelease = "com.squareup.leakcanary:leakcanary-android-no-op:${Versions.leakCanary}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLogger = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val pageindicatorview = "com.romandanylyk:pageindicatorview:${Versions.pageIndicatorView}@aar"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val roomCompiler = "android.arch.persistence.room:compiler:${Versions.room}"
    const val roomRuntime = "android.arch.persistence.room:runtime:${Versions.room}"
    const val roomRxJava = "android.arch.persistence.room:rxjava2:${Versions.room}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    const val stetho = "com.facebook.fresco:stetho:${Versions.stetho}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val lifecycle = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
    const val lifecycleCompiler = "android.arch.lifecycle:compiler:${Versions.lifecycleCompiler}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:2.0.0-beta3"

}

@Suppress("unused")
object TestDependencies {

    const val androidRules = "com.android.support.test:rules:${Versions.runner}"
    const val androidRunner = "com.android.support.test:runner:${Versions.runner}"
    const val assertj = "org.assertj:assertj-core:${Versions.assertJ}"
    const val dexmakerMockito = "com.linkedin.dexmaker:dexmaker-mockito:${Versions.dexmakerMockito}"
    const val dexopener = "com.github.tmurakami:dexopener:${Versions.dexopener}"
    const val espressoContrib = "com.android.support.test.espresso:espresso-contrib:${Versions.espresso}"
    const val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoIntents = "com.android.support.test.espresso:espresso-intents:${Versions.espresso}"
    const val junit = "junit:junit:${Versions.jUnit}"
    const val kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    const val mockitoKotlin = "com.nhaarman:mockito-kotlin:${Versions.mockitoKotlin}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val roomTesting = "android.arch.persistence.room:testing:${Versions.room}"
    const val supportRules = "com.android.support.test:rules:${Versions.androidSupportRules}"
    const val supportRunner = "com.android.support.test:runner:${Versions.androidSupportRunner}"
} 
