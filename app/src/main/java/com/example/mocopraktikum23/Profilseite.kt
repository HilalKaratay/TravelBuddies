package com.example.mocopraktikum23

import android.R.attr.fontFamily
import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontSynthesis.Companion.Style
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mocopraktikum23.ui.theme.MocoPraktikum23Theme


class Profilseite : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MocoPraktikum23Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                }
            }
        }
    }
}


@Composable
fun TravelBuddiesLeiste(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ){
        Text(text = "TravelBuddies",
            fontSize = 38.sp,
            modifier = Modifier
                .padding(
                    top = 16.dp, end = 115.dp,
                )
                .wrapContentSize(Alignment.Center),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Cursive,
            //color= Color.LightGray farbe für die schrift

        )

        Text(
            text = "Profil",
            fontSize = 29.sp,
            modifier = Modifier
                .padding(
                    end = 110.dp,
                ),
            style = MaterialTheme.typography.titleLarge,
            //fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Light,
            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
        )

        OutlinedButton(onClick = { /*TODO*/ }) {
           //modifier = Modifier.padding(bottom = 150.dp, end = 30.dp)
                Text(text = "Speichern",
                    color = Color.Black)


        }

    }
    //Box(modifier = )
}



@Composable
fun PersonenDaten(name: String,modifier: Modifier){

    Button(onClick = { /*TODO*/ }) {
        Text(text = "Speichern",

        modifier= Modifier,)

    }

}

fun BottomLeiste(name: String, modifier: Modifier){

}


@Preview(showBackground = true)
@Composable
fun TravelBuddiesLeistePreview() {
    MocoPraktikum23Theme {
        TravelBuddiesLeiste("Travel")
    //    BottomLeiste("Leiste")
    }
}