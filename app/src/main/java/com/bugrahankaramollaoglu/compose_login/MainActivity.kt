package com.bugrahankaramollaoglu.compose_login

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bugrahankaramollaoglu.compose_login.ui.theme.Compose_loginTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_loginTheme {
                LoginPage()
            }
        }
    }
}

val myT = FontFamily(
    androidx.compose.ui.text.font.Font(R.font.kulim)
)

@Composable
fun LoginPage() {
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



        CustomGlassCard {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
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
                    // Handle Google sign-in click
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
                }

                Spacer(modifier = Modifier.height(30.dp))
                Row {
                    Text(text = "No Account? ", color = Color.White)
                    Text(
                        text = "Sign Up",
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = myT,
                            fontSize = 19.sp
                        )
                    )
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

/*
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
                        // Handle Google sign-in click
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
                    }

                    Spacer(modifier = Modifier.height(30.dp))
                    Row {
                        Text(text = "No Account? ", color = Color.White)
                        Text(
                            text = "Sign Up",
                            color = Color.White,
                            style = TextStyle(
                                fontFamily = myT,
                                fontSize = 19.sp
                            )
                        )
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
        }*/
    }
}

@Composable
fun CustomGlassCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.1f)
        ),
//        elevation = 0.dp
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.1f),
                            Color.White.copy(alpha = 0.3f)
                        )
                    )
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}


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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_loginTheme {
        LoginPage()
    }
}
