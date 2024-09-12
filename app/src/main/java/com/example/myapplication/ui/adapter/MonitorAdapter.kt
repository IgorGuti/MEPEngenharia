package com.example.myapplication.ui.adapter

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.repository.ApiRepository
import com.example.myapplication.ui.repository.Medidor
import com.example.myapplication.ui.repository.ResponseMedidorEletrico

class MonitorAdapter(
    private var medidores: List<Medidor>,
    private val onClickListener: (Medidor) -> Unit,
    private val apiRepository: ApiRepository
) : RecyclerView.Adapter<MonitorAdapter.MedidorViewHolder>() {

    private val estadosExpansao = mutableSetOf<Int>()
    private val handler = Handler(Looper.getMainLooper())
    private val logRunnable = object : Runnable {
        override fun run() {
            registrarExpansoes()
            handler.postDelayed(this, 15000) // Registra a cada 15 segundos
        }
    }

    init {
        handler.post(logRunnable)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedidorViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_monitor_eletrico, parent, false)
        return MedidorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MedidorViewHolder, position: Int) {
        val medidor = medidores[position]
        holder.bind(medidor)

        val isExpanded = estadosExpansao.contains(position)
        holder.expandedLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE

        if (isExpanded) {
            apiRepository.getEletrico("teste_testado", medidor.identificador.toString(),
                onSuccess = { resposta ->
                    // Use post para garantir atualizações na UI na thread principal
                    holder.itemView.post {
                        if (position == holder.adapterPosition) {
                            holder.updateTextViews(resposta)
                        } else {
                            Log.d("MedidorAdapter", "ViewHolder reciclado antes da atualização")
                        }
                    }
                },
                onFailure = { erro ->
                    Log.e("ApiRepository", "Erro: ${erro.message}")
                }
            )
        }
    }
    override fun getItemCount(): Int = medidores.size

    private fun registrarExpansoes() {
        for (position in medidores.indices) {
            val isExpanded = estadosExpansao.contains(position)
            val medidor = medidores[position]
            registrarExpansao(position, isExpanded, medidor.nome, medidor.identificador.toString())
        }
    }

    private fun registrarExpansao(position: Int, isExpanded: Boolean, nomeMedidor: String, idMedidor: String) {
        val estado = if (isExpanded) "expandido" else "recolhido"
        Log.d("MonitorAdapter", "Item na posição $position está $estado. Nome: $nomeMedidor, ID: $idMedidor")

        apiRepository.getEletrico("teste_testado", idMedidor,
            onSuccess = { responseEletrico ->
                Log.d("Resposta Servidor", "$responseEletrico")

                if (estadosExpansao.contains(position)) {
                    val medidorAtualizado = medidores[position].copy(respostaEletrico = responseEletrico)
                    medidores = medidores.toMutableList().apply { this[position] = medidorAtualizado }
                    notifyItemChanged(position)
                }
            },
            onFailure = { erro ->
                Log.e("ApiRepository", "Erro: ${erro.message}")
            }
        )
    }

    inner class MedidorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val buttonMedidor: Button = itemView.findViewById(R.id.idExtenderApartamento)
        val expandedLayout: LinearLayout = itemView.findViewById(R.id.ExtenderEletricoLinearLayout)
        private val textViewMaisDetalhes: TextView = itemView.findViewById(R.id.maisOuMenosDetalhes)
        val expandedMaisDetalhesLayout: LinearLayout = itemView.findViewById(R.id.ExtenderMaisDetalhesLinearLayout)
        val idMedidor: TextView = itemView.findViewById(R.id.idMedidor)
        val voltzFaseA: TextView = itemView.findViewById(R.id.voltzFaseA)
        val voltzFaseB: TextView = itemView.findViewById(R.id.voltzFaseB)
        val voltzFaseC: TextView = itemView.findViewById(R.id.voltzFaseC)
        val consumoMensalA: TextView = itemView.findViewById(R.id.consumoMensalFaseA)
        val consumoMensalB: TextView = itemView.findViewById(R.id.consumoMensalFaseB)
        val consumoMensalC: TextView = itemView.findViewById(R.id.consumoMensalFaseC)
        val consumoTotal: TextView = itemView.findViewById(R.id.consumoMensalTotal)
        val fatorPotenciaFaseA: TextView = itemView.findViewById(R.id.fatorPotenciaFaseA)
        val fatorPotenciaFaseB: TextView = itemView.findViewById(R.id.fatorPotenciaFaseB)
        val fatorPotenciaFaseC: TextView = itemView.findViewById(R.id.fatorPotenciaFaseC)
        val fatorPotenciaTotal: TextView = itemView.findViewById(R.id.fatorPotenciaTotal)
        val potenciaAtivaFaseA: TextView = itemView.findViewById(R.id.potenciaAtivaFaseA)
        val potenciaAtivaFaseB: TextView = itemView.findViewById(R.id.potenciaAtivaFaseB)
        val potenciaAtivaFaseC: TextView = itemView.findViewById(R.id.potenciaAtivaFaseC)
        val potenciaAtivaTotal: TextView = itemView.findViewById(R.id.potenciaAtivaTotal)
        val correnteFaseA: TextView = itemView.findViewById(R.id.correnteFaseA)
        val correnteFaceB: TextView = itemView.findViewById(R.id.correnteFaseB)
        val correnteFaceC: TextView = itemView.findViewById(R.id.correnteFaseC)
        val correnteTotal: TextView = itemView.findViewById(R.id.correnteTotal)

        init {
            buttonMedidor.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val isExpanded = estadosExpansao.contains(position)
                    if (isExpanded) {
                        estadosExpansao.remove(position)
                    } else {
                        estadosExpansao.add(position)
                    }
                    notifyItemChanged(position)
                    val medidor = medidores[position]
                    registrarExpansao(position, !isExpanded, medidor.nome, medidor.identificador.toString())
                }
            }

            textViewMaisDetalhes.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val isExpanded = expandedMaisDetalhesLayout.visibility == View.VISIBLE
                    expandedMaisDetalhesLayout.visibility = if (isExpanded) View.GONE else View.VISIBLE
                    notifyItemChanged(position)
                }
            }
        }
        fun bind(medidor: Medidor) {
            buttonMedidor.text = medidor.nome
            idMedidor.text = "ID: ${medidor.identificador}"
            itemView.setOnClickListener { onClickListener(medidor) }

            // Atualize com a resposta se disponível
            medidor.respostaEletrico?.let { updateTextViews(it) }
        }

        fun updateTextViews(medidor: ResponseMedidorEletrico) {
            voltzFaseA.text = "Voltz Fase A: ${medidor.voltzFaseA}"
            voltzFaseB.text = "Voltz Fase B: ${medidor.voltzFaseB}"
            voltzFaseC.text = "Voltz Fase C: ${medidor.voltzFaseC}"
            consumoMensalA.text = "Consumo Mensal Fase A: ${medidor.consumoMensalA}"
            consumoMensalB.text = "Consumo Mensal Fase B: ${medidor.consumoMensalB}"
            consumoMensalC.text = "Consumo Mensal Fase C: ${medidor.consumoMensalC}"
            consumoTotal.text = "Consumo Total: ${medidor.consumoTotal}"
            fatorPotenciaFaseA.text = "Fator Potência Fase A: ${medidor.fatorPotenciaFaseA}"
            fatorPotenciaFaseB.text = "Fator Potência Fase B: ${medidor.fatorPotenciaFaseB}"
            fatorPotenciaFaseC.text = "Fator Potência Fase C: ${medidor.fatorPotenciaFaseC}"
            fatorPotenciaTotal.text = "Fator Potência Total: ${medidor.fatorPotenciaTotal}"
            potenciaAtivaFaseA.text = "Potência Ativa Fase A: ${medidor.potenciaAtivaFaseA}"
            potenciaAtivaFaseB.text = "Potência Ativa Fase B: ${medidor.potenciaAtivaFaseB}"
            potenciaAtivaFaseC.text = "Potência Ativa Fase C: ${medidor.potenciaAtivaFaseC}"
            potenciaAtivaTotal.text = "Potência Ativa Total: ${medidor.potenciaAtivaTotal}"
            correnteFaseA.text = "Corrente Fase A: ${medidor.correnteFaseA}"
            correnteFaceB.text = "Corrente Fase B: ${medidor.correnteFaseB}"
            correnteFaceC.text = "Corrente Fase C: ${medidor.correnteFaseC}"
            correnteTotal.text = "Corrente Total: ${medidor.correnteTotal}"
        }
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        handler.removeCallbacks(logRunnable)
    }
}
