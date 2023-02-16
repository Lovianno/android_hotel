package com.example.laundry

import com.google.gson.annotations.SerializedName

data class SocialMed(

	@field:SerializedName("SocialMed")
	val socialMed: ArrayList<SocialMedItem?>? = null
)

data class SocialMedItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
