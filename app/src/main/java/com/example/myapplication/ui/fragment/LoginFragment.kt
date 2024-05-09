package com.example.myapplication.ui.fragment

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding

import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {


    private var _binding: FragmentLoginBinding? = null

    // Esta propriedade só é válida entre onCreateView e onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding  = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        val monitor_eletrico = view.findViewById<Button>(R.id.logando)

// Configurar ação de clique para o botão "Login Inicial"
        monitor_eletrico.setOnClickListener {
            // Navegar para o fragmento de login
            findNavController().navigate(R.id.nav_monitorEletrico)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
