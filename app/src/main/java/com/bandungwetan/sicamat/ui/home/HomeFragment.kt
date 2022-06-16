package com.bandungwetan.sicamat.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bandungwetan.sicamat.R
import com.bandungwetan.sicamat.databinding.FragmentHomeBinding
import com.bandungwetan.sicamat.ui.activity.adzan.AdzanActivity

class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvAdzan.setOnClickListener(this)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.cv_adzan -> {
                val intent = Intent(activity, AdzanActivity::class.java)
                startActivity(intent)
            }
        }
    }
}