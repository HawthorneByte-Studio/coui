This is a Kotlin Multiplatform project targeting Android.

The `coui` module provides the initial Compose Multiplatform UI foundation under
`me.hawthorne.coui.ui`, including theme tokens, top bars, cards, buttons, text
fields, switches, and list items.
It also includes `CouiDialog` and `CouiBottomSheet` for common overlay patterns.
Feedback and settings layouts can use `CouiSection`, `CouiDivider`, and
`CouiProgressIndicator`.
Interactive controls include `CouiSlider`, `CouiRadioButton`, and `CouiSnackbarHost`.
Content patterns include `CouiSearchField`, `CouiIconButton`, and `CouiEmptyState`.
Navigation can use `CouiNavigationBar`, `CouiNavigationItem`, and `CouiBadge`.
Selection controls include `CouiTabLayout`, `CouiCheckbox`, and `CouiDropdownMenu`.
Status and compact controls include `CouiChip`, `CouiStepper`, and `CouiInfoBanner`.
The shared foundation also exposes `CouiTokens`, `CouiMotion`, and `CouiScaffold`
for consistent spacing, shapes, elevation, animation, and screen structure.
The token set includes values extracted from `oplus-framework-res.apk`, including
the 58dp alert-dialog button height, 16dp XL corner radius, and popup blur colors.
Selection layouts can use `CouiSegmentedButton` or the `CouiToggleGroup` shorthand.
Settings screens can use `CouiPreferenceCategory` and `CouiPreferenceItem`.
Long-press guidance can use `CouiTooltip` without opting into experimental Material APIs.
The `coui` module also includes reusable Compose previews in `CouiPreviews.kt`.
See [`coui/API.md`](./coui/API.md) for the current component surface and
[`CHANGELOG.md`](./CHANGELOG.md) for the development history.
Calendar screens can use `CouiDatePicker` with the platform-neutral `CouiDate` model.
`CouiDatePicker` also supports optional `minDate`, `maxDate`, and `today` constraints.
`CouiTimePicker` supports a visible 12/24-hour mode switch and minute snapping.
Time selection screens can use `CouiTimePicker` with the platform-neutral `CouiTime` model.
Scrollable screens can use `CouiPullRefresh` as the refresh state wrapper.
The wrapper applies drag damping and exposes progress before the refresh threshold.
Paged content can use `CouiPager` with its built-in page indicators.
Picker, tab, pager, and pull-refresh dimensions are exposed through
`CouiTokens.Components` so applications can keep custom layouts aligned with
the extracted COUI measurements.
`CouiScaffold` accepts configurable `contentWindowInsets`; the Android sample
also enables edge-to-edge rendering through `enableEdgeToEdge()`.

* [/shared](./shared/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./shared/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./shared/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./shared/src/jvmMain/kotlin)
    folder is the appropriate location.

### Running the apps

Use the run configurations provided by the run widget in your IDE's toolbar. You can also use these commands and options:

- Android app: `./gradlew :androidApp:assembleDebug`
- COUI example app: `./gradlew :exampleApp:assembleDebug`

The `exampleApp` module is a standalone showcase application for the reusable
COUI components. The existing `androidApp` module remains the original sample
application.
The showcase includes Home, Controls, Pickers, and More pages with interactive
overlays, refresh feedback, vector icons, preferences, pager, and tooltip examples.

### Publishing and consuming COUI

The Android `coui` library publishes as `me.hawthorne.coui:coui:0.1.0`.
Publish a local Maven artifact with:

```powershell
.\gradlew.bat :coui:publishAndroidPublicationToMavenLocal
```

In another Android project, add `mavenLocal()` before remote repositories and
depend on the library:

```kotlin
repositories {
    mavenLocal()
    google()
    mavenCentral()
}

dependencies {
    implementation("me.hawthorne.coui:coui:0.1.0")
}
```

### Running tests

Use the run button in your IDE's editor gutter, or run tests using Gradle tasks:

- Android tests: `./gradlew :shared:testAndroidHostTest`

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
