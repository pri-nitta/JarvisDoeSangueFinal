package com.jarvis.jarvisdoesangue.donationInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.jarvis.jarvisdoesangue.R
import com.jarvis.jarvisdoesangue.databinding.FragmentAfterDonationCareBinding
import com.jarvis.jarvisdoesangue.databinding.FragmentDonationIntervalBinding
import kotlinx.android.synthetic.main.fragment_donation_interval.*

class DonationPeriodicityFragment : Fragment() {

    private lateinit var binding: FragmentDonationIntervalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_donation_interval, container, false)

        binding.btnPeriodicityBack.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }


}