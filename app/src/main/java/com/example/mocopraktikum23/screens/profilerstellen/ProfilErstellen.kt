package com.example.merveversuch10000.ui.theme

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mocopraktikum23.R
import com.example.mocopraktikum23.screens.profilerstellen.ProfilErstellenViewModel

@Composable
fun ProfilErstellen(
    profilErstellenViewModel: ProfilErstellenViewModel
){
    setImage()
    setTextfields()
}
@Composable
fun setImage(bittmap: ImageBitmap? = null){
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }
    val bitmap =  remember {
        mutableStateOf<Bitmap?>(null)
    }
    val context = LocalContext.current
    var lol:Unit
    Box(modifier = Modifier.padding(140.dp,120.dp)) {
        if(bittmap != null) {
            lol = Image(bitmap = bittmap,
                contentDescription = null,
                modifier = Modifier
                    .clickable { launcher.launch("image/*") }
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = CircleShape
                    )
                    .clip(CircleShape))
        }else{
            Image(painter = painterResource(id = R.drawable.profilpng),
                contentDescription = null,
                modifier = Modifier
                    .clickable { launcher.launch("image/*") }
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = CircleShape
                    )
                     .clip(CircleShape))
        }

    }
    Spacer(modifier = Modifier.height(12.dp))
    imageUri?.let {
        if (Build.VERSION.SDK_INT < 28) {
            bitmap.value = MediaStore.Images
                .Media.getBitmap(context.contentResolver,it)

        } else {
            val source = ImageDecoder
                .createSource(context.contentResolver,it)
            bitmap.value = ImageDecoder.decodeBitmap(source)
        }

        bitmap.value?.let {  btm ->
            setImage(btm.asImageBitmap())
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun setTextfields(){
    val context = LocalContext.current
    Column() {
        var username by rememberSaveable {
            mutableStateOf("")
        }
        var age by rememberSaveable {
            mutableStateOf("")
        }
        var wohnort by rememberSaveable {
        mutableStateOf("")
    }
        var reiseziel by rememberSaveable {
            mutableStateOf("")
        }
        var gesehneOrte by rememberSaveable {
            mutableStateOf("")
        }
        val kbdController = LocalSoftwareKeyboardController.current


        TextField(
            value = username,
            onValueChange ={username = it},
            label = { Text(text = "Name")},
            modifier = Modifier.padding(50.dp,250.dp,0.dp,10.dp)
        )
        TextField(
            value = age,
            onValueChange ={age = it},
            label = { Text(text = "Alter")},
            modifier = Modifier.padding(50.dp,0.dp,0.dp,10.dp)
        )
        TextField(
            value = wohnort,
            onValueChange ={wohnort = it},
            label = { Text(text = "Wohnort")},
            modifier = Modifier.padding(50.dp,0.dp,0.dp,10.dp)
        )
        TextField(
            value = reiseziel,
            onValueChange ={reiseziel = it},
            label = { Text(text = "Reiseziele")},
            modifier = Modifier.padding(50.dp,0.dp,0.dp,10.dp)
        )
        TextField(
            value = gesehneOrte,
            onValueChange ={gesehneOrte = it},
            label = { Text(text = "Gesehene Orte")},
            modifier = Modifier.padding(50.dp,0.dp,0.dp,10.dp)
        )
        Button(
            onClick = { Toast.makeText(context,"gespeichert",Toast.LENGTH_SHORT).show()},
            modifier = Modifier.padding(250.dp,50.dp,0.dp,0.dp)

            ) {
            Text(text = "Speichern")  //Neue Instanz öffnen!!
        }
    }
}

/*
@Preview
@Composable
fun ProfilErstellenPreview(){
    ProfilErstellen()
}*/