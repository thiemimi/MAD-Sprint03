package com.example.sprint03.view.fragments.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sprint03.R
import com.example.sprint03.databinding.FragmentUpdateFeedbackBinding
import com.example.sprint03.model.Feedback
import com.example.sprint03.viewmodel.FeedbackViewModel

class UpdateFeedbackFragment : Fragment() {

    private val args: UpdateFeedbackFragmentArgs by navArgs()

    private var _binding: FragmentUpdateFeedbackBinding? = null
    private val binding get() = _binding!!

    private lateinit var feedbackViewModel: FeedbackViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateFeedbackBinding.inflate(inflater, container, false)

        feedbackViewModel = ViewModelProvider(this).get(FeedbackViewModel::class.java)

        // Preenche os campos com os dados do feedback atual
        binding.apply {
            editTextLead.setText(args.currentFeedback.lead)
            editTextFeedback.setText(args.currentFeedback.feedback)
        }

        binding.buttonEditarFeedback.setOnClickListener {
            updateFeedback()
        }

        binding.SetaVoltar.setOnClickListener {
            findNavController().navigate(R.id.action_updateFeedbackFragment_to_feedbackListFragment)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun updateFeedback() {
        val lead = binding.editTextLead.text.toString()
        val feedback = binding.editTextFeedback.text.toString()

        if (inputCheck(lead, feedback)) {
            val updatedFeedback = Feedback(args.currentFeedback.id, lead, feedback)
            feedbackViewModel.updateFeedback(updatedFeedback)
            Toast.makeText(requireContext(), "Atualizado com sucesso", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFeedbackFragment_to_feedbackListFragment)
        } else {
            Toast.makeText(requireContext(), "Por favor preencha todos os campos", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(lead: String, feedback: String): Boolean {
        return !(TextUtils.isEmpty(lead)) && !(TextUtils.isEmpty(feedback))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteFeedback()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteFeedback() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Sim") { _, _ ->
            feedbackViewModel.deleteFeedback(args.currentFeedback)
            Toast.makeText(requireContext(), "Removido com sucesso: ${args.currentFeedback.lead}",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFeedbackFragment_to_feedbackListFragment)
        }

        builder.setNegativeButton("Não") { _, _ -> }

        builder.setTitle("Deletar ${args.currentFeedback.lead}?")
        builder.setMessage("Tem certeza que deseja deletar o feedback de ${args.currentFeedback.lead}?")
        builder.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
