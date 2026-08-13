package com.example.ecoeyeapp.navigation

sealed class Schermate(val route: String){
    /**
     * Schermata iniziale
     */
    object ServerScreen: Schermate("server_screen")
}