package com.example.myapplication.ui.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Classe responsável por criar uma instância do Retrofit e fornecer o serviço da API
class ApiClient {
    // Instância do Retrofit configurada com a URL base e um conversor Gson
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.19:5000/") // Define a URL base da API
        .addConverterFactory(GsonConverterFactory.create()) // Adiciona o conversor Gson para lidar com objetos serializados
        .build()

    // Serviço da API criado a partir da interface ApiService
    val service: ApiService = retrofit.create(ApiService::class.java)
}
