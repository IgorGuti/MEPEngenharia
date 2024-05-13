package com.example.myapplication.ui.repository

// Importações necessárias para usar o Retrofit e Gson
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

// Classe responsável por criar uma instância do Retrofit e fornecer o serviço da API
class ApiClient() {
    // Instância do Retrofit configurada com a URL base e um conversor Gson
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.101:3324/users/") // Define a URL base da API
        .addConverterFactory(ScalarsConverterFactory.create()) // Adiciona o conversor Scalars para lidar com texto bruto
        .build()

    // Serviço da API criado a partir da interface ApiService
    val service = retrofit.create(ApiService::class.java)
}
