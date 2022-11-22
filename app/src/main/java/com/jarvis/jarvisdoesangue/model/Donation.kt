package com.jarvis.jarvisdoesangue.model

import com.google.gson.annotations.SerializedName

data class Donation(
    @SerializedName("sentimento") val feeling: String,
    @SerializedName("data") val date: String,
    @SerializedName("clinica") val place: String,
    @SerializedName("quantidade_sangue") val quantity: Double,
    @SerializedName("id_usuario") val userId: Int
)
