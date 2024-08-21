package com.example.myapplication.ui.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET

// Interface para definir a API
interface ApiService {
    @GET("app/reservatorio")
    fun getDadosReservatorio(): Call<ReservatorioDados>
}

// Classe para gerenciar a API
class ApiRepository {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.104:4000/") // Substitua pela URL base da sua API
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: ApiService = retrofit.create(ApiService::class.java)

    fun fetchReservatorioDados(callback: (ReservatorioDados?) -> Unit) {
        apiService.getDadosReservatorio().enqueue(object : Callback<ReservatorioDados> {
            override fun onResponse(call: Call<ReservatorioDados>, response: Response<ReservatorioDados>) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    callback(null) // Tratar o erro de resposta
                }
            }

            override fun onFailure(call: Call<ReservatorioDados>, t: Throwable) {
                // Tratar o erro de falha na requisição
                callback(null)
            }
        })
    }
}
