package com.example.mocopraktikum23

import android.app.LauncherActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ListItem
import androidx.compose.ui.graphics.RectangleShape


@Composable
fun MapScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize()
            .scrollable(state = scrollState, Orientation.Vertical)){
        //Box(modifier = Modifier)
        Map()
        Leiste()
        Daten(
            name = "  Lisa,",
            alter = "25",
            standort = "Gummersbach",
            reiseziel = "Mallorca",
            onClick = { "clicked" })
        Daten(
            name = "  Mara,",
            alter = "21",
            standort = "Windhagen",
            reiseziel = "     Madrid",
            onClick = { "clicked" })
        Daten(
            name = "  Antonio,",
            alter = "28",
            standort = "Siegen",
            reiseziel = "        London",
            onClick = { "clicked" })
        Daten(
            name = "  Sarah,",
            alter = "25",
            standort = "Overath",
            reiseziel = "          Istanbul",
            onClick = { "clicked" })
        Daten(
            name = "  Sarah,",
            alter = "25",
            standort = "Overath",
            reiseziel = "          Istanbul",
            onClick = { "clicked" })
        Daten(
                name = "  Sarah,",
        alter = "25",
        standort = "Overath",
        reiseziel = "          Istanbul",
        onClick = { "clicked" })

        Daten(
        name = "  Sarah,",
        alter = "25",
        standort = "Overath",
        reiseziel = "          Istanbul",
        onClick = { "clicked" })
    }
}

@Composable
fun Map(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(vertical = 80.dp)

           /* .fillMaxWidth()
            .fillMaxHeight()
            .padding(vertical = 320.dp)
            .padding(horizontal = 40.dp)
            .padding(top = 1.dp)
            .border(width = 5.dp, color = Color.LightGray)
            .padding(20.dp),*/
       // contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(id = R.drawable.gicon),
            contentDescription = "Map-Inhalt",
            modifier = Modifier.fillMaxWidth()
                .border(6.dp, shape = RectangleShape, color = Color.LightGray)
        )
        //Text(text = "Map-Inhalt")
    }
}

@Composable
fun Leiste(){

    val letterSpacing= 0.5.sp
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
    name: String,
    alter: String,
    standort: String,
    reiseziel: String,
    onClick: () -> Unit
){
    val width= 60.dp
    val height = 40.dp

    if (name.isNotBlank() && alter.isNotBlank() && standort.isNotBlank() && reiseziel.isNotBlank())
    {
    LazyColumn(modifier = Modifier
        .clickable(onClick = onClick)
        .fillMaxWidth()
        //.padding(horizontal =10.dp)
        .padding(vertical = 2.dp)
        .padding(20.dp)
    ){
        item {
            Text(
                text = " $name $alter $standort               $reiseziel  ",
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
@Preview(showBackground = true)
@Composable
fun MapScreenPreview(){
    MapScreen()
    //Leiste(heading = "")
    //Daten(name = "", alter = "", standort = "", reiseziel = "", onClick = {""})

}
