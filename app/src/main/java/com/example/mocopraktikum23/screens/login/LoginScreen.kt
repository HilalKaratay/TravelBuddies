package com.example.mocopraktikum23.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.merveversuch10000.ui.theme.BasicButton
import com.example.merveversuch10000.ui.theme.EmailField
import com.example.merveversuch10000.ui.theme.PasswordField


const val LoginScreen = "LoginScreen"

@Composable
fun LoginScreen(
  state: MutableState<LoginUiState>,
  onEmailChange: (LoginEvent) -> Unit,
  onPasswordChange: (LoginEvent) -> Unit,
  onSignInClick: (LoginEvent) -> Unit
) {

  BasicToolbar("Einloggen")

  Column(
    modifier = Modifier.fillMaxWidth().fillMaxHeight().verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {

    EmailField(state.value.email, onEmailChange, Modifier.fillMaxWidth() .padding(16.dp, 4.dp))

    PasswordField(state.value.password, onPasswordChange, Modifier.fillMaxWidth()
      .padding(16.dp, 4.dp))

    BasicButton("Einloggen", Modifier.fillMaxWidth()){}
     // .padding(16.dp, 8.dp)) { onSignInClick(openAndPopUp()) }

  }
}

@Composable
fun BasicToolbar(title :String) {
  TopAppBar(title = { Text(" ") }, backgroundColor = Color.White)
}

