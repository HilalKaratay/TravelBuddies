package com.example.mocopraktikum23.screens.registrieren

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mocopraktikum23.R.*
import com.example.mocopraktikum23.model.navigation.PostOfficeAppRouter
import com.example.mocopraktikum23.model.navigation.ScreensNavigations
import com.example.mocopraktikum23.screens.login.ButtonComponent
import com.example.mocopraktikum23.screens.login.ClickableLoginTextComponent
import com.example.mocopraktikum23.screens.login.HeadingTextComponent
import com.example.mocopraktikum23.screens.login.MyTextFieldComponent
import com.example.mocopraktikum23.screens.login.NormalTextComponent
import com.example.mocopraktikum23.screens.login.PasswordTextFieldComponent
import com.example.mocopraktikum23.screens.registrieren.RegistrierenUiEvent.RegisterButtonClicked

@Composable
fun RegistrierenScreen(registrierenViewModel: RegistrierenViewModel = viewModel()) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                HeadingTextComponent(value = "Herzlich Willkommen")
                Spacer(modifier = Modifier.height(20.dp))

                MyTextFieldComponent(
                    labelValue = "Name",
                    painterResource = painterResource(id = drawable.message),
                    onTextChanged = {
                        registrierenViewModel.onEvent(RegistrierenUiEvent.FirstNameChanged(it))
                    },
                    errorStatus = registrierenViewModel.RegistrierenUiState.value.vornameError
                )


                MyTextFieldComponent(
                    labelValue = "Email",
                    painterResource = painterResource(id = drawable.message),
                    onTextChanged = {
                        registrierenViewModel.onEvent(RegistrierenUiEvent.EmailChanged(it))
                    },
                    errorStatus = registrierenViewModel.RegistrierenUiState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = "Passwort",
                    painterResource = painterResource(id = drawable.ic_lock),
                    onTextSelected = {
                        registrierenViewModel.onEvent(RegistrierenUiEvent.PasswortChanged(it))
                    },
                    errorStatus = registrierenViewModel.RegistrierenUiState.value.passwortError
                )

                /*
                MyTextFieldComponent(
                    labelValue ="ReiseZiele",
                    painterResource = painterResource(id = drawable.map_icon),
                    onTextChanged = { registrierenViewModel.onEvent(RegistrierenUiEvent.ReiseZieleChanged(it))
                    },
                    errorStatus = registrierenViewModel.RegistrierenUiState.value.reiseZieleError
                )
                MyTextFieldComponent(
                    labelValue ="GeseheneOrte",
                    painterResource = painterResource(id = drawable.map_icon),
                    onTextChanged = { registrierenViewModel.onEvent(RegistrierenUiEvent.GeseheneOrteChanged(it))
                    },
                    errorStatus = registrierenViewModel.RegistrierenUiState.value.geseheneOrteError
                )*/


                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(
                    value = "Registrieren",
                    onButtonClicked = {
                        registrierenViewModel.onEvent(RegisterButtonClicked)
                        PostOfficeAppRouter.navigateTo(ScreensNavigations.ProfilInformationenScreen)
                    },
                    //onRegistrierenButtonClicked()},
                    isEnabled = registrierenViewModel.allValidationsPassed.value,


                )

                Spacer(modifier = Modifier.height(20.dp))

                ClickableLoginTextComponent(
                    onTextSelected = {
                        PostOfficeAppRouter.navigateTo(ScreensNavigations.LoginScreen)
                    }
                )
                //onEinloggenButtonClicked()
            }
        }

        if(registrierenViewModel.signUpInProgress.value) {
            CircularProgressIndicator()
        }
    }

}
