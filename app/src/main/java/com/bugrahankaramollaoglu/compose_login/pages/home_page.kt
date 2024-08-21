package com.bugrahankaramollaoglu.compose_login.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bugrahankaramollaoglu.compose_login.R
import com.bugrahankaramollaoglu.compose_login.utils.signButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

val CustomGreen = Color(0xFF75CF9C)

@Composable
fun HomePage(navController: NavHostController) {

    val mail = Firebase.auth.currentUser?.email

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomGreen)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
        ) {
            if (mail != null) {
                Text("Welcome,", color = Color.White, fontSize = 30.sp)
                Text(mail, color = Color.White, fontSize = 30.sp)
                Spacer(modifier = Modifier.height(screenHeight / 25))
                signButton(
                    image = null,
                    contentDescription = "Sign Out",
                    screenWidth = screenWidth * 0.8f,
                    screenHeight = screenHeight / 20,
                    title = "Sign Out"
                ) {
                    Firebase.auth.signOut()
                }
            }
        }

        // Place the Image at the bottom-right corner
        Image(
            painter = painterResource(id = R.drawable.leaff),
            contentDescription = "Leaf",
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}
