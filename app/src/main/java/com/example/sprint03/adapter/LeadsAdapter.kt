package com.example.sprint03.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint03.databinding.ListItemLeadBinding
import com.example.sprint03.model.Lead

class LeadsAdapter: ListAdapter<Lead, LeadsAdapter.MyViewHolder>(AsyncCallback()) {

    var onClick: (lead: Lead) -> Unit = {}

    inner class MyViewHolder(val binding: ListItemLeadBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(lead: Lead){
            binding.textViewLeadNomeCompleto.text = lead.nome
            binding.textViewLeadTitulo.text = lead.titulo
            binding.textViewLeadEmpresa.text = lead.empresa
            binding.textViewLeadEmail.text = lead.email
            binding.textViewLeadTelefone.text = lead.telefone

            binding.root.setOnClickListener{
                onClick(lead)
            }
        }
    }

    class AsyncCallback: DiffUtil.ItemCallback<Lead>(){
        override fun areItemsTheSame(oldItem: Lead, newItem: Lead): Boolean {
           return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Lead, newItem: Lead): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemLeadBinding = ListItemLeadBinding.inflate(layoutInflater)
        val myViewHolder = MyViewHolder(binding)
        return myViewHolder

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}