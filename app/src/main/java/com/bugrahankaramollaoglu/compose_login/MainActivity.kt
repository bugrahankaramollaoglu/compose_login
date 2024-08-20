package com.bugrahankaramollaoglu.compose_login

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import kotlinx.coroutines.tasks.await


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // firebase
        Firebase.initialize(this)

        setContent {
            Compose_loginTheme {
                LoginPage()
            }
        }
    }
}

suspend fun signInWithEmail(email: String, password: String): String? {
    return try {
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .await()
        FirebaseAuth.getInstance().currentUser?.uid // Return the user ID
    } catch (e: Exception) {
        e.message // Return the error message
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
                        Log.d("mesaj", "email Sign-In Clicked")
                    }

                    Spacer(modifier = Modifier.height(30.dp))
                    Row {
                        Text(text = "No Account? ", color = Color.White)
                        ShimmerText(text = "Sign Up")
                        /*Text(
                            text = "Sign Up",
                            color = Color.White,
                            style = TextStyle(
                                fontFamily = myT,
                                fontSize = 19.sp
                            )
                        )*/
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

@Composable
fun ShimmerText(text: String) {
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
        modifier = Modifier.clickable {
            //TODO
        }
    )
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
