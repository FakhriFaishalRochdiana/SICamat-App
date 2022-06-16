package com.bandungwetan.sicamat.ui.home.agenda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bandungwetan.sicamat.databinding.FragmentAgendaBinding

class AgendaFragment : Fragment() {
    private var _binding: FragmentAgendaBinding? = null
    private val binding get() = _binding!!
    private lateinit var Agendaadapter : AgendaRecyclerAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentAgendaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Agendaadapter = AgendaRecyclerAdapter()
        binding.recyclerviewagenda.adapter = Agendaadapter

    }
}