package com.example.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.button.ui.theme.ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ButtonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HelloWorld()
                }
            }
        }
    }
}

@Composable
fun HelloWorld() {
    var visible by remember { mutableStateOf(false) }
    val name by remember { mutableStateOf("user!") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.espeon),
            contentDescription = "This is some espeon text",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Set the desired height for your image
                .padding(16.dp) // Add some padding to the image
                .animateContentSize()
                .alpha(if (visible) 1f else 0f)
        )
        Text(
            text = "Hello $name Click on the button to get Espeon!",
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Button(
            modifier = Modifier.fillMaxWidth(fraction = 0.8F),
            onClick = {
                visible = !visible
            }
        ) {
            Text("Click here", fontSize = 30.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ButtonTheme {
        HelloWorld()
    }
}
