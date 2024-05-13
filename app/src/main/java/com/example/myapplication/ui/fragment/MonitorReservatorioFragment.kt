package com.example.myapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.ui.repository.ApiClient
import com.example.myapplication.ui.repository.BancoDeDados
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MonitorReservatorioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_monitor_reservatorio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView: WebView = view.findViewById(R.id.webView)
        webView.webChromeClient = WebChromeClient()

        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Caminho completo para o arquivo HTML
        val htmlFilePath = "file:///android_asset/monitor.html"
        webView.loadUrl(htmlFilePath)

        // Inicialize a instância de BancoDeDados
        val bancoDeDados = BancoDeDados(ApiClient())

        bancoDeDados.getHelloWord(requireContext(), object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    // Se a resposta for bem-sucedida, você pode acessar a string de resposta
                    val data = response.body()

                    // Faça o que você precisa com a string de resposta aqui
                } else {
                    // Se houver um erro na resposta, exibe uma mensagem de erro
                    Toast.makeText(requireContext(), "Erro na requisição: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                // Se houver uma falha na requisição, exibe uma mensagem de erro
                Toast.makeText(requireContext(), "Falha na requisição: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
