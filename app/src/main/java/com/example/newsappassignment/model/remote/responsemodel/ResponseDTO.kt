package com.example.newsappassignment.model.remote.responsemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseDTO(

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesDTO?>? = null
):Serializable

data class ArticlesDTO(

	@field:SerializedName("source")
	val source: SourceDTO? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("urlToImage")
	val urlToImage: String? = null,

	@field:SerializedName("publishedAt")
	val publishedAt: String? = null,

	@field:SerializedName("content")
	val content: String? = null
):Serializable
data class SourceDTO(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("name")
	val name: String? = null

):Serializable