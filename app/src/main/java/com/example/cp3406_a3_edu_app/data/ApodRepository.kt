package com.example.cp3406_a3_edu_app.data

import com.example.cp3406_a3_edu_app.data.network.ApodPhoto
import com.example.cp3406_a3_edu_app.data.network.NasaApiService

interface ApodRepository {
    suspend fun getTodayPicture(): ApodPhoto
}

class NetworkApodRepository(
    private val nasaApiService: NasaApiService
) : ApodRepository {
    override suspend fun getTodayPicture(): ApodPhoto {
        return nasaApiService.getAstronomyPicture()
    }
}
