package com.bugrahankaramollaoglu.compose_login.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    placeholder: String,
    keyboardType: KeyboardType,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
    showHidePassword: (() -> Unit)? = null,
    isPasswordVisible: Boolean = true,
) {
    val visualTransformation = if (isPassword && !isPasswordVisible) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { showHidePassword?.invoke() }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Rounded.VisibilityOff else Icons.Rounded.Visibility,
                        contentDescription = if (isPasswordVisible) "Hide password" else "Show password"
                    )
                }
            }
        },
        maxLines = 1,
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Color.Black,
            containerColor = Color.White.copy(alpha = 0.9f),
            focusedBorderColor = Color.Black.copy(alpha = 0.7f),
        ),
        textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.W600),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}