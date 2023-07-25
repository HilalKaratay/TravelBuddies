package com.example.mocopraktikum23.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mocopraktikum23.screens.menu.MenuViewModel

@Composable
fun MenuScreen(
    openAndPopUp: (String, String) -> Unit,
    menuViewModel: MenuViewModel= hiltViewModel()
){
Column(modifier = Modifier.padding(2.dp)) {
    Text(text = "Das ist mein Menü")

}
}
