package com.example.animatedwaterbottle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.animatedwaterbottle.ui.theme.AnimatedWaterBottleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedWaterBottleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var usedAmount by remember {
                        mutableStateOf(200)
                    }

                    val totalWaterAmount = remember {
                        2000
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.LightGray),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        WaterBottle(
                            totalWaterAmount = totalWaterAmount,
                            unit = "ml",
                            usedWaterAmount = usedAmount,
                            modifier = Modifier.width(250.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Total amount is : $totalWaterAmount")
                        Button(onClick = { usedAmount += 200 }) {
                            Text(text = "Drink")
                        }
                    }
                }
            }
        }
    }
}