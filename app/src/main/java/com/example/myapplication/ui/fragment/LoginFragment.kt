package com.example.myapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.ui.repository.ApiRepository

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var apiRepository: ApiRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        apiRepository = ApiRepository(requireContext())

        // Configurar ação de clique para o botão "Login"
        binding.logando.setOnClickListener {
            val username = binding.loginUsuario.text.toString()
            val password = binding.loginSenha.text.toString()

            apiRepository.login(username, password,
                onSuccess = {
                    // Navegar para o próximo fragmento após o login bem-sucedido
                    findNavController().navigate(R.id.nav_monitorReservatorio)
                },
                onFailure = { throwable ->
                    // Tratar falha na requisição
                    println("Falha na requisição: ${throwable.message}")
                }
            )
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
