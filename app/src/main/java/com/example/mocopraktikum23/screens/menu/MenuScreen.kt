package com.example.mocopraktikum23.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.UserDataProvider
import com.example.mocopraktikum23.model.navigation.AppRouter
import com.example.mocopraktikum23.model.navigation.ScreensNavigations

@Composable
fun MenuScreen() {
    val users = remember { UserDataProvider.userList }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = users,
                itemContent = {
                    UsersListItem(user = it)
                }
            )
        }
}


@Composable
fun UsersListItem(user: User){
    Row {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ) {
            Row (Modifier.clickable {AppRouter.navigateTo(ScreensNavigations.OtherUserProfile)}){
                UserImage(user)
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ) {
                    Text(text = user.name, style = typography.h5)
                    Text(text = user.wohnort, style = typography.caption)
                    Text(text ="gesehene Orte  "+ user.geseheneOrte, style = typography.caption)
                    Text(text ="Reiseziele  " +user.reiseZiele, style = typography.caption)
                }
            }
        }
    }
}

@Composable
private fun UserImage(user: User) {
    Image(
        painter = painterResource(id = user.userImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}
