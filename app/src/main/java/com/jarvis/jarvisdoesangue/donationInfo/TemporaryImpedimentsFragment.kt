package com.jarvis.jarvisdoesangue.donationInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jarvis.jarvisdoesangue.R
import com.jarvis.jarvisdoesangue.databinding.FragmentTemporaryImpedimentsBinding
import kotlinx.android.synthetic.main.fragment_basic_requirements.*
import kotlinx.android.synthetic.main.fragment_temporary_impediments.*

class TemporaryImpedimentsFragment : Fragment() {

    private lateinit var binding: FragmentTemporaryImpedimentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_temporary_impediments, container, false)
        binding.btnTemporaryBack.setOnClickListener{
            findNavController().popBackStack()
        }
        return binding.root
    }
}