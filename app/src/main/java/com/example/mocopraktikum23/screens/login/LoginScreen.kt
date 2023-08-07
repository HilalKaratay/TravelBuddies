package com.example.mocopraktikum23.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.merveversuch10000.ui.theme.BasicButton
import com.example.merveversuch10000.ui.theme.EmailField
import com.example.merveversuch10000.ui.theme.PasswordField
import com.example.mocopraktikum23.LOGIN_SCREEN
import com.example.mocopraktikum23.MENU_SCREEN


const val LoginScreen = "LoginScreen"

@Composable
fun LoginScreen(
  openAndPopUp: (String, String) -> Unit,
  viewModel: LoginViewModel = hiltViewModel()
) {
  val uiState by viewModel.uiState

  BasicToolbar("Einloggen")

  Column(
    modifier = Modifier.fillMaxWidth().fillMaxHeight().verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {

    EmailField(uiState.email, viewModel::onEmailChange, Modifier.fillMaxWidth() .padding(16.dp, 4.dp))

    PasswordField(uiState.password, viewModel::onPasswordChange, Modifier.fillMaxWidth()
      .padding(16.dp, 4.dp))

    BasicButton("Einloggen", Modifier.fillMaxWidth()
      .padding(16.dp, 8.dp)) { viewModel.onSignInClick(openAndPopUp) }

  }
}

@Composable
fun BasicToolbar(title :String) {
  TopAppBar(title = { Text(" ") }, backgroundColor = Color.White)
}

