package com.dagger.hilt.di

import com.dagger.hilt.BuildConfig
import com.dagger.hilt.data.remote.UsersRemoteDS
import com.dagger.hilt.data.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    fun provideBaseUrl() = "https://5e510330f2c0d300147c034c.mockapi.io/"

    @Provides
    @Singleton
    fun provideOkHttpClient() = run {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit = run {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }


    @Provides
    fun provideUsersRemoteDS(retrofit: Retrofit): UsersRemoteDS =
        retrofit.create(UsersRemoteDS::class.java)

    @Provides
    fun provideUsersRepository(usersRemoteDS: UsersRemoteDS) = UsersRepository(usersRemoteDS)
}