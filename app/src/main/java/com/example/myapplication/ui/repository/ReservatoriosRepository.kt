package com.example.myapplication.ui.repository

class ReservatoriosRepository {
    companion object {
        fun getListaDeReservatorio(): List<String> {
            val listaDeApartamentos = mutableListOf<String>()
            for (i in 1..3) {
                listaDeApartamentos.add("Reservatorio $i")
            }
            return listaDeApartamentos
        }
    }
}


