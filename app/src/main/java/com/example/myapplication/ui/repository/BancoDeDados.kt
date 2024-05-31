package com.example.myapplication.ui.repository

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BancoDeDados(private val apiClient: ApiClient) {

    fun realizarRequisicao(context: Context, onDataReceivedListener: OnDataReceivedListener) {
        // Verificar conectividade de rede antes de fazer a requisição
        if (!isNetworkConnected(context)) {
            Toast.makeText(context, "Sem conexão com a internet", Toast.LENGTH_SHORT).show()
            return
        }
        // Fazer a chamada para o endpoint desejado
        val call = apiClient.service.getAguaTeste()

        // Executar a chamada assincronamente
        call.enqueue(object : Callback<List<String>> {
            override fun onResponse(
                call: Call<List<String>>,
                response: Response<List<String>>
            ) {
                if (response.isSuccessful) {
                    // Requisição bem sucedida, manipular os dados aqui
                    val dadosServidor = response.body()
                    // Invoque o callback com os dados recebidos
                    dadosServidor?.let { onDataReceivedListener.onDataReceived(it) }
                } else {
                    // Requisição não bem sucedida
                    Toast.makeText(context, "Erro na resposta do servidor.", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                // Ocorreu um erro durante a requisição
                Toast.makeText(context, "Erro ao realizar requisição: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    // Função para verificar conectividade de rede
    private fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
