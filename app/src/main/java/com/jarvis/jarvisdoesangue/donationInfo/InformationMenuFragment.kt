package com.jarvis.jarvisdoesangue.donationInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.jarvis.jarvisdoesangue.R
import com.jarvis.jarvisdoesangue.databinding.FragmentInformationMenuBinding
import kotlinx.android.synthetic.main.fragment_information_menu.*

class InformationMenuFragment : Fragment() {

    private lateinit var binding: FragmentInformationMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_information_menu, container, false)
        configureComponents()
        return binding.root
    }
    
    private fun configureComponents(){
        binding.apply {
            basicRequirements.setOnClickListener ( Navigation.createNavigateOnClickListener(R.id.action_informationMenuFragment_to_basicRequirementsFragment))
            temporaryImpediments.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_informationMenuFragment_to_temporaryImpedimentsFragment))
            definitiveImpediments.setOnClickListener ( Navigation.createNavigateOnClickListener(R.id.action_informationMenuFragment_to_definitiveImpedimentsFragment))
            periodicity.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_informationMenuFragment_to_donationPeriodicityFragment))
            afterDonation.setOnClickListener( Navigation.createNavigateOnClickListener(R.id.action_informationMenuFragment_to_afterDonationCareFragment))
        }
    }

}