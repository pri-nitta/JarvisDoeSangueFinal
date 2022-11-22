package com.jarvis.jarvisdoesangue.donation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.jarvis.jarvisdoesangue.API.RetrofitFactoryAws
import com.jarvis.jarvisdoesangue.R
import com.jarvis.jarvisdoesangue.databinding.FragmentDonationRegistrationBinding
import com.jarvis.jarvisdoesangue.model.Donation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DonationRegistrationFragment : Fragment() {
    private lateinit var binding: FragmentDonationRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_donation_registration, container, false
        )

        configureComponents()
        return binding.root
    }

    private fun configureComponents() {
        binding.apply {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            btnRegister.setOnClickListener {
                postDonation(1)
            }
        }
    }

    private fun postDonation(userId: Int){
        val response = RetrofitFactoryAws().retrofitServiceAws().postDonation(
            Donation(
                date = binding.dateField.text.toString(),
                place = binding.placeField.text.toString(),
                quantity = (binding.bloodQuantityfield.text.toString()).toDouble(),
                feeling = binding.feelingField.text.toString(),
                userId = userId
            )
        )

        response.enqueue(object : Callback<Donation>{
            override fun onResponse(call: Call<Donation>, response: Response<Donation>) {
                Toast.makeText(context,"Doação Cadastrada!", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Donation>, t: Throwable) {
                Toast.makeText(context,"Houve um problema no cadastro", Toast.LENGTH_LONG).show()
            }
        })
    }


}