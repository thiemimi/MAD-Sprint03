package com.example.sprint03.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint03.adapter.LeadsAdapter
import com.example.sprint03.databinding.ActivityLeadBinding
import com.example.sprint03.model.Lead
import com.example.sprint03.network.APIServices
import com.example.sprint03.network.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class LeadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeadBinding
    private val retrofitClient =
        RetrofitClient()
            .getRetrofit("https://66e7be56b17821a9d9d9c4e3.mockapi.io/sprint/")
            .create(APIServices::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLeadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SetaVoltar.setOnClickListener{
            abrirDashboard()
        }

        getLeads()

    }

    private fun getLeads(){
        val getLeads = retrofitClient.getLeads()

        getLeads.enqueue(object : retrofit2.Callback<List<Lead>>{
            override fun onResponse(call: Call<List<Lead>>, response: Response<List<Lead>>) {
                setupRecyclerView(response.body().orEmpty())
            }

            override fun onFailure(call: Call<List<Lead>>, t: Throwable) {
                println(t.message)
            }

        })
    }

    private fun abrirDashboard(){
        val intent = Intent(this, DashboardActivity::class.java )
        startActivity(intent)
    }

    private fun setupRecyclerView(lead: List<Lead>){
        val adapter = LeadsAdapter()
        adapter.submitList(lead)
        adapter.onClick = {
            println(it)
            abrirMaisDetalhes(it)
        }
        binding.RecyclerViewLeads.adapter = adapter
        binding.RecyclerViewLeads.layoutManager = LinearLayoutManager(this)

    }

    private fun abrirMaisDetalhes(lead: Lead){
        val intent = Intent(this, LeadMaisDetalhesActivity::class.java )
        intent
            .putExtra("EXTRA_EMAIL", lead.email)
            .putExtra("EXTRA_TELEFONE", lead.telefone)

        startActivity(intent)
    }


    private fun listaLead(): List<Lead>{
        return listOf(
            Lead(
                1,
                "João",
                "Empresa ABC",
                "Senior VP",
                "joao@gmail.com",
                "11994303765"
            ),
            Lead(
                2,
                "Maria",
                "Empresa XYZ",
                "System Administrator",
                "maria@gmail.com",
                "11993563049"
            ),
            Lead(
                3,
                "Fernando",
                "Empresa ABC",
                "Senior VP",
                "fernando@gmail.com",
                "11994244087"
            ),
            Lead(
                4,
                "Joana",
                "Empresa XYZ",
                "Senior VP",
                "joana@gmail.com",
                "119945744087"
            )


        )
    }
}