package com.example.laundry

import com.google.gson.annotations.SerializedName

data class LayananResponse(

	@field:SerializedName("LayananResponse")
	val layananResponse: List<LayananResponseItem?>? = null
)

data class LayananResponseItem(

	@field:SerializedName("idKategori")
	val idKategori: Int? = null,

	@field:SerializedName("hargaUnit")
	val hargaUnit: Int? = null,

	@field:SerializedName("estimasiDurasi")
	val estimasiDurasi: Int? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("idUnit")
	val idUnit: Int? = null,

	@field:SerializedName("idKategoriNavigation")
	val idKategoriNavigation: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("idUnitNavigation")
	val idUnitNavigation: Any? = null,

	@field:SerializedName("pakets")
	val pakets: List<Any?>? = null
)
