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
import com.example.myapplication.ui.adapter.MonitorReservatorioAdapter
import com.example.myapplication.ui.repository.ReservatoriosRepository

class MonitorReservatorioFragment : Fragment() {

    private val listaDeReservatorio = ReservatoriosRepository.getListaDeReservatorio()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_monitor_reservatorio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Encontrando o RecyclerView
        val recyclerViewMonitorReservatorio = view.findViewById<RecyclerView>(R.id.lista_reservatorio_recyclerview)

        // Criando e configurando o adaptador para a lista

        val adapter = MonitorReservatorioAdapter(listaDeReservatorio) { reservatorio ->
            // Ação a ser executada quando um botão for clicado
            Toast.makeText(requireContext(), "Botão do reservatorio $reservatorio clicado", Toast.LENGTH_SHORT).show()
        }
        recyclerViewMonitorReservatorio.adapter = adapter

        // Definindo o layout do gerenciador de layout
        recyclerViewMonitorReservatorio.layoutManager = LinearLayoutManager(requireContext())
    }
}
