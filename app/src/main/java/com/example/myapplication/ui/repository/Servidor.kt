package com.example.myapplication.ui.repository

import android.content.Context
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// Interface para definir a API
interface ApiService {
    @GET("app/reservatorio")
    fun getDadosReservatorio(): Call<ReservatorioDados>

    @POST("app/login")
    fun login(@Body login: Login): Call<LoginResponse>
}

// Classe para gerenciar a API
class ApiRepository(private val context: Context) {

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
                    callback(null)
                }
            }

            override fun onFailure(call: Call<ReservatorioDados>, t: Throwable) {
                callback(null)
            }
        })
    }
    fun login(username: String, password: String, onSuccess: (LoginResponse) -> Unit, onFailure: (Throwable) -> Unit) {
        val login = Login(username, password)
        apiService.login(login).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val loginResponse = response.body()
                if (loginResponse != null) {
                    if (loginResponse.resultado == "Login bem-sucedido") {
                        onSuccess(loginResponse)
                    } else {
                        Toast.makeText(context, "Credenciais inválidas", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(context, "Resposta do servidor vazia", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(context, "Falha na requisição: ${t.message}", Toast.LENGTH_LONG).show()
                onFailure(t)
            }
        })
    }
}
