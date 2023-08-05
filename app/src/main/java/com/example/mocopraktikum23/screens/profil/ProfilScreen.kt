package com.example.mocopraktikum23.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mocopraktikum23.NavigationZiel
import com.example.mocopraktikum23.R
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mocopraktikum23.screens.profil.ProfilViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi


object ProfilScreen : NavigationZiel {
    override val route = "ProfilScreen"

}
@OptIn(ExperimentalFoundationApi::class)
@ExperimentalCoroutinesApi
@Composable
fun ProfilScreen(
    openAndPopUp: (String, String) -> Unit,
    viewModel: ProfilViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) { Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
                        name = "TravelBuddies Profil",
                        modifier = Modifier
                            .padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
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
        modifier = Modifier.fillMaxWidth())}
}

    @Composable
    fun TopBar(
        name: String,
        modifier: Modifier = Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = name,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }

    @Composable
    fun ProfileSection(
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier.fillMaxWidth()) {
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
            ProfileDescription(
                displayName = "Benutzer Name",
                geseheneOrte = "Trabzon, Köln, Rom",
                reiseZiele = "Prag, Moskau"
            )
        }
    }

    @Composable
    fun RoundImage(
        image: Painter,
        modifier: Modifier = Modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape)
        )
    }

    @Composable
    fun ProfileStat(
        numberText: String,
        text: String,
        modifier: Modifier = Modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Text(
                text = numberText,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = text)
        }
    }

    @Composable
    fun ProfileDescription(
        displayName: String,
        geseheneOrte: String,
        reiseZiele: String,
    ) {
        val letterSpacing = 0.5.sp
        val lineHeight = 20.sp
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = displayName,
                fontWeight = FontWeight.Bold,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
            Text(
                text = geseheneOrte,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
            Text(
                text = reiseZiele,
                color = Color(0xFF3D3D91),
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }

    @Composable
    fun ButtonSection(
        modifier: Modifier = Modifier
    ) {
        val minWidth = 95.dp
        val height = 30.dp
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
        ) {
            ActionButton(
                text = "Freundschaftsanfrage",
                icon = Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height)
            )
            ActionButton(
                text = "Nachricht",
                modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height)
            )
        }
    }

    @Composable
    fun ActionButton(
        modifier: Modifier = Modifier,
        text: String? = null,
        icon: ImageVector? = null
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(6.dp)
        ) {
            if(text != null) {
                Text(
                    text = text,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }
            if(icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }

    @Composable
    fun HighlightSection(
        modifier: Modifier = Modifier,
        highlights: List<ImageWithText>
    ) {
        LazyRow(modifier = modifier) {
            items(highlights.size) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(end = 15.dp)
                ) {
                    RoundImage(
                        image = highlights[it].image,
                        modifier = Modifier.size(70.dp)
                    )
                    Text(
                        text = highlights[it].text,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

    @Composable
    fun PostTabView(
        modifier: Modifier = Modifier,
        imageWithTexts: List<ImageWithText>,
        onTabSelected: (selectedIndex: Int) -> Unit
    ) {
        var selectedTabIndex by remember {
            mutableStateOf(0)
        }
        val inactiveColor = Color(0xFF777777)
        TabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color.Transparent,
            contentColor = Color.Black,
            modifier = modifier
        ) {
            imageWithTexts.forEachIndexed { index, item ->
                Tab(
                    selected = selectedTabIndex == index,
                    selectedContentColor = Color.Black,
                    unselectedContentColor = inactiveColor,
                    onClick = {
                        selectedTabIndex = index
                        onTabSelected(index)
                    }
                ) {
                    Icon(
                        painter = item.image,
                        contentDescription = item.text,
                        tint = if(selectedTabIndex == index) Color.Black else inactiveColor,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(20.dp)
                    )
                }
            }
        }
    }

    @ExperimentalFoundationApi
    @Composable
    fun PostSection(
        posts: List<Painter>,
        modifier: Modifier = Modifier
    ) {
        LazyVerticalGrid(
            GridCells.Fixed(3),
            modifier = modifier
                .scale(1.01f)
        ) {
            items(posts.size) {
                Image(
                    painter = posts[it],
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .border(
                            width = 1.dp,
                            color = Color.White
                        )
                )
            }
        }
    }

data class ImageWithText(
    val image: Painter,
    val text: String
)