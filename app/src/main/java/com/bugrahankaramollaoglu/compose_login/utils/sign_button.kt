package com.bugrahankaramollaoglu.compose_login.utils

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.sp
import com.bugrahankaramollaoglu.compose_login.myT


@Composable
fun signButton(
    image: Painter?,
    contentDescription: String,
    screenWidth: Dp,
    screenHeight: Dp,
    title: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth() // Fill the available width of the parent
            .padding(horizontal = 20.dp) // Apply horizontal padding (left & right)
            .height(screenHeight), // Set a fixed height if needed
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White.copy(alpha = 0.9f),
        ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (image != null) {
                Image(
                    painter = image,
                    contentDescription = contentDescription,
                    modifier = Modifier.size(24.dp) // Adjust the image size if needed
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = title, color = Color.Black, fontSize = 17.sp, fontFamily = myT)
        }

    }
}