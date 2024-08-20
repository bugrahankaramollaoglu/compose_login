package com.bugrahankaramollaoglu.compose_login.utils

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun ShimmerText(text: String, modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()

    // Animate the shimmer position from 0f to 1000f for a smooth, slow left-to-right effect.
    val shimmerTranslateAnim = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 400f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3000, // Adjust for smooth and slow effect
                easing = LinearOutSlowInEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )

    // Create the shimmer gradient moving left to right
    val shimmerBrush = Brush.linearGradient(
        colors = listOf(
            Color.White.copy(alpha = 0.9f), // Starting color of the gradient
            Color.White.copy(alpha = 0.8f), // Middle bright white color
            Color.White.copy(alpha = 0.4f), // End color of the gradient
        ),
        start = Offset(shimmerTranslateAnim.value - 300f, 0f), // Move horizontally
        end = Offset(shimmerTranslateAnim.value, 0f)
    )

    Text(
        text = text,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
//            color = Color.White, // Base color of the text
            brush = shimmerBrush // Apply the shimmer effect brush
        ),
        modifier = modifier
    )
}
