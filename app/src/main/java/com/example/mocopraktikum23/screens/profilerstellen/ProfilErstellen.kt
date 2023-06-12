package com.example.merveversuch10000.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mocopraktikum23.AppViewModelProvider
import com.example.mocopraktikum23.MainActivity
import com.example.mocopraktikum23.NavigationZiel
import com.example.mocopraktikum23.model.AppContainer
import com.example.mocopraktikum23.screens.profilerstellen.ProfilErstellenViewModel
import com.example.mocopraktikum23.screens.profilerstellen.UserDetails
import com.example.mocopraktikum23.screens.profilerstellen.UserUiState
import kotlinx.coroutines.launch
import java.util.Currency
import java.util.Locale


object ProfilErstellen : NavigationZiel {
    override val route = "ProfilErstellen"
}

@Composable
fun ProfilErstellen(
    viewModel: ProfilErstellenViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold() { innerPadding ->
        ProfilerstellenGeruest(
            userUiState = viewModel.userUiState,
            onItemValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.saveUser()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}


    @Composable
    fun ProfilerstellenGeruest(
        userUiState: UserUiState,
        onItemValueChange: (UserDetails) -> Unit,
        onSaveClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Eingabefelder(
                userDetails = userUiState.userDetails,
                onValueChange = onItemValueChange,
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = onSaveClick,
                enabled = userUiState.isEntryValid,
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Speichern")
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Eingabefelder(
        userDetails: UserDetails,
        modifier: Modifier = Modifier,
        onValueChange: (UserDetails) -> Unit = {},
        enabled: Boolean = true
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = userDetails.benutzername,
                onValueChange = { onValueChange(userDetails.copy(benutzername = it)) },
                label = { Text("Username") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = userDetails.alter.toString(),
                onValueChange = { onValueChange(userDetails.copy(alter= it)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                label = { Text("Dein Alter") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                leadingIcon = { Text(Currency.getInstance(Locale.getDefault()).symbol) },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = userDetails.wohnort,
                onValueChange = { onValueChange(userDetails.copy(wohnort = it)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                label = { Text("Dein Wohnort") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                leadingIcon = { Text(Currency.getInstance(Locale.getDefault()).symbol) },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = userDetails.reiseZiele,
                onValueChange = { onValueChange(userDetails.copy(reiseZiele = it)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Deine zukünftigen Reiseziele") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = userDetails.geseheneOrte,
                onValueChange = { onValueChange(userDetails.copy(geseheneOrte = it)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Deine Entdeckten Reiseorte") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )

            if (enabled) {
                Text(
                    text = "required_fields",
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }



/*
{
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


@Preview
@Composable
fun ProfilErstellenPreview(){
ProfilErstellen()
}

 */