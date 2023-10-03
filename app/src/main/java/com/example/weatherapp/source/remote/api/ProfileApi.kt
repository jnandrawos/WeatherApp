package com.example.weatherapp.source.remote.api

import com.example.weatherapp.presentation.models.ProfileResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileApi {
    @GET("api/")
    suspend fun getProfile(
        @Query("inc") inc: String? = "name,nat,picture"
    ): Response<ProfileResultModel>
}