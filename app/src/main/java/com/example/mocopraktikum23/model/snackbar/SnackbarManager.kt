package com.example.mocopraktikum23.model.snackbar


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object SnackbarManager {
  private val messages: MutableStateFlow<SnackbarMessage?> = MutableStateFlow(null)
  val snackbarMessages: StateFlow<SnackbarMessage?>
    get() = messages.asStateFlow()

  fun showMessage(message: String) {
    messages.value = SnackbarMessage.ResourceSnackbar(message)
  }

  fun showMessage(message: SnackbarMessage) {
    messages.value = message
  }
}
