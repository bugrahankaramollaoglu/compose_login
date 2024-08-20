package com.bugrahankaramollaoglu.compose_login.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun signButton(
    image: Painter,
    contentDescription: String,
    screenWidth: Dp,
    screenHeight: Dp,
    title: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(screenWidth) // Adjusting width based on screen size
            .height(screenHeight), // Set a fixed height if needed
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White.copy(alpha = 0.9f),
        ),
        shape = RoundedCornerShape(5.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = image,
                contentDescription = contentDescription,
                modifier = Modifier.size(24.dp) // Adjust the image size if needed
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = title, color = Color.Black)
        }

    }
}