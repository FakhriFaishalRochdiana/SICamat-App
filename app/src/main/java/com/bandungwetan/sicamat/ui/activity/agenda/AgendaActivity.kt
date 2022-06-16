package com.bandungwetan.sicamat.ui.activity.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bandungwetan.sicamat.R
import com.bandungwetan.sicamat.adapter.AgendaRecyclerAdapter
import com.bandungwetan.sicamat.databinding.ActivityAgendaBinding
import com.bandungwetan.sicamat.lightStatusBar

class AgendaActivity : AppCompatActivity() {
    private var _binding : ActivityAgendaBinding? = null
    private val binding get() = _binding!!
    private lateinit var agendaAdapter : AgendaRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAgendaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        lightStatusBar(window)

        agendaAdapter = AgendaRecyclerAdapter()
        binding.recyclerviewagenda.adapter = agendaAdapter
    }
}