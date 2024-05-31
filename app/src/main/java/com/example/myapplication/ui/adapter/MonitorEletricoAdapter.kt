package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MonitorEletricoAdapter(
    private val apartamentos: List<String>,
    private val onClickListener: (String) -> Unit
) : RecyclerView.Adapter<MonitorEletricoAdapter.ListaDeApartamentoViewHolder>() {

    // Arrays para controlar o estado de expansão dos itens
    private val expandir1 = Array<Boolean>(apartamentos.size) { false }
    private val expandir2 = Array<Boolean>(apartamentos.size) { false }

    // Cria novas visualizações (invocado pelo layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaDeApartamentoViewHolder {
        // Infla o layout de item de apartamento
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_monitor_eletrico, parent, false)
        // Retorna o ViewHolder
        return ListaDeApartamentoViewHolder(itemView)
    }

    // Substitui o conteúdo de uma view (invocado pelo layout manager)
    override fun onBindViewHolder(holder: ListaDeApartamentoViewHolder, position: Int) {
        val apartamento = apartamentos[position]
        // Liga os dados do apartamento com o ViewHolder
        holder.bind(apartamento)
        // Define a visibilidade do layout expandido com base no estado de expansão
        val isExpanded1 = expandir1[position]
        holder.expandedLayout.visibility = if (isExpanded1) View.VISIBLE else View.GONE
        val isExpanded2 = expandir2[position]
        holder.expandedMaisDetalhesLayout.visibility = if (isExpanded2) View.VISIBLE else View.GONE
    }

    // Retorna o número total de itens no conjunto de dados
    override fun getItemCount(): Int {
        return apartamentos.size
    }

    // ViewHolder que representa cada item de dados
    inner class ListaDeApartamentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Elementos de visualização dentro de um item de apartamento
        private val buttonApartamento: Button = itemView.findViewById(R.id.idExtenderApartamento)
        val expandedLayout: LinearLayout = itemView.findViewById(R.id.ExtenderLinearLayoutApartamento)
        private val textViewMaisDetalhes: TextView = itemView.findViewById(R.id.maisOuMenosDetalhes)
        val expandedMaisDetalhesLayout: LinearLayout = itemView.findViewById(R.id.ExtenderMaisDetalhesLinearLayout)

        init {
            // Configura o listener de clique no botão de cada item de apartamento
            buttonApartamento.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Obtém o estado de expansão atual e o altera
                    val isExpanded = expandir1[position]
                    expandir1[position] = !isExpanded
                    // Define a visibilidade do layout expandido
                    expandedLayout.visibility = if (isExpanded) View.GONE else View.VISIBLE
                }
            }

            // Configura o listener de clique no TextView "Mais detalhes" de cada item de apartamento
            textViewMaisDetalhes.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Obtém o estado de expansão atual e o altera
                    val isExpanded = expandir2[position]
                    expandir2[position] = !isExpanded
                    // Define a visibilidade do layout expandido de "Mais detalhes"
                    expandedMaisDetalhesLayout.visibility = if (isExpanded) View.GONE else View.VISIBLE
                }
            }
        }

        // Liga os dados do apartamento com o ViewHolder
        fun bind(apartamento: String) {
            buttonApartamento.text = apartamento
        }
    }
}
