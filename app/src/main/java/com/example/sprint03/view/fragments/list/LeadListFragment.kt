package com.example.sprint03.view.fragments.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint03.R
import com.example.sprint03.adapter.LeadsAdapter
import com.example.sprint03.databinding.FragmentLeadListBinding
import com.example.sprint03.view.DashboardActivity
import com.example.sprint03.view.fragments.update.UpdateLeadFragmentArgs
import com.example.sprint03.viewmodel.LeadViewModel

class LeadListFragment : Fragment() {

    private var _binding: FragmentLeadListBinding? = null
    private val binding get() = _binding!!

    private lateinit var leadViewModel: LeadViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLeadListBinding.inflate(inflater, container, false)

        val adapter = LeadsAdapter()
        binding.RecyclerViewLeads.adapter = adapter
        binding.RecyclerViewLeads.layoutManager = LinearLayoutManager(requireContext())

        leadViewModel = ViewModelProvider(this).get(LeadViewModel::class.java)
        leadViewModel.readAllLead.observe(viewLifecycleOwner, Observer { lead ->
            adapter.submitList(lead)
        })

        adapter.onClick = { lead ->
            val action = LeadListFragmentDirections.actionLeadListFragmentToUpdateLeadFragment(lead)
            findNavController().navigate(action)
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_leadListFragment_to_addLeadFragment)
        }

        binding.SetaVoltar.setOnClickListener{
            abrirDashboard()
        }

        return binding.root
    }

    private fun abrirDashboard(){
        val intent = Intent(requireActivity(), DashboardActivity::class.java )
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
