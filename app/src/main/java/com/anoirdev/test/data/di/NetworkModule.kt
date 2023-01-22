package com.anoirdev.test.data.di

import com.anoirdev.test.data.repositories.event.IEventService
import com.anoirdev.test.data.source.remote.api.EventAPI
import com.anoirdev.test.data.source.remote.common.error.ApiErrorHandler
import com.anoirdev.test.data.source.remote.common.error.IApiErrorHandler
import com.anoirdev.test.data.source.remote.common.network.InternetStatus
import com.anoirdev.test.data.source.remote.common.network.InternetStatusInterface
import com.anoirdev.test.data.source.remote.common.socket.ISocket
import com.anoirdev.test.data.source.remote.common.socket.SocketHandler
import com.anoirdev.test.data.source.remote.service.EventService
import com.anoirdev.test.utlis.BASE_URL
import com.anoirdev.test.utlis.DNS_TIMEOUT
import com.anoirdev.test.utlis.HOSTNAME
import com.anoirdev.test.utlis.PORT
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
    fun provideEventAPI(retrofit: Retrofit): EventAPI {
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
    fun provideEventService(
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