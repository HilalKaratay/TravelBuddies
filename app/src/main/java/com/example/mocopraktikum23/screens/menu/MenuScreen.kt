package com.example.mocopraktikum23.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mocopraktikum23.R
import com.example.mocopraktikum23.screens.login.HeadingTextComponent

@Composable
fun MenuScreen() {

            Row(modifier = Modifier.padding(10.dp)) {
                HeadingTextComponent(value = "Meine Freundesliste")
                Spacer(modifier = Modifier.height(40.dp))
                friendslist("Lara Fischer")
                friendslist("Selin Karimov")
            }
        }

    @Composable
    fun friendslist(freundName :String){
        Row(
            verticalAlignment =Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.profilpng),
                modifier = Modifier
                    .size(70.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = freundName)

    }
}

@Preview
@Composable
fun MenuScreenPreview(){
    MenuScreen()
}
