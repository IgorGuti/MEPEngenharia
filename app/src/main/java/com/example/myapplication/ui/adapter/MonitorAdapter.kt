package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MonitorAdapter(private val apartamentos: List<String>, private val onClickListener: (String) -> Unit) : RecyclerView.Adapter<MonitorAdapter.ListaDeApartamentoViewHolder>() {

    private val expandir1 = Array<Boolean>(apartamentos.size) { false }
    private val expandir2 = Array<Boolean>(apartamentos.size) { false }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaDeApartamentoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_monitor_eletrico, parent, false)
        return ListaDeApartamentoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListaDeApartamentoViewHolder, position: Int) {
        val apartamento = apartamentos[position]
        holder.bind(apartamento)
        val isExpanded1 = expandir1[position]
        holder.expandedLayout.visibility = if (isExpanded1) View.VISIBLE else View.GONE
        val isExpanded2 = expandir2[position]
        holder.expandedLayout.visibility = if (isExpanded2) View.VISIBLE else View.GONE
    }

    override fun getItemCount(): Int {
        return apartamentos.size
    }

    inner class ListaDeApartamentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val buttonApartamento: Button = itemView.findViewById(R.id.idExtenderApartamento)
        val expandedLayout: LinearLayout = itemView.findViewById(R.id.ExtenderLinearLayout)
        private val textViewMaisDetalhes: TextView = itemView.findViewById(R.id.maisOuMenosDetalhes)
        val expandedMaisDetalhesLayout: LinearLayout = itemView.findViewById(R.id.ExtenderMaisDetalhesLinearLayout)

        init {
            buttonApartamento.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val isExpanded = expandir1[position]
                    expandir1[position] = !isExpanded
                    expandedLayout.visibility = if (isExpanded) View.GONE else View.VISIBLE
                }
            }

            textViewMaisDetalhes.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val isExpanded = expandir2[position]
                    expandir2[position] = !isExpanded
                    expandedMaisDetalhesLayout.visibility = if (isExpanded) View.GONE else View.VISIBLE
                }
            }
        }

        fun bind(apartamento: String) {
            buttonApartamento.text = apartamento
        }
    }
}
