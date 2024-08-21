package com.bugrahankaramollaoglu.compose_login

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bugrahankaramollaoglu.compose_login.pages.HomePage
import com.bugrahankaramollaoglu.compose_login.pages.MainPage
import com.bugrahankaramollaoglu.compose_login.pages.SignInPage
import com.bugrahankaramollaoglu.compose_login.pages.SignUpPage
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
                Navigation()
            }
        }
    }
}

suspend fun signInWithEmail(email: String, password: String): String? {
    return try {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).await()
        FirebaseAuth.getInstance().currentUser?.uid // Return the user ID
    } catch (e: Exception) {
        e.message // Return the error message
    }
}

val myT = FontFamily(
    androidx.compose.ui.text.font.Font(R.font.kulim)
)

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("signIn") { SignInPage(navController) }
        composable("signUp") { SignUpPage(navController) }
        composable("main") { MainPage(navController) }
        composable("home") { HomePage(navController) }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_loginTheme {
        LoginPage(navController)
    }
}
*/
