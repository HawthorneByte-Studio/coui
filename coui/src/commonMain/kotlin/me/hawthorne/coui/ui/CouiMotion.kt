package me.hawthorne.coui.ui

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween

object CouiMotion {
    val FastTween: AnimationSpec<Float> = tween(
        durationMillis = CouiTokens.Motion.Fast,
        easing = FastOutSlowInEasing,
    )

    val StandardTween: AnimationSpec<Float> = tween(
        durationMillis = CouiTokens.Motion.Standard,
        easing = FastOutSlowInEasing,
    )

    val EmphasizedTween: AnimationSpec<Float> = tween(
        durationMillis = CouiTokens.Motion.Emphasized,
        easing = FastOutSlowInEasing,
    )
}
