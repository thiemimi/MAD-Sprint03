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
import com.example.sprint03.databinding.FragmentAddFeedbackBinding
import com.example.sprint03.model.Feedback
import com.example.sprint03.viewmodel.FeedbackViewModel

class AddFeedbackFragment : Fragment() {

    private var _binding: FragmentAddFeedbackBinding? = null
    private val binding get() = _binding!!

    private lateinit var feedbackViewModel: FeedbackViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddFeedbackBinding.inflate(inflater, container, false)

        feedbackViewModel = ViewModelProvider(this).get(FeedbackViewModel::class.java)

        binding.buttonCadastrarFeedback.setOnClickListener {
            insertDataToDatabase()
        }

        binding.SetaVoltar.setOnClickListener {
            findNavController().navigate(R.id.action_addFeedbackFragment_to_feedbackListFragment)
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val lead = binding.editTextLead.text.toString()
        val feedback = binding.editTextFeedback.text.toString()

        if (inputCheck(lead, feedback)) {
            val feedback = Feedback(0, lead, feedback)
            feedbackViewModel.addFeedback(feedback)
            Toast.makeText(requireContext(), "Feedback adicionado com sucesso", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFeedbackFragment_to_feedbackListFragment)
        } else {
            Toast.makeText(requireContext(), "Por favor, preencha todos os campos", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(lead: String, feedback: String): Boolean {
        return !(TextUtils.isEmpty(lead)) && !(TextUtils.isEmpty(feedback))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
