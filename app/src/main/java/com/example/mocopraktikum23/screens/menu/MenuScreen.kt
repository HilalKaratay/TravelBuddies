package com.example.mocopraktikum23.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(){
Column(modifier = Modifier.padding(2.dp)) {
        Text(text = "Das ist mein Menü")
    }
}
