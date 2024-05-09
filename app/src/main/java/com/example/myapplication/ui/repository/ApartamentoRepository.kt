package com.example.myapplication.ui.repository

class ApartamentoRepository {
    companion object {
        fun getListaDeApartamentos(): List<String> {
            val listaDeApartamentos = mutableListOf<String>()
            for (i in 1..30) {
                listaDeApartamentos.add("Apartamento $i")
            }
            return listaDeApartamentos
        }
    }
}

