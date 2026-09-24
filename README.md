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
Paged content can use `CouiPager` with its built-in page indicators.
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

### Running tests

Use the run button in your IDE's editor gutter, or run tests using Gradle tasks:

- Android tests: `./gradlew :shared:testAndroidHostTest`

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
