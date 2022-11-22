package com.jarvis.jarvisdoesangue.donationInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jarvis.jarvisdoesangue.R
import com.jarvis.jarvisdoesangue.databinding.FragmentBasicRequirementsBinding
import kotlinx.android.synthetic.main.fragment_basic_requirements.*

class BasicRequirementsFragment : Fragment() {

    private lateinit var binding: FragmentBasicRequirementsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_basic_requirements,
            container,
            false
        )
        configureComponents()
        return binding.root
    }

    private fun configureComponents() {
        binding.btnBasicBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}