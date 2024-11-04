package com.example.sprint03.view.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sprint03.R
import com.example.sprint03.databinding.FragmentAddLeadBinding
import com.example.sprint03.model.Lead
import com.example.sprint03.viewmodel.LeadViewModel


class AddLeadFragment : Fragment() {

    private var _binding: FragmentAddLeadBinding? = null
    private val binding get() = _binding!!

    private lateinit var leadViewModel: LeadViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddLeadBinding.inflate(inflater, container, false)

        leadViewModel = ViewModelProvider(this).get(LeadViewModel::class.java)

        binding.buttonCadastrarLead.setOnClickListener{
            insertDataToDatabase()
        }
        binding.SetaVoltar.setOnClickListener{
            findNavController().navigate(R.id.action_addLeadFragment_to_leadListFragment)
        }

        return binding.root
    }

    private fun insertDataToDatabase(){
        val nome = binding.editTextNome.text.toString()
        val titulo = binding.editTextTitulo.text.toString()
        val empresa = binding.editTextEmpresa.text.toString()
        val email = binding.editTextEmail.text.toString()
        val telefone = binding.editTextTelefone.text.toString()

        if(inputCheck(nome, titulo, empresa,email,telefone)){
            val lead = Lead(0,nome, titulo, empresa, email, telefone)
            leadViewModel.addLead(lead)
            Toast.makeText(requireContext(), "Lead adicionando com sucesso", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addLeadFragment_to_leadListFragment)
        }else{
            Toast.makeText(requireContext(), "Por favor preencha todos os campos", Toast.LENGTH_LONG).show()
        }


    }

    private fun inputCheck(nome: String, titulo: String, empresa: String, email: String,telefone: String): Boolean{
        return !(TextUtils.isEmpty(nome)) && !(TextUtils.isEmpty(titulo))
                && !(TextUtils.isEmpty(empresa)) && !(TextUtils.isEmpty(email))
                && !(TextUtils.isEmpty(telefone))
    }
}