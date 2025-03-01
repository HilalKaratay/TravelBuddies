package com.example.mocopraktikum23.screens.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mocopraktikum23.R
import com.example.mocopraktikum23.model.navigation.AppRouter
import com.example.mocopraktikum23.model.navigation.ScreensNavigations

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {

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
          .fillMaxSize()
      ) {

        HeadingTextComponent(value = "Herzlich Willkommen")
        Spacer(modifier = Modifier.height(30.dp))

        MyTextFieldComponent(
          labelValue = "Email",
          painterResource(id = R.drawable.message),
          onTextChanged = {
            loginViewModel.onEvent(LoginUiEvent.EmailChanged(it))
          },
          errorStatus = loginViewModel.loginUIState.value.emailError
        )

        PasswordTextFieldComponent(
          labelValue = "Passwort",
          painterResource(id = R.drawable.lock),
          onTextSelected = {
            loginViewModel.onEvent(LoginUiEvent.PasswordChanged(it))
          },
          errorStatus = loginViewModel.loginUIState.value.passwordError
        )

        Spacer(modifier = Modifier.height(10.dp))
        UnderLinedTextComponent(value = "Passwort vergessen?")

        Spacer(modifier = Modifier.height(15.dp))

        ButtonComponent(
          value = "Einloggen",
          onButtonClicked = {
            loginViewModel.onEvent(LoginUiEvent.LoginButtonClicked)
            AppRouter.navigateTo(ScreensNavigations.MenuScreen)
          },
          isEnabled = loginViewModel.allValidationsPassed.value
        )

        Spacer(modifier = Modifier.height(15.dp))


        ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
          AppRouter.navigateTo(ScreensNavigations.RegistrierenScreen)
        })
      }
    }

    if (loginViewModel.loginInProgress.value) {
      CircularProgressIndicator()
    }
  }
}



  @Composable
  fun HeadingTextComponent(value: String) {
    Text(
      text = value,
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(),
      style = TextStyle(
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal
      ), color = Color.Black,
      textAlign = TextAlign.Center
    )
  }

  @Composable
  fun MyTextFieldComponent(
    labelValue: String, painterResource: Painter,
    onTextChanged: (String) -> Unit,
    errorStatus: Boolean = false
  ) {

    val textValue = remember {
      mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
      modifier = Modifier
        .fillMaxWidth(),
      label = { Text(text = labelValue) },
      colors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.White,
        focusedLabelColor = Color.White,
        cursorColor = Color.Gray,
        backgroundColor = Color.White
      ),
      keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
      singleLine = true,
      maxLines = 1,
      value = textValue.value,
      onValueChange = {
        textValue.value = it
        onTextChanged(it)
      },
      leadingIcon = {
        Icon(painter = painterResource, contentDescription = "")
      },
      isError = !errorStatus
    )
  }

  @Composable
  fun PasswordTextFieldComponent(
    labelValue: String, painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false
  ) {

    val localFocusManager = LocalFocusManager.current
    val password = remember {
      mutableStateOf("")
    }

    val passwordVisible = remember {
      mutableStateOf(false)
    }

    OutlinedTextField(
      modifier = Modifier
        .fillMaxWidth(),
      label = { Text(text = labelValue) },
      colors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.White,
        focusedLabelColor = Color.White,
        cursorColor = Color.Gray,
        backgroundColor = Color.White
      ),
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Done
      ),
      singleLine = true,
      keyboardActions = KeyboardActions {
        localFocusManager.clearFocus()
      },
      maxLines = 1,
      value = password.value,
      onValueChange = {
        password.value = it
        onTextSelected(it)
      },
      leadingIcon = {
        Icon(painter = painterResource, contentDescription = "")
      },
      trailingIcon = {

        val iconImage = if (passwordVisible.value) {
          Icons.Filled.Visibility
        } else {
          Icons.Filled.VisibilityOff
        }

        IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
          Icon(imageVector = iconImage, contentDescription ="Verbergen")
        }

      },
      visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
      isError = !errorStatus
    )
  }

  @Composable
  fun CheckboxComponent(
    value: String,
    onTextSelected: (String) -> Unit,
    onCheckedChange: (Boolean) -> Unit
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {

      val checkedState = remember {
        mutableStateOf(false)
      }

      Checkbox(checked = checkedState.value,
        onCheckedChange = {
          checkedState.value = !checkedState.value
          onCheckedChange.invoke(it)
        })

      ClickableTextComponent(value = value, onTextSelected)
    }
  }


  @Composable
  fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditionsText = "Term of Use"

    val annotatedString = buildAnnotatedString {
      append(initialText)
      withStyle(style = SpanStyle(color = Color.White)) {
        pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
        append(privacyPolicyText)
      }
      append(andText)
      withStyle(style = SpanStyle(color = Color.White)) {
        pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
        append(termsAndConditionsText)
      }
    }

    ClickableText(text = annotatedString, onClick = { offset ->

      annotatedString.getStringAnnotations(offset, offset)
        .firstOrNull()?.also { span ->
          Log.d("ClickableTextComponent", "{${span.item}}")

          if ((span.item == termsAndConditionsText) || (span.item == privacyPolicyText)) {
            onTextSelected(span.item)
          }
        }

    })
  }
  @Composable
  fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = false) {
    Button(
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(48.dp),
      onClick = {
        onButtonClicked.invoke()
      },
      contentPadding = PaddingValues(),
      colors = ButtonDefaults.buttonColors(Color.Transparent),
      shape = RoundedCornerShape(50.dp),
      enabled = isEnabled
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .heightIn(48.dp)
          .background(
            brush = Brush.horizontalGradient(listOf(Color.Gray, Color.White)),
            shape = RoundedCornerShape(50.dp)
          ),
        contentAlignment = Alignment.Center
      ) {
        Text(
          text = value,
          fontSize = 18.sp,
          color = Color.White,
          fontWeight = FontWeight.Bold
        )

      }

    }
  }

  @Composable
  fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val loginText = if (tryingToLogin) "Du hast bereits ein Konto? Einloggen" else "Hier klicken zum Registrieren"
    val annotatedString = buildAnnotatedString {
      withStyle(style = SpanStyle(color = Color.Black)) {
        pushStringAnnotation(tag = loginText, annotation = loginText)
        append(loginText)
      }
    }

    ClickableText(
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
      style = TextStyle(
        fontSize = 17.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Center
      ),
      text = annotatedString,
      onClick = { offset ->

        annotatedString.getStringAnnotations(offset, offset)
          .firstOrNull()?.also { span ->
            Log.d("ClickableTextComponent", "{${span.item}}")

            if (span.item == loginText) {
              onTextSelected(span.item)
            }
          }

      },
    )
  }

  @Composable
  fun UnderLinedTextComponent(value: String) {
    Text(
      text = value,
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
      style = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
      ), color = Color.Gray,
      textAlign = TextAlign.Center,
      textDecoration = TextDecoration.Underline
    )
  }