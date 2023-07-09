package com.example.mocopraktikum23.screens.menu

import androidx.lifecycle.ViewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun StartPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFB2EBF2)), // Hintergrundfarbe auf helles Türkis ändern
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
        ) {


            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Willkommen bei",
                    color = Color.White, // Schriftfarbe auf Weiß ändern
                    fontSize = 24.sp
                )
                Text(
                    text = "TravelBuddies",
                    color = Color.White, // Schriftfarbe auf Weiß ändern
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 36.sp
                )
                Text(
                    text = "deine Reisebegleitung",
                    color = Color.White, // Schriftfarbe auf Weiß ändern
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Klick-Handler implementieren */ },
                    modifier = Modifier.background(color = Color(0xFF1565C0)) // Button-Farbe auf eine andere Farbe ändern
                ) {
                    Text(text = "Reise beginnen")
                }
            }
        }
    }
}

@Preview
@Composable
fun StartPagePreview() {
    StartPage()
}

class MenuViewModel : ViewModel() {
}

