package com.example.weatherapp.source.remote.service

import com.example.weatherapp.base.di.NetworkModule
import com.example.weatherapp.base.models.APIResponse
import com.example.weatherapp.base.models.Status
import com.example.weatherapp.base.qualifiers.Profile
import com.example.weatherapp.presentation.models.ProfileResultModel
import com.example.weatherapp.source.remote.api.ProfileApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProfileService @Inject constructor(@Profile private val profileApi: ProfileApi) {
    private suspend fun getProfileRemote(): APIResponse<ProfileResultModel> =
        NetworkModule().getResponse {
            profileApi.getProfile()
        }

    suspend fun getProfile(): Flow<APIResponse<ProfileResultModel>> {
        return flow {
            emit(APIResponse.loading())
            val response =
                getProfileRemote()
            emit(response)
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(
                    APIResponse(
                        Status.ERROR,
                        data = null,
                        Exception(it),
                        it.message.toString()
                    )
                )
            }
    }
}