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
import kotlinx.android.synthetic.main.fragment_after_donation_care.*

class AfterDonationCareFragment : Fragment() {
    private lateinit var binding: FragmentAfterDonationCareBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_after_donation_care, container, false)

        binding.btnCareBack.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }


}