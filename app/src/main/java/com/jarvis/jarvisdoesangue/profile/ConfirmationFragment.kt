package com.jarvis.jarvisdoesangue.profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.jarvis.jarvisdoesangue.API.RetrofitFactoryAws
import com.jarvis.jarvisdoesangue.R
import com.jarvis.jarvisdoesangue.databinding.FragmentConfirmationBinding
import com.jarvis.jarvisdoesangue.model.Address
import com.jarvis.jarvisdoesangue.model.Profile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConfirmationFragment : Fragment() {

    private lateinit var binding: FragmentConfirmationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_confirmation, container, false
        )

        persistenceData()
        configureComponents()
        return binding.root
    }

    private fun configureComponents() {
        binding.apply {
            btnBack.setOnClickListener{
                it.findNavController().navigate(R.id.menuFragment)
            }

            btnRegister.setOnClickListener {
                postProfile()
                postAddress()
            }
        }
    }

    private fun persistenceData(){
        val personalDataPersistence = activity?.getSharedPreferences("personalData", Context.MODE_PRIVATE)
        val addressPersistence = activity?.getSharedPreferences("address", Context.MODE_PRIVATE)

        binding.apply {
            nameData.text = personalDataPersistence?.getString("nome", "")
            emailData.text = personalDataPersistence?.getString("email", "")
            cpfData.text = personalDataPersistence?.getString("cpf","")
            birthdateData.text = personalDataPersistence?.getString("dataNascimento", "")
            maritalData.text = personalDataPersistence?.getString("estadoCivil", "")
            weightData.text = personalDataPersistence?.getString("peso", "")
            heightData.text = personalDataPersistence?.getString("altura", "")
            bloodTypeData.text = personalDataPersistence?.getString("tipoSanguineo", "")
            genderData.text = personalDataPersistence?.getString("genero", "")

            telephoneData.text = addressPersistence?.getString("telefone", "")
            zipcodeData.text = addressPersistence?.getString("cep", "")
            streetData.text = addressPersistence?.getString("logradouro", "")
            numberData.text = addressPersistence?.getString("numero", "")
            additionalDataData.text = addressPersistence?.getString("complemento", "")
            neighbourhoodData.text = addressPersistence?.getString("bairro", "")
            cityData.text = addressPersistence?.getString("cidade", "")
            stateData.text = addressPersistence?.getString("estado", "")

        }
    }


    private fun postProfile(){
        val response = RetrofitFactoryAws().retrofitServiceAws().postUserInfo(
            Profile(
                name = binding.nameData.text.toString(),
                email = binding.emailData.text.toString(),
                cpf = binding.cpfData.text.toString(),
                birthdate = binding.birthdateData.text.toString(),
                maritalStatus = binding.maritalData.text.toString(),
                weight = binding.weightData.text.toString(),
                height = binding.heightData.text.toString(),
                bloodType = binding.bloodTypeData.text.toString(),
                password = activity?.getSharedPreferences("personalData", Context.MODE_PRIVATE)?.getString("senha", "")?:"",
                gender = binding.genderData.text.toString()
                )
        )
        response.enqueue(object : Callback<Profile>{
            override fun onFailure(call: Call<Profile>, t: Throwable) {
                Toast.makeText(context,"Cadastro não efetuado", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                Toast.makeText(context,"Cadastro realizado!", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun postAddress(){
        val call = RetrofitFactoryAws().retrofitServiceAws().postAddress(
            Address(
                cep = binding.zipcodeData.text.toString(),
                logradouro = binding.stateData.text.toString(),
                numero = binding.numberData.text.toString(),
                complemento = binding.additionalDataData.text.toString(),
                bairro = binding.neighbourhoodData.text.toString(),
                cidade = binding.cityData.text.toString(),
                uf = binding.stateData.text.toString(),
                userId = 1
            )
        )
        call.enqueue(object : Callback<Address>{
            override fun onResponse(call: Call<Address>, response: Response<Address>) {
            }

            override fun onFailure(call: Call<Address>, t: Throwable) {
            }
        })
    }

}