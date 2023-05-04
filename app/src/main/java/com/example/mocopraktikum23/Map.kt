package com.example.mocopraktikum23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mocopraktikum23.ui.theme.MocoPraktikum23Theme

class Map : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                MocoPraktikum23Theme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {

                    }
                }
            }
        }
}

@Composable
fun TravelBuddiesMapLeiste(name: String, modifier: Modifier = Modifier) {
    Column(

        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = "TravelBuddies",
            fontSize = 33.sp,
            modifier = Modifier
                .padding(
                    top = 16.dp, end = 115.dp,
                )
        )

        Text(
            text = "Map",
            fontSize = 29.sp,
            modifier = Modifier
                .padding(
                    end = 110.dp
                )
        )

        Row(modifier = Modifier.padding(top = 1.dp, end = 75.dp))
        {
            Image(
                painter = painterResource(id = R.drawable.map_icon),
                contentDescription = "Map Icon",

                modifier = Modifier
                    .size(40.dp)
            )

        }
    }
}
@Preview(showBackground = true)
@Composable
fun TravelBuddiesMapLeistePreview() {
    MocoPraktikum23Theme {
        TravelBuddiesMapLeiste("Travel")
    }
}
/*
@Composable
fun TravelBuddiesMapFeld( modifier: Modifier = Modifier){
    Column(

        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = "teeeest",
            fontSize = 33.sp,
            modifier = Modifier
                .padding(
                    top = 16.dp, end = 115.dp,
                )
        )
}

@Preview(showBackground = true)
@Composable
fun TravelBuddiesMapFeldPreview(){
    MocoPraktikum23Theme {
        TravelBuddiesMapFeld()
    }
}
*/