package com.example.weatherapp.base.di


import com.example.weatherapp.BuildConfig
import com.example.weatherapp.base.interceptors.ApiKeyInterceptor
import com.example.weatherapp.base.models.APIResponse
import com.example.weatherapp.base.models.ErrorDataModel
import com.example.weatherapp.source.remote.api.WeatherApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val loggingInterceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }


    @Provides
    @Singleton
    fun providesOkHttpClient() =
        OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).addInterceptor(loggingInterceptor)
            .addInterceptor(ApiKeyInterceptor())
            .build()

    @Provides
    @Singleton
    fun getGson(): Gson {
        return Gson()
    }


    @Singleton
    @Provides
    fun getRetrofit(
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

    suspend fun <T> getResponse(
        request: suspend () -> Response<T>
    ): APIResponse<T> {
        try {
            val result = request.invoke()
            if (result.isSuccessful) {
                return APIResponse.success(result.body())
            } else {
                var message = "ERROR"
                val errorBody: ResponseBody? = result.errorBody()
                if (errorBody != null) {
                    val jsonString = errorBody.string()
                    val gson = Gson()
                    val errorResponse = gson.fromJson(jsonString, ErrorDataModel::class.java)
                    message = errorResponse?.message.toString()
                }

                return APIResponse.error(
                    message = message,
                    Exception(),
                )
            }
        } catch (e: Throwable) {
            return APIResponse.error("Unknown Error", Exception(e))
        }
    }

    @Provides
    @Singleton
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

}