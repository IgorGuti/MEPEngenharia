package com.example.myapplication.ui.repository

import retrofit2.Call
import retrofit2.http.GET

// Interface que define os endpoints da API
interface ApiService {
    @GET("/users/anchieta/agua/teste")
    fun getAguaTeste(): Call<List<String>>
}
interface OnDataReceivedListener {
    fun onDataReceived(data: List<String>)
}
