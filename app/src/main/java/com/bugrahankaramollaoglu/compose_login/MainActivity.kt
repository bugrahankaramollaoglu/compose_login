package com.bugrahankaramollaoglu.compose_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bugrahankaramollaoglu.compose_login.ui.theme.Compose_loginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_loginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyCard("bugra", "türkiye", 100, 200, 300, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyCard(
    name: String,
    country: String,
    following: Int,
    follower: Int,
    posts: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Card(modifier = Modifier.) {
            Column(modifier = Modifier.padding(96.dp)) {
                Text(text = "Name: $name")
                Text(text = "Country: $country")
                Text(text = "Following: $following")
                Text(text = "Follower: $follower")
                Text(text = "Posts: $posts")
            }
        }
    }
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_loginTheme {
        Greeting("Android")
    }
}
*/
