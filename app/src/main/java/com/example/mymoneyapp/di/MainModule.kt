package com.example.mymoneyapp.di

import com.example.mymoneyapp.data.api.ApiDetail
import com.example.mymoneyapp.data.api.ApiEndPoint
import com.example.mymoneyapp.repository.Repository
import com.example.mymoneyapp.repository.RepositoryImplementation
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    fun provideGson() : Gson {
        return Gson()
    }

    @Provides
    fun provideLogggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun GsonConvertory (
        gson : Gson
    ) = GsonConverterFactory.create()

    @Provides
    fun provideOkHttpClient (
        logging : HttpLoggingInterceptor
    ) : OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    @Provides
    fun provideRetrofit (
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) : Retrofit = Retrofit.Builder()
        .baseUrl(ApiDetail.BASE_URL)
        .client(okHttpClient).addConverterFactory(converterFactory)
        .build()

    @Provides
    fun apiInstance (retrofit: Retrofit) : ApiEndPoint = retrofit.create(ApiEndPoint::class.java)

    @Provides
    fun providesRepository (apiEndPoint: ApiEndPoint) : Repository {
        return RepositoryImplementation(apiEndPoint)
    }
}