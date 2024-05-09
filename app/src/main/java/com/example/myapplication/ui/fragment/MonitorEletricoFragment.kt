package com.example.myapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.adapter.MonitorAdapter
import com.example.myapplication.ui.repository.ApartamentoRepository

class MonitorEletricoFragment : Fragment() {

    // Lista de apartamentos
    private val listaDeApartamentos = ApartamentoRepository.getListaDeApartamentos()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_monitor_eletrico, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Encontrando o RecyclerView
        val recyclerViewMonitorEletrico = view.findViewById<RecyclerView>(R.id.lista_relogios_recyclerview)

        // Criando e configurando o adaptador para a lista
        val adapter = MonitorAdapter(listaDeApartamentos) { apartamento ->
            // Ação a ser executada quando um botão for clicado
            Toast.makeText(requireContext(), "Botão do apartamento $apartamento clicado", Toast.LENGTH_SHORT).show()
        }
        recyclerViewMonitorEletrico.adapter = adapter

        // Definindo o layout do gerenciador de layout
        recyclerViewMonitorEletrico.layoutManager = LinearLayoutManager(requireContext())
    }
}
