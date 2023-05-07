package com.example.mocopraktikum23

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mocopraktikum23.ui.theme.White
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.draw.clip
import org.w3c.dom.Text
import androidx.compose.foundation.clickable


@Composable
fun MapScreen(){
    Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
    ) {
        //Box(modifier = Modifier)
        //Map()
        Leiste(heading = "In deiner Nähe:")
        Daten(name = "  Lisa,", alter = "25", standort = "Gummersbach", reiseziel = "Mallorca", onClick = {"clicked"})
        Daten(name = "  Mara,", alter = "21", standort = "Windhagen", reiseziel = "     Madrid", onClick = {"clicked"})
        Daten(name = "  Antonio,", alter = "28", standort = "Siegen", reiseziel = "        London", onClick = {"clicked"})
        Daten(name = "  Sarah,", alter = "25", standort = "Overath", reiseziel = "          Istanbul", onClick = {"clicked"})
    }
}
@Composable
fun Map(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(vertical = 320.dp)
            .padding(horizontal = 40.dp)
            .padding(top = 1.dp)
            .border(width = 5.dp, color = Color.LightGray)
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(id = R.drawable.gicon),
            contentDescription = "Map-Inhalt",
            modifier = Modifier.fillMaxSize()
        )
        //Text(text = "Map-Inhalt")
    }
}
@Composable
fun Leiste(heading:String){

    val letterSpacing= 0.5.sp
    val lineHeight = 25.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = heading,
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
    val letterSpacing= 0.5.sp
    val lineHeight = 20.sp

    if (name.isNotBlank() && alter.isNotBlank() && standort.isNotBlank() && reiseziel.isNotBlank())
    {
    Column(modifier = Modifier
        .clickable(onClick = onClick)
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
        .padding(vertical = 1.dp)
        .padding(20.dp)
        .clip(CircleShape)
        .background(Color.LightGray),
    ){
        Text(text =  "$name $alter $standort               $reiseziel")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MapScreenPreview(){
    MapScreen()
    //Leiste(heading = "")
    //Daten(name = "", alter = "", standort = "", reiseziel = "", onClick = {""})
    Map()
}
