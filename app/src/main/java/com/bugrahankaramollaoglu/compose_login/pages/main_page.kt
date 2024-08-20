package com.bugrahankaramollaoglu.compose_login.pages

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bugrahankaramollaoglu.compose_login.R
import com.bugrahankaramollaoglu.compose_login.utils.ShimmerText
import com.bugrahankaramollaoglu.compose_login.utils.signButton

@Composable
fun MainPage(navController: NavHostController) {
    val backgroundImage: Painter = painterResource(id = R.drawable.bg)
    val greenifyPhoto: Painter = painterResource(id = R.drawable.greenify)
    val google: Painter = painterResource(id = R.drawable.google)
    val apple: Painter = painterResource(id = R.drawable.apple)
    val email: Painter = painterResource(id = R.drawable.email)


    // Get screen width and height
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
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
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                // Content inside the card
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(painter = greenifyPhoto, contentDescription = "Greenify Photo")

                    Spacer(modifier = Modifier.height(20.dp))

                    signButton(
                        google,
                        "Google Sign In",
                        screenWidth * 0.85f,
                        screenHeight * 0.05f,
                        "Sign in with Google"
                    ) {
                        //TODO: signin with google
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    signButton(
                        apple,
                        "Apple Sign In",
                        screenWidth * 0.85f,
                        screenHeight * 0.05f,
                        "Sign in with Apple"
                    ) {
                        // Handle Apple sign-in
                        Log.d("mesaj", "apple Sign-In Clicked")

                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    signButton(
                        email,
                        "Email Sign In",
                        screenWidth * 0.85f,
                        screenHeight * 0.05f,
                        "Sign in with Email"
                    ) {
                        // Handle Email sign-in click
                        navController.navigate("signIn")
//                        Log.d("mesaj", "email Sign-In Clicked")
                    }

                    Spacer(modifier = Modifier.height(30.dp))
                    Row {
                        Text(text = "No Account? ", color = Color.White)
                        ShimmerText(text = "Sign Up", modifier = Modifier.clickable {
                            navController.navigate("signUp")
                        })

                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    HorizontalDivider(
                        color = Color.White,
                        thickness = 1.dp,
                        modifier = Modifier.width(screenWidth * 0.55f)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Lorem Ipsum, Lorem Ipsum, Lorem Ipsum, Lorem Ipsum, Lorem Ipsum ",
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        textAlign = TextAlign.Center,
                        text = "Cicero",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}