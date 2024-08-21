package com.example.myapplication.ui.repository

data class LoginResponse(
    val resultado: String,
    val url: String,
    val qntReservatorio: Int,
    val qntMedidor: Int,
    val qntHidromentro: Int
)
