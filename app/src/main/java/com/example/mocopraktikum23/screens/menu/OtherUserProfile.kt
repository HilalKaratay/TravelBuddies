package com.example.mocopraktikum23.screens.menu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mocopraktikum23.R
import com.example.mocopraktikum23.screens.ActionButton
import com.example.mocopraktikum23.screens.PostSection
import com.example.mocopraktikum23.screens.RoundImage
import com.example.mocopraktikum23.screens.TopBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OtherUserProfile() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            name = "Profil von",
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                RoundImage(
                    image = painterResource(id = R.drawable.profilpng),
                    modifier = Modifier
                        .size(100.dp)
                        .weight(3f)
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text("name}")
            Text("")
            Text("")
            Text("")

        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(6.dp)
        ) {
            ActionButton(
                text = "Freundschaftsanfrage",
                icon = Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                    .defaultMinSize(minWidth = 95.dp)
                    .height(30.dp),
            )
            ActionButton(
                text = "Nachricht",
                modifier = Modifier
                    .defaultMinSize(minWidth = 95.dp)
                    .height(30.dp),
            )
        }


        Spacer(modifier = Modifier.height(25.dp))

        PostSection(
            posts = listOf(
                painterResource(id = R.drawable.mailand),
                painterResource(id = R.drawable.mailand2),
                painterResource(id = R.drawable.portugal),
                painterResource(id = R.drawable.portugal2),
                painterResource(id = R.drawable.mailand),
                painterResource(id = R.drawable.mailand2),
                painterResource(id = R.drawable.portugal),
                painterResource(id = R.drawable.portugal2),
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}