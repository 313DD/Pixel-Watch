plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "dev.matti.pixelwatch"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.matti.pixelwatch"
        // WFF version 1 is supported from Wear OS 4 (API 33) onward.
        // Keep minSdk at the lowest level your declared format version needs,
        // to reach the widest range of watches.
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            // Watch Face Format bundles are resource-only (no code), so keep
            // resource shrinking off — it can strip XML/complication resources
            // the format needs at runtime.
            isShrinkResources = false
        }
    }
}
