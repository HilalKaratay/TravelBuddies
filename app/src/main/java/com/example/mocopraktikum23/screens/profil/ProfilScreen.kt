package com.example.mocopraktikum23.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mocopraktikum23.R
import com.example.mocopraktikum23.model.User
//import com.example.mocopraktikum23.screens.profil.ProfilUiState
import com.example.mocopraktikum23.screens.profil.ProfilViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun ProfilScreen(
    profilViewModel: ProfilViewModel  = hiltViewModel(),
) {
    val viewModel: ProfilViewModel
    val scrollState = rememberScrollState()

//hier die Composables die angezeigt werden in stücken
   // ProfilErstellen(image = painterResource(id = R.drawable.plus_sign))
  ProfilSection()
    ButtonLeiste(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    )
   // ReiseInformation()
   // ReiseTimeline()
    PostSection()
}


@Composable
fun  ProfilSection(modifier: Modifier= Modifier){

    Column(modifier = modifier
        .fillMaxWidth()){

        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp))
        {
            Spacer(modifier = Modifier.padding(30.dp))
            ProfilPicture(image = painterResource(id = R.drawable.profilpng), modifier = Modifier
                .size(100.dp)
                .weight(3f))
            Spacer(modifier = Modifier.width(55.dp))
           // ProfilUser(userDetailsUiState = UserDetailUiState())
        }

        
    }
}
/*
@Composable
fun ProfilErstellen (image: Painter, modifier: Modifier =Modifier){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .scrollable(state = scrollState, orientation = Orientation.Vertical)
        .fillMaxWidth()
        .padding(10.dp)) {
        Image(painter = image, contentDescription =null, modifier= modifier
            /*.border(
                width = 1.dp,
                color = Color.Black,
                shape = CircleShape
            )*/
            .size(20.dp)

            )
    }
}*/

@Composable
fun ProfilPicture( image:Painter, modifier: Modifier = Modifier){
    val scrollState= rememberScrollState()

    Image(painter =image, contentDescription = null, modifier= modifier
        .aspectRatio(1f, matchHeightConstraintsFirst = true)
        .scrollable(state = scrollState, orientation = Orientation.Vertical)
        .border(
            width = 2.dp,
            color = Color.Black,
            shape = CircleShape
        )
        .padding(3.dp)
        .clip(CircleShape))
}
/*
@Composable
private fun ProfilUser(
    userDetailsUiState: ProfilUiState,
    modifier: Modifier= Modifier)
{
    Column(modifier = modifier.padding(1.dp)) {
        
       ProfilDetails(user = userDetailsUiState.userDetails.toUser(),
       modifier =Modifier.fillMaxWidth())
    }
}
*/

@Composable
private fun ProfilDetails(
    user: User, modifier: Modifier = Modifier
){
    val letterSpacing= 0.5.sp
    val lineHeight = 20.sp
val scrollState= rememberScrollState()
    Column(modifier = Modifier
        .scrollable(state = scrollState, orientation = Orientation.Vertical)
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
    ){
        UserDetailsRow(
            userDetail = user.name,
            modifier = Modifier.padding(10.dp),
               )

        UserDetailsRow(userDetail = user.wohnort,
            modifier = Modifier.padding(10.dp))


        UserDetailsRow(userDetail = user.alter,
            modifier = Modifier.padding(10.dp),
        )


        UserDetailsRow(
            userDetail = user.geseheneOrte,
            modifier = Modifier.padding(10.dp),
        )

        UserDetailsRow(userDetail = user.reiseZiele,
            modifier = Modifier.padding(10.dp),
        )
    }
}


@Composable
private fun UserDetailsRow(
   userDetail: String, modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = userDetail,color =Color.Black,
            fontWeight = FontWeight.Bold)
    }
}


@Composable
fun ButtonLeiste(modifier: Modifier =Modifier){
    val width= 60.dp
    val height = 30.dp
    val scrollState= rememberScrollState()

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier){
        Buttons(text = "  Nachricht  ", modifier = Modifier
            .defaultMinSize(minWidth = width)
            .height(height))
        Buttons(text = "  Freundschaftsanfrage  ",modifier = Modifier
            .defaultMinSize(minWidth = width)
            .height(height))

    }
}

@Composable
fun Buttons( modifier: Modifier=Modifier,
     text: String){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(2.dp)
    ){
            Text(text = text,
                color= Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp)
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ReiseInformation( //sollte besser mit einer DataClass realsiert werden, da eventuell unterschiedliche Anzahl an reisezielen gibt
    user: User,
    /*reisezieleuberschrift: String,
   reiseziel1: String? = null,
    reiseziel2: String? = null,
    reiseziel3: String? = null,
    reiseziel4: String? = null,*/
){
    val scrollState = rememberScrollState()
    val letterSpacing= 0.5.sp
    val lineHeight = 25.sp
  //  val item = listOf<String>("Portugal","Türkei","Deutschland")

    Column(modifier = Modifier
        .fillMaxWidth()
        .scrollable(state = scrollState, orientation = Orientation.Vertical)
        .padding(horizontal = 20.dp)
    ){
        Text(text = user.reiseZiele,
            fontWeight = FontWeight.Bold,
            color =Color.Black,
            fontSize = 19.sp,
            letterSpacing = letterSpacing,
            lineHeight= lineHeight
        )

        if (user.reiseZiele != null) {
            Text(text = user.reiseZiele,
                color =Color.Black,
                letterSpacing = letterSpacing,
                lineHeight= lineHeight)
        }

        //!!!!! ACHTUNG!!!!!!
        // hier muss, falls es mehrere reiseziele sind noch ein Aufruf geschehen,
        //dass die restlichen auch angezeigt werden


    /*

        if (reiseziel2 != null) {
            Text(text = reiseziel2,
                color =Color.Black,
                letterSpacing = letterSpacing,
                lineHeight= lineHeight)
        }

        if (reiseziel3 != null) {
            Text(text = reiseziel3,
                color =Color.Black,
                letterSpacing = letterSpacing,
                lineHeight= lineHeight)
        }
        if (reiseziel4 != null) {
            Text(text = reiseziel4,
                color =Color.Black,
                letterSpacing = letterSpacing,
                lineHeight= lineHeight)
        }

 */
    }
}



@Composable
fun ReiseTimeline( //sollte besser mit einer DataClass realsiert werden, da eventuell unterschiedliche Anzahl an reisezielen gibt
  user: User
){
    val letterSpacing= 0.5.sp
    val lineHeight = 20.sp
val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .scrollable(state = scrollState, orientation = Orientation.Vertical)
        .padding(horizontal = 20.dp, vertical = 20.dp)
    ){
        Text(text = user.geseheneOrte,
            fontWeight = FontWeight.Bold,
            color =Color.Black,
            fontSize = 19.sp,
            letterSpacing = letterSpacing,
            lineHeight= lineHeight
        )
/*
        if (vergangeneReise1 != null) {
            Text(text = vergangeneReise1,
                color =Color.Black,
                letterSpacing = letterSpacing,
                lineHeight= lineHeight)
        }

        if (vergangeneReise2 != null) {
            Text(text = vergangeneReise2,
                color =Color.Black,
                letterSpacing = letterSpacing,
                lineHeight= lineHeight)
        }

        if (vergangeneReise3 != null) {
            Text(text = vergangeneReise3,

                color =Color.Black,
                letterSpacing = letterSpacing,
                lineHeight= lineHeight)
        }
        if (vergangeneReise4 != null) {
            Text(text = vergangeneReise4,
                color =Color.Black,
                letterSpacing = letterSpacing,
                lineHeight= lineHeight)
        }*/
    }
}

@Composable
fun PostSection(
    //posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val posts = listOf(
        painterResource(id = R.drawable.mailand),
        painterResource(id = R.drawable.mailand2),
        painterResource(id = R.drawable.portugal),
        painterResource(id = R.drawable.portugal2)
    )
    //modifier = Modifier.fillMaxWidth()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .scrollable(state = scrollState, orientation = Orientation.Vertical)
            .scale(1.01f),
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
