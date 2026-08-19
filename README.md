# Pixel-Watch

A minimalist, battery-friendly digital watch face for the Google Pixel Watch 3, built with the
[Watch Face Format (WFF)](https://developer.android.com/training/wearables/wff) — pure XML,
no Kotlin/Java code.

- Digital clock (HH:MM) centered on the face
- 5 non-overlapping complication slots for app shortcuts, arranged at 12, 9, 3 o'clock and
  lower-left / lower-right
- No background asset drawn, so the AMOLED panel stays true black behind the UI (saves power)

## Project layout

```
Pixel-Watch/
├── settings.gradle.kts
├── build.gradle.kts
├── gradle/                      # Gradle wrapper (8.13) + version catalog
├── gradlew / gradlew.bat
└── watchface/
    ├── build.gradle.kts          # applicationId, min/target/compileSdk
    └── src/main/
        ├── AndroidManifest.xml   # WFF declaration (android:hasCode="false")
        └── res/
            ├── raw/watchface.xml       # the watch face definition itself
            ├── xml/watch_face_info.xml # picker metadata (preview, editable)
            ├── values/strings.xml      # watch face display name
            ├── drawable/preview.png    # picker preview image
            └── mipmap/ic_launcher.png  # app icon
```

## Opening the project

1. Install [Android Studio](https://developer.android.com/studio) (Ladybug or newer recommended).
2. `File > Open...` and select this `Pixel-Watch` folder.
3. Let Gradle sync — the first sync needs network access to download the Android Gradle Plugin
   and platform SDKs, which Android Studio handles automatically.
4. Connect a Pixel Watch 3 (with USB/Wi-Fi debugging and developer options enabled) or start a
   Wear OS emulator, then press **Run**.
5. On the watch, open the watch face picker, select **Pixel Watch Minimal**, and assign your
   5 shortcuts to the empty complication slots by tapping each one.

## Editing the design

All of the visual design lives in one file: `watchface/src/main/res/raw/watchface.xml`. Android
Studio's editor validates WFF XML as you type (with the Watch Face Format plugin/support built
into recent versions) and flags syntax errors before you build.

Useful references:
- [Watch Face Format overview](https://developer.android.com/training/wearables/wff)
- [Provide useful data through complications](https://developer.android.com/training/wearables/wff/complications)
- [Represent the time](https://developer.android.com/training/wearables/wff/time)
- [Watch Face Format setup](https://developer.android.com/training/wearables/wff/setup)

## Notes

- `applicationId`/`namespace` is currently set to `dev.matti.pixelwatch` — change it in
  `watchface/build.gradle.kts` if you'd prefer something else.
- `minSdk 33` targets Wear OS 4+ (WFF format version 1), which covers the Pixel Watch 3 and is
  the widest-compatible baseline for the features this face uses.
- This repo was scaffolded in a sandboxed environment without access to Google's Maven/Gradle
  Plugin repositories, so the Gradle build itself hasn't been run end-to-end here — open it in
  Android Studio for the first real build and sync.
