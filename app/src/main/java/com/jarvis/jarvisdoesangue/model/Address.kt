package com.jarvis.jarvisdoesangue.model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("cep") val cep: String?,
    @SerializedName("logradouro") val logradouro: String?,
    @SerializedName("numero") val numero: String?,
    @SerializedName("complemento") val complemento: String?,
    @SerializedName("bairro") val bairro: String?,
    @SerializedName("cidade") val cidade: String?,
    @SerializedName("estado") val uf: String?,
    @SerializedName("id_usuario") val userId: Long
)
