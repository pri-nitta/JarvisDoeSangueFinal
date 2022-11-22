package com.jarvis.jarvisdoesangue.donation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jarvis.jarvisdoesangue.API.RetrofitFactoryAws
import com.jarvis.jarvisdoesangue.R
import com.jarvis.jarvisdoesangue.databinding.FragmentDonationHistoryBinding
import com.jarvis.jarvisdoesangue.model.Donation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DonationHistoryFragment : Fragment() {

    private lateinit var binding: FragmentDonationHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_donation_history, container, false
        )

        configureComponents()
        getDonations(1)
        return binding.root
    }

    private fun configureComponents() {
        binding.apply {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun getDonations(userId: Int) {
        val call = RetrofitFactoryAws().retrofitServiceAws().getDonations(userId)
        call.enqueue(object : Callback<Array<Donation>> {
            override fun onResponse(
                call: Call<Array<Donation>>,
                response: Response<Array<Donation>>
            ) {
                response.body()?.let {
                    binding.apply {
                        dateData.text = it[0].date
                        placeData.text = it[0].place
                        quantityData.text = it[0].quantity
                        feelingData.text = it[0].feeling
                        dateData2.text = it[1].date
                        placeData2.text = it[1].place
                        quantityData2.text = it[1].quantity
                        feelingData2.text = it[1].feeling
                        dateData3.text = it[2].date
                        placeData3.text = it[2].place
                        quantityData3.text = it[2].quantity
                        feelingData3.text = it[2].feeling
                        dateData4.text = it[3].date
                        placeData4.text = it[3].place
                        quantityData4.text = it[3].quantity
                        feelingData4.text = it[3].feeling
                    }
                } ?: Toast.makeText(context, "Nenhuma doação feita", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Array<Donation>>, t: Throwable) {
                t.message?.let { it1 -> Log.e("Erro", it1) }
                Toast.makeText(context, "Algum erro ocorreu", Toast.LENGTH_LONG).show()
            }

        })
    }

}