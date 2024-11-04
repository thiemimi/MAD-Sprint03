package com.example.sprint03.view.fragments.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sprint03.R
import com.example.sprint03.databinding.FragmentUpdateLeadBinding
import com.example.sprint03.model.Lead
import com.example.sprint03.viewmodel.LeadViewModel

class UpdateLeadFragment : Fragment() {

    // Usando Safe Args para receber os argumentos
    private val args: UpdateLeadFragmentArgs by navArgs()

    private var _binding: FragmentUpdateLeadBinding? = null
    private val binding get() = _binding!!

    private lateinit var leadViewModel: LeadViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateLeadBinding.inflate(inflater, container, false)

        leadViewModel = ViewModelProvider(this).get(LeadViewModel::class.java)

        binding.apply {
            editTextNome.setText(args.currentLead.nome)
            editTextEmail.setText(args.currentLead.email)
            editTextTelefone.setText(args.currentLead.telefone)
            editTextTitulo.setText(args.currentLead.titulo)
            editTextEmpresa.setText(args.currentLead.empresa)
        }

        binding.buttonEditarLead.setOnClickListener{
            updateLead()
        }

        return binding.root
    }

    private fun updateLead(){
        val nome = binding.editTextNome.text.toString()
        val titulo = binding.editTextTitulo.text.toString()
        val empresa = binding.editTextEmpresa.text.toString()
        val email = binding.editTextEmail.text.toString()
        val telefone = binding.editTextTelefone.text.toString()

        if(inputCheck(nome, titulo, empresa, email, telefone)){
            val updatedLead = Lead(args.currentLead.id, nome, titulo, empresa, email, telefone)
            leadViewModel.updateLead(updatedLead)
            Toast.makeText(requireContext(), "Atualizado com sucesso", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateLeadFragment_to_leadListFragment)
        }else{
            Toast.makeText(requireContext(), "Por favor preencha todos os campos", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(nome: String, titulo: String, empresa: String, email: String,telefone: String): Boolean{
        return !(TextUtils.isEmpty(nome)) && !(TextUtils.isEmpty(titulo))
                && !(TextUtils.isEmpty(empresa)) && !(TextUtils.isEmpty(email))
                && !(TextUtils.isEmpty(telefone))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Evita vazamentos de memória
    }
}
