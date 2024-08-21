package com.bugrahankaramollaoglu.compose_login.utils

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth

fun signIn(email: String, password: String, navController: NavHostController, context: Context) {

    if (email.isNotEmpty() && password.isNotEmpty()) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign-in successful
                    navController.navigate("home") {
                        // Optional: Clear the back stack
                        /*popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }*/
                    }
                    // Show Toast message
                    Toast.makeText(context, "Sign In Successful!", Toast.LENGTH_SHORT).show()
                } else {
                    // Sign-in failed
                    Toast.makeText(context, "Sign In unsuccessful..", Toast.LENGTH_SHORT).show()
                }
            }
    } else {
        Toast.makeText(context, "Email and password cannot be empty", Toast.LENGTH_SHORT).show()
    }
}
