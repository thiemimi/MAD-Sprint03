package com.example.sprint03.view.fragments.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint03.R
import com.example.sprint03.adapter.FeedbackAdapter
import com.example.sprint03.databinding.FragmentFeedbackListBinding
import com.example.sprint03.view.DashboardActivity
import com.example.sprint03.viewmodel.FeedbackViewModel

class FeedbackListFragment : Fragment() {

    private var _binding: FragmentFeedbackListBinding? = null
    private val binding get() = _binding!!

    private lateinit var feedbackViewModel: FeedbackViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFeedbackListBinding.inflate(inflater, container, false)

        val adapter = FeedbackAdapter()

        binding.RecyclerViewFeedbacks.adapter = adapter
        binding.RecyclerViewFeedbacks.layoutManager = LinearLayoutManager(requireContext())

        feedbackViewModel = ViewModelProvider(this).get(FeedbackViewModel::class.java)
        feedbackViewModel.readAllFeedbacks.observe(viewLifecycleOwner, Observer { feedbacks ->
            adapter.submitList(feedbacks)
        })

        adapter.onClick = { feedback ->
            val action = FeedbackListFragmentDirections.actionFeedbackListFragmentToUpdateFeedbackFragment(feedback)
            findNavController().navigate(action)
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_feedbackListFragment_to_addFeedbackFragment)
        }

        binding.SetaVoltar.setOnClickListener {
            abrirDashboard()
        }

        return binding.root
    }

    private fun abrirDashboard() {
        val intent = Intent(requireActivity(), DashboardActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
