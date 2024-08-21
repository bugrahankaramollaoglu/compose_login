package com.bugrahankaramollaoglu.compose_login.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bugrahankaramollaoglu.compose_login.R
import com.bugrahankaramollaoglu.compose_login.myT
import com.bugrahankaramollaoglu.compose_login.utils.signButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInPage(navController: NavHostController) {
    val backgroundImage: Painter = painterResource(id = R.drawable.bg5)

    // Get screen width and height
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    // credentials
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(7.dp)
        )


        Card(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
                .width(screenWidth * 0.85f)
                .height(screenHeight * 0.85f),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.2f)
            )
        ) {
            Box(
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.0f),
                                Color.White.copy(alpha = 0.15f),
                            )
                        )
                    )
                    .padding(16.dp), contentAlignment = Alignment.Center
            ) {
                // Content inside the card
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {

                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "a",
                        modifier = Modifier
                            .align(Alignment.Start)
                            .clickable {
                                navController.popBackStack()
                            })

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.a1),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .width(400.dp)
                            .height(200.dp)
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    textField(email, "Enter email", KeyboardType.Email) { email = it }
                    textField(password, "Enter password", KeyboardType.Password) { password = it }

                    rememberMeCheckbox()

                    Spacer(modifier = Modifier.height(40.dp))

                    signButton(
                        image = null,
                        contentDescription = "",
                        screenWidth = screenWidth,
                        screenHeight = screenHeight / 18,
                        title = "Sign In"

                    ) {

                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Forgot Password?", style = TextStyle(
                            color = Color.White, fontFamily = myT, fontSize = 17.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(75.dp))


                }
            }
        }
    }
}

@Composable
fun rememberMeCheckbox() {
    var checked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start, // Aligns the content to the start
        modifier = Modifier.fillMaxWidth() // Makes the Row take full width
    ) {
        Checkbox(
            checked = checked, onCheckedChange = { checked = it }, colors = CheckboxDefaults.colors(
                checkmarkColor = Color.White,
                checkedColor = Color.DarkGray,
            )
        )
        Text(
            text = "Remember me",
            fontFamily = myT,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textField(value: String, hint: String, type: KeyboardType, onValueChange: (String) -> Unit) {
    val visualTransformation = if (type == KeyboardType.Password) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(hint) },

        maxLines = 1,
        shape = RoundedCornerShape(10.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = type, imeAction = ImeAction.Next
        ),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.White,
            containerColor = Color.White.copy(alpha = 0.9f),
        ),
        textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.W600),
        visualTransformation = visualTransformation,
        modifier = Modifier.padding(10.dp)
    )
}
