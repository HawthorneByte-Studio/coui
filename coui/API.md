# COUI API Overview

The public API lives under `me.hawthorne.coui.ui`.

## Foundation

- `CouiTheme`, `CouiTokens`, `CouiMotion`, `CouiScaffold`
- `CouiTopBar`, `CouiCard`, `CouiButton`, `CouiButtonGroup`
- `CouiIcons` (`Home`, `Tune`, `Calendar`, `More`, `Add`, `Refresh`, `Back`,
  `Search`, `Close`, `Check`, `ChevronRight`, `Info`, `AccountCircle`, `Share`,
  `Document`)

## Forms and selection

- `CouiTextField`, `CouiSearchField`, `CouiSwitch`, `CouiCheckbox`
- `CouiRadioButton`, `CouiSlider`, `CouiStepper`
- `CouiTabLayout`, `CouiSegmentedButton`, `CouiToggleGroup`, `CouiDropdownMenu`

## Content and navigation

- `CouiListItem`, `CouiPreferenceCategory`, `CouiPreferenceItem`
- `CouiNavigationBar`, `CouiNavigationItem`, `CouiBadge`
- `CouiSection`, `CouiDivider`, `CouiEmptyState`, `CouiInfoBanner`

## Overlays and state

- `CouiDialog`, `CouiBottomSheet`, `CouiTooltip`, `CouiSnackbarHost`
- `CouiProgressIndicator`, `CouiPullRefresh`, `CouiPager`
- `CouiDatePicker` (with optional range and today action), `CouiTimePicker`

`CouiTokens.Components` exposes the shared COUI component heights for buttons,
top bars, list rows, and alert-dialog actions. `CouiTheme` also provides the
COUI typography weights and light/dark color surfaces used by the components.
Picker and interaction metrics are available through the same token group,
including date/time picker sizes, tab height, pager indicators, and pull-refresh
indicator sizing. The standalone `exampleApp` demonstrates every public
component family with interactive controls and overlays.
