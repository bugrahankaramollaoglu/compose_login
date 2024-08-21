package com.bugrahankaramollaoglu.compose_login.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bugrahankaramollaoglu.compose_login.R
import com.bugrahankaramollaoglu.compose_login.utils.CustomTextField
import com.bugrahankaramollaoglu.compose_login.utils.signButton

@Composable
fun ForgotPage(navController: NavHostController) {
    val context = LocalContext.current // Get the current context
    val backgroundImage: Painter = painterResource(id = R.drawable.bg)

    // Get screen width and height
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    // credentials
    var email by remember { mutableStateOf("") }

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

                    Box(
                        modifier = Modifier
                            .size(35.dp) // Size of the circular background
                            .align(Alignment.Start) // Aligns the Box to the start
                            .background(
                                color = Color.White.copy(alpha = 0.5f), // Background color
                                shape = RoundedCornerShape(24.dp) // Circular shape
                            )
                            .clickable {
                                navController.popBackStack()
                            }, contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black, // Icon color
                            modifier = Modifier.size(24.dp) // Size of the icon
                        )
                    }

                    Spacer(modifier = Modifier.height(screenHeight / 20))


                    Image(
                        painter = painterResource(id = R.drawable.a3),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .width(400.dp)
                            .height(200.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    CustomTextField(value = email,
                        placeholder = "Enter email",
                        keyboardType = KeyboardType.Email,
                        onValueChange = { email = it })

                    Spacer(modifier = Modifier.height(screenHeight / 40))

                    HorizontalDivider(
                        modifier = Modifier
                            .width(screenWidth * 0.5f)
                            .height(2.dp)
                            .background(Color.White.copy(alpha = 0.8f))
                    )

                    Spacer(modifier = Modifier.height(screenHeight / 30))

                    signButton(
                        image = null,
                        contentDescription = "",
                        screenWidth = screenWidth,
                        screenHeight = screenHeight / 18,
                        title = "Send Email"
                    ) {
                        // Pass context to signIn function
//                        signIn(email, password, navController, context)
                    }

                    Spacer(modifier = Modifier.height(screenHeight / 5))
                }
            }
        }
    }
}

