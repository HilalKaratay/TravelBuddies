package com.example.mocopraktikum23.screens.profil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mocopraktikum23.R
import com.example.mocopraktikum23.model.navigation.AppRouter
import com.example.mocopraktikum23.model.navigation.ScreensNavigations
import com.example.mocopraktikum23.screens.login.ButtonComponent
import com.example.mocopraktikum23.screens.login.MyTextFieldComponent

@Composable
fun ProfilInformationenScreen(profilInfoViewModel: ProfilInfoViewModel= viewModel()){
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
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(Color.White),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Profilinformationen bearbeiten",
                    modifier = Modifier.padding(10.dp),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize= 15.sp
                    )

                MyTextFieldComponent(
                    labelValue = "Name",
                    painterResource(id = R.drawable.message),
                    onTextChanged = {
                        profilInfoViewModel.onEvent(ProfilInfoUiEvent.NameChanged(it))
                    },
                    errorStatus = profilInfoViewModel.profilInfoUiState.value.nameError
                )
                Spacer(modifier = Modifier.height(10.dp))

                MyTextFieldComponent(
                    labelValue = "Wohnort",
                    painterResource(id = R.drawable.message),
                    onTextChanged = {
                        profilInfoViewModel.onEvent(ProfilInfoUiEvent.WohnortChanged(it))

                    },
                    errorStatus = profilInfoViewModel.profilInfoUiState.value.wohnortError

                )

                Spacer(modifier = Modifier.height(10.dp))

                MyTextFieldComponent(
                    labelValue = "Gesehene Orte",
                    painterResource(id = R.drawable.message),
                    onTextChanged = {
                        profilInfoViewModel.onEvent(ProfilInfoUiEvent.GeseheneOrteChanged(it))
                    },
                    errorStatus = profilInfoViewModel.profilInfoUiState.value.geseheneOrteError

                )

                Spacer(modifier = Modifier.height(10.dp))

                MyTextFieldComponent(
                    labelValue = "Reiseziele",
                    painterResource(id = R.drawable.message),
                    onTextChanged = {
                        profilInfoViewModel.onEvent(ProfilInfoUiEvent.ReisezieleChanged(it))
                    },
                    errorStatus = profilInfoViewModel.profilInfoUiState.value.reiseZieleError

                )
                Spacer(modifier = Modifier.height(10.dp))


                ButtonComponent(
                    value = "Speichern",
                    onButtonClicked = {
                        profilInfoViewModel.onEvent(ProfilInfoUiEvent.SpeichernButtonClicked)
                        AppRouter.navigateTo(ScreensNavigations.MenuScreen)
                    },
                    isEnabled = profilInfoViewModel.allValidationsPassed.value,
                )
            }
        }
        if(profilInfoViewModel.speichernProgress.value) {
            CircularProgressIndicator()
        }
    }
}