package com.example.mocopraktikum23

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.weltpng, "Menü")
    object Profile : NavigationItem("profile", R.drawable.profilpng, "Profil")
    object Map : NavigationItem("profile", R.drawable.map_icon, "Map")
}
