package com.example.myapplication.ui.repository

import android.content.Context
import android.widget.Toast
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

// Classe responsável por acessar os dados da API
class BancoDeDados(apiClient: ApiClient) {
    // Instância do serviço da API fornecida pelo ApiClient
    private val service = apiClient.service

    // Método para obter os posts da API
    // Método para obter os posts da API
    fun getHelloWord(context: Context, callback: Callback<String>) {
        // Faz uma chamada assíncrona para obter os posts
        val call = service.getOlaMundo()

        // Enfileira a chamada para executor em uma thread de fundo e especifica o callback personalizado
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    // Se a resposta for bem-sucedida, chama o método onResponse do callback com a string de resposta
                    callback.onResponse(call, Response.success(response.body() ?: ""))

                    // Aqui você pode processar a string de resposta conforme necessário
                    val mensagem = response.body() ?: "Resposta vazia"
                    exibirToast(context, mensagem)
                } else {
                    // Se houver um erro na resposta, chama o método onFailure do callback com o erro
                    callback.onFailure(call, Throwable("Erro na requisição: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                // Se houver uma falha na requisição, chama o método onFailure do callback com o erro
                callback.onFailure(call, t)

                // Exibe uma mensagem de erro em um Toast
                exibirToast(context, "Falha na requisição: ${t.message}")
            }
        })
    }

    // Método auxiliar para exibir um Toast com uma mensagem
    private fun exibirToast(context: Context, mensagem: String) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
    }

}
