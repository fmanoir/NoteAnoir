package com.anoir.noteanoir.data.di

import com.anoir.noteanoir.data.common.BASE_URL
import com.anoir.noteanoir.data.common.DNS_TIMEOUT
import com.anoir.noteanoir.data.common.HOSTNAME
import com.anoir.noteanoir.data.common.PORT
import com.anoir.noteanoir.data.repositories.note.IEventService
import com.anoir.noteanoir.data.source.remote.api.EventAPI
import com.anoir.noteanoir.data.source.remote.common.error.ApiErrorHandler
import com.anoir.noteanoir.data.source.remote.common.error.IApiErrorHandler
import com.anoir.noteanoir.data.source.remote.common.network.InternetStatus
import com.anoir.noteanoir.data.source.remote.common.network.InternetStatusInterface
import com.anoir.noteanoir.data.source.remote.common.socket.ISocket
import com.anoir.noteanoir.data.source.remote.common.socket.SocketHandler
import com.anoir.noteanoir.data.source.remote.service.EventService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import javax.inject.Singleton
import javax.net.SocketFactory

/*
API/Service DI
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    // API
    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory {
        val gsonBuilder = GsonBuilder()
        return GsonConverterFactory.create(gsonBuilder.create())
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }


    @Singleton
    @Provides
    fun provideNoteAPI(retrofit: Retrofit): EventAPI {
        return retrofit.create(EventAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideApiErrorHandler(): IApiErrorHandler =
        ApiErrorHandler()

    @Singleton
    @Provides
    fun providesISocket(): ISocket = SocketHandler()

    @Singleton
    @Provides
    fun provideInternetStatusInterface(
        socket: ISocket
    ): InternetStatusInterface =
        InternetStatus(
            socketFactory = SocketFactory.getDefault(),
            socketAddress = InetSocketAddress(HOSTNAME, PORT),
            timeOut = DNS_TIMEOUT,
            socket = socket
        )


    // Service
    @Provides
    @Singleton
    fun provideNoteService(
        eventAPI: EventAPI,
        genericApiErrorHandler: IApiErrorHandler,
        internetStatusInterface: InternetStatusInterface
    ): IEventService {
        return EventService(
            eventAPI,
            genericApiErrorHandler,
            internetStatusInterface
        )
    }



}