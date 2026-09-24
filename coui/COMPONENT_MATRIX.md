# COUI Component Matrix

This document is the clean-room reverse-engineering map for rebuilding the ColorOS/OPlus UI language as `coui`.

It records:

- which ColorOS-style surfaces are already covered,
- which ones are still partial,
- which ones are missing,
- and what has to be measured or implemented next.

It does **not** authorize copying proprietary OPPO/ColorOS code, resources, icons, fonts, or APK assets. The target is an independent high-fidelity Compose implementation based on observable behavior and public UI patterns.

## Status legend

| Mark | Meaning |
| --- | --- |
| `Ready` | Usable public API with light/dark support and example coverage |
| `Partial` | Working foundation, but not yet visually or behaviorally complete |
| `Missing` | No dedicated `coui` implementation yet |
| `Planned` | Not part of the current Android-only milestone |

---

## 1. Foundation and app structure

| ColorOS/OPlus pattern | Current `coui` API | Status | Gaps / next actions |
| --- | --- | --- | --- |
| Global theme | `CouiTheme` | Ready | Add complete semantic color roles and dynamic color support |
| Design tokens | `CouiTokens` | Ready | Expand token groups for touch targets, ripple, focus, and state layers |
| Motion tokens | `CouiMotion` | Partial | Add enter/exit, press, sheet, and navigation transition presets |
| Screen scaffold | `CouiScaffold` | Ready | Add bottom-sheet and drawer slots if those components land |
| Top app bar | `CouiTopBar` | Ready | Add large, collapsing, and scrolling variants |
| Card surface | `CouiCard` | Ready | Add tonal, outlined, clickable, and media-card variants |
| Button | `CouiButton` | Partial | Add primary/secondary/tonal/text variants and icon slots |
| Button group | `CouiButtonGroup` | Partial | Add horizontal group and segmented action row |
| Icon set | `CouiIcons` | Partial | Expand beyond the current 15 icons; keep vectors original |
| Empty state | `CouiEmptyState` | Ready | Add standard illustration slot and compact variant |
| Section header | `CouiSection` | Ready | Add ColorOS-style uppercase/settings variants |
| Divider | `CouiDivider` | Ready | Add inset, full-bleed, and vertical variants |

## 2. Navigation

| ColorOS/OPlus pattern | Current `coui` API | Status | Gaps / next actions |
| --- | --- | --- | --- |
| Bottom navigation bar | `CouiNavigationBar` | Ready | Add hide-on-scroll and pill/indicator motion refinements |
| Navigation item | `CouiNavigationItem` | Ready | Add selected indicator, badge dot, and long-press behavior |
| Badge | `CouiBadge` | Ready | Add dot badge, count overflow, and inline variants |
| Top tab bar | `CouiTabLayout` | Partial | Add scrollable tabs, indicator animation, and icon+label mode |
| Dropdown menu | `CouiDropdownMenu` | Partial | Add icons, shortcuts, dividers, check state, and submenu |
| Drawer / side navigation | — | Missing | Add modal drawer and navigation drawer item |
| Navigation rail | — | Missing | Useful for tablet/desktop if multiplatform targets are added |
| Bottom app bar | — | Missing | Add FAB dock and action overflow |
| Search bar / search view | `CouiSearchField` | Partial | Add expandable search, suggestion list, and clear behavior |

## 3. Inputs

| ColorOS/OPlus pattern | Current `coui` API | Status | Gaps / next actions |
| --- | --- | --- | --- |
| Text field | `CouiTextField` | Partial | Add multiline, prefix/suffix, counter, helper, error, and leading/trailing icons |
| Search field | `CouiSearchField` | Partial | Add focused/expanded states, voice/action slots, and cancel affordance |
| Switch row | `CouiSwitch` | Ready | Add ColorOS track/thumb metrics and press-state polish |
| Checkbox row | `CouiCheckbox` | Ready | Add three-state and custom checkmark metrics |
| Radio row | `CouiRadioButton` | Ready | Add group wrapper and selection motion |
| Slider | `CouiSlider` | Partial | Add steps, value label, custom thumb/track, and haptics hooks |
| Stepper | `CouiStepper` | Partial | Add hold-to-repeat, compact variant, and bounds messaging |
| Number input | — | Missing | Add decimal/integer/currency variants |
| Password field | — | Missing | Add visibility toggle and strength/error states |
| Autocomplete | — | Missing | Add suggestion overlay and keyboard integration |

## 4. Selection and filters

| ColorOS/OPlus pattern | Current `coui` API | Status | Gaps / next actions |
| --- | --- | --- | --- |
| Segmented button | `CouiSegmentedButton` | Ready | Add icon-only, multi-select, and connected-group metrics |
| Toggle group | `CouiToggleGroup` | Ready | Add exclusive/inclusive modes and overflow handling |
| Chip | `CouiChip` | Partial | Add filter, input, assist, and icon chips |
| Filter group | — | Missing | Add selected-count behavior and clear action |
| Multi-select list | — | Missing | Add selection state, batch action bar, and select-all |
| Date picker | `CouiDatePicker` | Ready | Add range picker, year jump, accessibility labels, and locale polish |
| Time picker | `CouiTimePicker` | Ready | Add wheel-style variant, AM/PM accuracy, and keyboard entry |

## 5. Content and settings

| ColorOS/OPlus pattern | Current `coui` API | Status | Gaps / next actions |
| --- | --- | --- | --- |
| List item | `CouiListItem` | Partial | Add one/two/three-line variants, avatars, value text, and chevron standard |
| Preference category | `CouiPreferenceCategory` | Ready | Add sticky header behavior |
| Preference item | `CouiPreferenceItem` | Partial | Add switch, checkbox, radio, value, and icon variants |
| Info banner | `CouiInfoBanner` | Ready | Add severity colors and dismiss action |
| Progress indicator | `CouiProgressIndicator` | Partial | Add circular mode, determinate/indeterminate polish, and stop behavior |
| Loading skeleton | — | Missing | Add shimmer skeleton for cards/lists |
| Media card | — | Missing | Add image, title/subtitle, and action area |
| Avatar | — | Missing | Add image, initial, badge, and group avatar |
| Pull-to-refresh | `CouiPullRefresh` | Ready | Add overscroll edge effect and refresh-state animation refinement |
| Pager | `CouiPager` | Ready | Add scroll indicator alignment and page-transform hooks |

## 6. Overlays

| ColorOS/OPlus pattern | Current `coui` API | Status | Gaps / next actions |
| --- | --- | --- | --- |
| Alert dialog | `CouiDialog` | Ready | Add icon, custom content, neutral action, and button layout variants |
| Bottom sheet | `CouiBottomSheet` | Partial | Add drag handle, peek height, expanded state, and dismiss-on-scroll |
| Tooltip | `CouiTooltip` | Ready | Add rich content and persistent tooltip mode |
| Snackbar | `CouiSnackbarHost` | Partial | Add action layout, duration presets, and accessibility announcements |
| Popup | `CouiDropdownMenu` | Partial | Add floating popup and anchored placement variants |
| Context menu | — | Missing | Add long-press menu and clipboard-style actions |
| Action sheet | — | Missing | Add bottom action list and destructive style |
| Toast | — | Missing | Decide whether to wrap Snackbar or expose a separate lightweight API |
| Full-screen dialog | — | Missing | Add title, close/save actions, and content scroll behavior |

## 7. Pickers and calendars

| ColorOS/OPlus pattern | Current `coui` API | Status | Gaps / next actions |
| --- | --- | --- | --- |
| Date picker | `CouiDatePicker` | Ready | Add month/year navigation polish and disabled-date styling |
| Date range | — | Missing | Add start/end selection and range highlight |
| Time picker | `CouiTimePicker` | Ready | Add wheel metrics, focus ring, and 12/24-hour correctness |
| Duration picker | — | Missing | Add hour/minute/second layout |
| Wheel picker | — | Missing | Add generic scroll wheel for options |
| Calendar view | — | Missing | Add month grid, event dot, and selection model |

## 8. Feedback and state

| ColorOS/OPlus pattern | Current `coui` API | Status | Gaps / next actions |
| --- | --- | --- | --- |
| Empty state | `CouiEmptyState` | Ready | Add compact and illustration variants |
| Error state | `CouiInfoBanner` | Partial | Add dedicated error/warning/success tokens |
| Disabled state | Component parameters | Partial | Audit every control for disabled color, alpha, and focus behavior |
| Loading state | `CouiProgressIndicator` | Partial | Add inline, button, and page-level loading states |
| Success feedback | `CouiSnackbarHost` | Partial | Add icon and duration presets |
| Haptics | — | Missing | Add platform-neutral hooks for press/selection/scroll events |

## 9. Accessibility and quality

| Requirement | Current status | Gaps / next actions |
| --- | --- | --- |
| Dark theme | Partial | Audit all tokens and state colors for contrast |
| Touch targets | Partial | Enforce minimum target size across icons and compact controls |
| Focus state | Missing | Add visible focus indicators and keyboard traversal |
| Screen reader | Partial | Add content descriptions, roles, and state descriptions |
| RTL | Partial | Audit directional padding and icons |
| Reduced motion | Missing | Add a motion scale/token override |
| Component previews | Partial | Expand `CouiPreviews.kt` to cover state combinations |
| Screenshot tests | Missing | Add light/dark and state screenshot coverage |
| API docs | Partial | Keep `API.md` synchronized with each release |

---

## Reverse-engineering checklist

Use this checklist when comparing `coui` against real ColorOS behavior.

### Visual

- Overall width/height
- Corner radius
- Stroke width and color
- Container/fill color
- Content color
- Disabled color and alpha
- Pressed color and alpha
- Focus ring
- Spacing inside and around the control
- Typography family, size, weight, and line height
- Icon size and optical alignment
- Light/dark variants

### Interaction

- Tap target size
- Press feedback
- Long-press behavior
- Double-tap behavior
- Selection state
- Disabled behavior
- Keyboard focus behavior
- Scroll behavior
- Drag/dismiss behavior
- Animation curve and duration
- Haptic feedback

### Structure

- Slots for leading/trailing content
- Optional title/subtitle/action
- Maximum and minimum sizes
- Overflow behavior
- Localization and text scaling
- Accessibility role and state

---

## Suggested implementation order

### P0 — Foundation accuracy

1. Audit `CouiTokens` against measured ColorOS dimensions.
2. Complete button variants and state colors.
3. Complete text-field states and multiline support.
4. Add visible focus indicators.
5. Audit every component for disabled and pressed states.
6. Add screenshot tests for light/dark themes.

### P1 — Core ColorOS patterns

1. FAB and extended FAB.
2. Bottom app bar.
3. Drawer/side navigation.
4. Action sheet.
5. Context menu.
6. Filter chips and filter groups.
7. Multi-select list.
8. Circular progress indicator.
9. Loading skeleton.

### P2 — Advanced controls

1. Date range picker.
2. Generic wheel picker.
3. Duration picker.
4. Calendar view.
5. Autocomplete.
6. Rich media card.
7. Avatar group.

### P3 — Motion and platform expansion

1. Enter/exit motion presets.
2. Sheet drag physics.
3. Navigation transition presets.
4. Reduced-motion support.
5. Desktop/JVM target if the library becomes multiplatform.
6. Optional iOS/WasmJS targets after JVM is stable.

---

## Definition of “complete” for this project

`coui` is considered complete when:

1. Every component in this matrix has a public API.
2. Each component has light and dark variants.
3. Each component handles normal, pressed, focused, selected, and disabled states.
4. Each component has at least one interactive example in `exampleApp`.
5. Each component has previews and screenshot coverage.
6. Accessibility roles, labels, and state descriptions are implemented.
7. API documentation stays synchronized with the public surface.
8. No proprietary OPPO/ColorOS code or assets are copied.
