package com.example.myapplication.ui.repository

import retrofit2.Call
import retrofit2.http.GET

// Interface que define os endpoints da API
interface ApiService {
    @GET("app")  // Anotação indicando que este método faz uma requisição HTTP GET para o endpoint "posts"
    fun getOlaMundo(): Call<String>  // Método que retorna uma string encapsulada em um objeto Call
}
