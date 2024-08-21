package com.example.myapplication.ui.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.ui.repository.ApiRepository

class MonitorReservatorioFragment : Fragment() {

    private lateinit var apiRepository: ApiRepository
    private lateinit var webView: WebView
    private lateinit var nomeView: TextView
    private lateinit var nivelView: TextView
    private lateinit var volumeView: TextView
    private lateinit var distanciaView: TextView
    private val handler = Handler(Looper.getMainLooper())
    private val updateInterval: Long = 15000 // 15 segundos

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar o layout do fragmento
        return inflater.inflate(R.layout.fragment_item_monitor_reservatorio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializa os TextViews
        nomeView = view.findViewById(R.id.nomeReservatorio)
        nivelView = view.findViewById(R.id.nivelReservatorio)
        volumeView = view.findViewById(R.id.volumeReservatorio)
        distanciaView = view.findViewById(R.id.distanciaReservatorio)

        // Inicializa o WebView
        webView = view.findViewById(R.id.webView)
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                // Inicializa o gauge com valor 0
                setGaugeValue(0)
                // Inicia o processo de atualização periódica
                startPeriodicUpdates()
            }
        }
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Caminho completo para o arquivo HTML
        val htmlFilePath = "file:///android_asset/1.html"
        webView.loadUrl(htmlFilePath)

        // Inicializa o ApiRepository com o contexto
        apiRepository = ApiRepository(requireContext())
    }

    private fun startPeriodicUpdates() {
        // Atualiza os dados periodicamente a cada 15 segundos
        handler.post(object : Runnable {
            override fun run() {
                carregarDadosReservatorio()
                handler.postDelayed(this, updateInterval)
            }
        })
    }
    private fun carregarDadosReservatorio() {
        apiRepository.fetchReservatorioDados { dados ->
            dados?.let {
                // Atualiza o valor dos TextViews com os dados recebidos
                nomeView.text = "Nome: ${it.nome}"
                nivelView.text = "Nivel: ${it.nivel}"
                volumeView.text = "Volume: ${it.volume}"
                distanciaView.text = "Distância: ${it.distancia}"

                // Atualiza o valor do gauge com o nível do reservatório
                setGaugeValue(it.nivel)
            } ?: run {
                // Tratar o caso onde os dados são nulos ou houve erro
                println("Erro ao obter dados: Dados são nulos")
                Toast.makeText(context, "Erro ao obter dados do servidor", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun setGaugeValue(value: Int) {
        webView.evaluateJavascript("setGaugeValue($value);") { result ->
            println("Resultado do JavaScript: $result")
            // A função setGaugeValue foi chamada com sucesso
            // Você pode tratar o resultado aqui, se necessário
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null) // Remove todos os callbacks do handler
    }
}
