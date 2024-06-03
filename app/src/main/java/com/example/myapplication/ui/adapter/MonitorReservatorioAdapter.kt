package com.example.myapplication.ui.adapter

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.repository.ApiClient
import com.example.myapplication.ui.repository.BancoDeDados
import com.example.myapplication.ui.repository.OnDataReceivedListener
class MonitorReservatorioAdapter(
    private var reservatorios: List<String>,
    private val onClickListener: (String) -> Unit
) : RecyclerView.Adapter<MonitorReservatorioAdapter.ListaDeReservatoriosViewHolder>(), OnDataReceivedListener {

    private val expandir = Array(reservatorios.size) { false }
    private val handler = Handler(Looper.getMainLooper())
    private var recyclerView: RecyclerView? = null
    private val apiClient = ApiClient()
    private val bancoDeDados = BancoDeDados(apiClient)

    private var gaugeValue: Int = 0  // Variável para armazenar o valor do medidor

    private val reloadRunnable = object : Runnable {
        override fun run() {
            recyclerView?.context?.let { context ->
                bancoDeDados.realizarRequisicao(context, this@MonitorReservatorioAdapter)
            }
            handler.postDelayed(this, 10000)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaDeReservatoriosViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_monitor_reservatorio, parent, false)
        return ListaDeReservatoriosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListaDeReservatoriosViewHolder, position: Int) {
        holder.bind(reservatorios[position])
        val isExpanded = if (position < expandir.size) expandir[position] else false
        holder.expandedLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.updateGauge(gaugeValue) // Atualiza o medidor na visualização


    }

    override fun getItemCount(): Int {
        return reservatorios.size
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
        handler.postDelayed(reloadRunnable, 10000)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        handler.removeCallbacks(reloadRunnable)
        this.recyclerView = null
    }

    inner class ListaDeReservatoriosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val buttonReservatorio: Button = itemView.findViewById(R.id.idButtonReservatorio)
        private val texteViewData: TextView = itemView.findViewById(R.id.idDataRegistro)
        private val texteViewVolume: TextView = itemView.findViewById(R.id.idVolume)
        private val texteViewDistancia: TextView = itemView.findViewById(R.id.idDistancia)
        val expandedLayout: LinearLayout = itemView.findViewById(R.id.ExtenderLinearLayoutReservatorio)
        private val webView: WebView = itemView.findViewById(R.id.webView)

        init {
            buttonReservatorio.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val isExpanded = expandir[position]
                    expandir[position] = !isExpanded
                    expandedLayout.visibility = if (isExpanded) View.GONE else View.VISIBLE
                }
            }
            webView.settings.apply {
                javaScriptEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true
                domStorageEnabled = true
                cacheMode = WebSettings.LOAD_NO_CACHE
            }
            val htmlFilePath = "file:///android_asset/monitor.html"
            webView.loadUrl(htmlFilePath)
        }

        fun bind(reservatorio: String) {
            buttonReservatorio.text = reservatorio
        }

        fun updateGauge(value: Int) {
            webView.post {
                webView.evaluateJavascript("updateGauge($value)") {
                    // Trate a resposta ou resultado, se necessário
                    Toast.makeText(itemView.context, "Atualizado para $value", Toast.LENGTH_SHORT).show()
                }
            }
        }
        fun updateTextView(nomeString: String, dataString: String, volumeString: String, distanciaString: String) {
            buttonReservatorio.text = nomeString
            texteViewData.text = dataString
            texteViewVolume.text = volumeString
            texteViewDistancia.text = distanciaString
        }
    }

    override fun onDataReceived(data: List<String>) {
        if (data.size < 5) {
            Toast.makeText(recyclerView?.context, "Não há dados suficientes do servidor.", Toast.LENGTH_SHORT).show()
            return
        }
        val nomeString = data[0]
        val dataString = data[1]
        val volumeString = data[2]
        val distanciaString = data[3]
        val nivelString = data[4]
        val value = nivelString.toIntOrNull()
        value?.let {
            gaugeValue = it  // Atualiza o valor do medidor
            notifyDataSetChanged()  // Notifica o RecyclerView para atualizar as visualizações

            recyclerView?.let { rv ->// Chama updateTextView para cada ViewHolder visível
                for (i in 0 until rv.childCount) {
                    val holder = rv.getChildViewHolder(rv.getChildAt(i)) as? ListaDeReservatoriosViewHolder
                    holder?.updateTextView(nomeString, dataString, volumeString, distanciaString)
                }
            }
        }

    }
}
