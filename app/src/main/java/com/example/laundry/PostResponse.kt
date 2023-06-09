package com.example.laundry

import com.google.gson.annotations.SerializedName

data class PostResponse(

	@field:SerializedName("PostResponse")
	val postResponse: ArrayList<PostResponseItem?>? = null
)

data class PostResponseItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
