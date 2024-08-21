package com.bugrahankaramollaoglu.compose_login.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bugrahankaramollaoglu.compose_login.R
import com.bugrahankaramollaoglu.compose_login.myT
import com.bugrahankaramollaoglu.compose_login.utils.signButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

val CustomGreen = Color(0xFF75CF9C)

@Composable
fun HomePage(navController: NavHostController) {

    val mail = Firebase.auth.currentUser?.email

    // State variables for dialog
    val (showDialog, setShowDialog) = remember { mutableStateOf(false) }
    val (dialogAction, setDialogAction) = remember { mutableStateOf<(() -> Unit)?>(null) }

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
                Text("Welcome,", color = Color.White, fontSize = 30.sp, fontFamily = myT)
                Spacer(modifier = Modifier.height(screenHeight / 100))
                Text(
                    mail,
                    color = Color.White,
                    fontSize = 28.sp,
                    fontFamily = myT,
                    modifier = Modifier.fillMaxWidth(
                        0.8f
                    )
                )
                Spacer(modifier = Modifier.height(screenHeight / 25))
                signButton(
                    image = null,
                    contentDescription = "Sign Out",
                    screenWidth = screenWidth * 0.8f,
                    screenHeight = screenHeight / 20,
                    title = "Sign Out"
                ) {
                    setShowDialog(true)
                    setDialogAction {
                        Firebase.auth.signOut()
                        // Optionally, navigate back or update UI
                    }
                }
            }
        }

        if (showDialog) {
            AlertDialog(onDismissRequest = { setShowDialog(false) }, title = {
                Text(
                    "Warning", style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontFamily = myT,
                        fontSize = 30.sp,
                    )
                )
            }, text = {
                Text(
                    "Are you sure you want to sign out?", style = TextStyle(
                        fontSize = 17.sp,
                        fontFamily = myT,
                    )
                )
            }, confirmButton = {
                Button(
                    onClick = {
                        dialogAction?.invoke()
                        setShowDialog(false)
                        navController.navigate("main")
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = CustomGreen

                    )
                ) {
                    Text(
                        "Yes", style = TextStyle(
                            fontFamily = myT,
                            fontSize = 17.sp,
                            color = Color.Black.copy(alpha = 0.6f)
                        )
                    )
                }
            }, dismissButton = {
                Button(
                    onClick = { setShowDialog(false) }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black

                    )
                ) {
                    Text(
                        "No", style = TextStyle(
                            fontFamily = myT,
                            fontSize = 15.sp,
                        )
                    )
                }
            })
        }


        // Place the Image at the bottom-right corner
        Image(
            painter = painterResource(id = R.drawable.leaff),
            contentDescription = "Leaf",
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}
