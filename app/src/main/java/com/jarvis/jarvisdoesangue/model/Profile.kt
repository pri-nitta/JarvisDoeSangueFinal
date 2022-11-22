package com.jarvis.jarvisdoesangue.model

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("nome") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("senha") val password: String,
    @SerializedName("cpf") val cpf: String,
    @SerializedName("genero") val gender: String,
    @SerializedName("altura") val height: String,
    @SerializedName("peso") val weight: String,
    @SerializedName("estado_civil") val maritalStatus: String,
    @SerializedName("tp_sanguineo") val bloodType: String,
    @SerializedName("data_nascimento") val birthdate: String
)
