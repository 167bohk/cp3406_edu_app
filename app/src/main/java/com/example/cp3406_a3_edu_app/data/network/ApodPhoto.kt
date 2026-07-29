package com.example.cp3406_a3_edu_app.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApodPhoto(
    val title: String,
    val date: String,
    val explanation: String,
    val url: String,
    val copyright: String? = null,
    @SerialName("media_type")
    val mediaType: String,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String? = null
)
