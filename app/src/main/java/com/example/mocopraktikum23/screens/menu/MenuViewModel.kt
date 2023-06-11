package com.example.mocopraktikum23.screens.menu

import androidx.lifecycle.ViewModel
import com.example.mocopraktikum23.model.User


class MenuViewModel : ViewModel() {


}
data class MenuUiState(val itemList: List<User> = listOf())