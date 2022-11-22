package com.jarvis.jarvisdoesangue.profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.jarvis.jarvisdoesangue.API.RetrofitFactory
import com.jarvis.jarvisdoesangue.R
import com.jarvis.jarvisdoesangue.databinding.FragmentAddressBinding
import com.jarvis.jarvisdoesangue.model.CEP
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class AddressFragment : Fragment() {

    private lateinit var binding: FragmentAddressBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_address, container, false
        )

        configureComponents()
        return binding.root
    }

    private fun configureComponents(){
        binding.btnRegister.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_addressFragment_to_confirmationFragment)

            val addressPersistence = activity?.getSharedPreferences("address", Context.MODE_PRIVATE)
            val editor = addressPersistence?.edit()

            editor?.putString("telefone", binding.telephoneField.text.toString())
            editor?.putString("cep", binding.zipCodeField.text.toString())
            editor?.putString("logradouro", binding.streetField.text.toString())
            editor?.putString("numero", binding.numberField.text.toString())
            editor?.putString("complemento", binding.additionalDataField.text.toString())
            editor?.putString("bairro", binding.neighbourhoodField.text.toString())
            editor?.putString("cidade", binding.cityField.text.toString())
            editor?.putString("estado", binding.stateField.text.toString())
            editor?.apply()

            Toast.makeText(context, getString(R.string.address_register), Toast.LENGTH_SHORT).show()
        }
        binding.apply {

            zipCodeField.doAfterTextChanged {
                if (!zipCodeField.text.isNullOrEmpty()){
                    if (zipCodeField.text?.length == 8){
                        getAddress()
                    }
                }
            }
        }
    }


    private fun getAddress(){
        val call = RetrofitFactory().retrofitService().getCEP(binding.zipCodeField.text.toString())
        call.enqueue(object : Callback<CEP>{
            override fun onResponse(call: Call<CEP>, response: Response<CEP>){
                response.body()?.let {
                    binding.apply{
                        streetField.setText(it.rua)
                        neighbourhoodField.setText(it.bairro)
                        cityField.setText(it.cidade)
                        stateField.setText(it.uf)
                    }
                }?: Toast.makeText(context,"Endereço não localizado", Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<CEP>, t: Throwable) {
                t.message?.let { it1 -> Log.e("Erro", it1) }
            }

        })

    }


}