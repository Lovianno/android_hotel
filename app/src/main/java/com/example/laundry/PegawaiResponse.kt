package com.example.laundry

import com.google.gson.annotations.SerializedName

data class PegawaiResponse(

	@field:SerializedName("PegawaiResponse")
	val pegawaiResponse: List<PegawaiResponseItem?>? = null
)

data class PegawaiResponseItem(

	@field:SerializedName("notelp")
	val notelp: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("foto")
	val foto: Any? = null,

	@field:SerializedName("idJabatanNavigation")
	val idJabatanNavigation: Any? = null,

	@field:SerializedName("tgllahir")
	val tgllahir: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("idJabatan")
	val idJabatan: Int? = null,

	@field:SerializedName("transaksis")
	val transaksis: List<Any?>? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null
)
