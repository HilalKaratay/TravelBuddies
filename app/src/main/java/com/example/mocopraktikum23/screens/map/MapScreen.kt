package com.example.mocopraktikum23

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.screens.map.MapViewModel


object Mapscreen : NavigationZiel {
    override val route = "Mapscreen"

}
@Composable
fun MapScreen(
    openAndPopUp: (String, String) -> Unit,
mapViewModel: MapViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(state = scrollState, Orientation.Vertical)) {
        //Box(modifier = Modifier)
        Map()
        Leiste()
    }}

        @Composable
        fun Map() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(vertical = 80.dp)


            ) {
                Image(
                    painterResource(id = R.drawable.gicon),
                    contentDescription = "Map-Inhalt",
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(6.dp, shape = RectangleShape, color = Color.LightGray)
                )

            }
        }

        @Composable
        fun Leiste() {

            val letterSpacing = 0.5.sp
            val lineHeight = 25.sp

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "In deiner Nähe:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 10.dp),
                )
            }
        }

        @Composable
        fun Daten(
            //name: String,
            //alter: String,
            //standort: String,
            //reiseziel: String,
            user: User,
            onClick: () -> Unit
        ) {
            val width = 60.dp
            val height = 40.dp

            if (user.name.isNotBlank() && user.alter.isNotBlank() && user.wohnort.isNotBlank() && user.reiseZiele.isNotBlank()) {
                LazyColumn(
                    modifier = Modifier
                        .clickable(onClick = onClick)
                        .fillMaxWidth()
                        //.padding(horizontal =10.dp)
                        .padding(vertical = 2.dp)
                        .padding(20.dp)
                ) {
                    item {
                        Text(
                            text = " ${user.name} ${user.alter} ${user.wohnort} ${user.reiseZiele}",
                            modifier = Modifier
                                .defaultMinSize(minWidth = (width))
                                .height(height)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                                .padding(6.dp)
                        )
                    }
                }
            }
        }


