package com.sonu.jetpackcomposeexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sonu.jetpackcomposeexamples.ui.theme.JetpackComposeExamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .border(10.dp, color = Color.Blue)
                        .padding(10.dp)
                        .fillMaxWidth()
//                        .width(1000.dp) // set the maximum available with if require width is not available
//                        .requiredWidth(1000.dp) // in actual it gives the width
                        .fillMaxHeight(0.5f)
                        .background(color = Color.Yellow),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally //with require width text is not visible bec they are out of screen
                ) {
                    Text(
                        text = "Hello",
                        modifier = Modifier.offset(x = 0.dp, y = 20.dp)
                    ) // offset is not same as margin there is no margin in compose
                    //offset just moves the given item it does not care about other item can overlap other item
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Jetpack")
                    Text(text = "Compose")
                }

                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(color = Color.Red),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Hello")
                    Text(text = "Jetpack")
                    Text(text = "Compose")
                }
            }

        }


    }
}
