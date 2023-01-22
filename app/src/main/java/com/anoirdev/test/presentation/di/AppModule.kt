package com.anoirdev.test.presentation.di

import android.content.Context
import com.anoirdev.test.utlis.dispatcher.DispatcherProvider
import com.anoirdev.test.utlis.dispatcher.IDispatcherProvider
import com.anoirdev.test.utlis.resource.IResourceProvider
import com.anoirdev.test.utlis.resource.ResourceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    @Singleton
    fun provideResourceProvider(context: Context): IResourceProvider {
        return ResourceProvider(context)
    }

    @Provides
    @Singleton
    fun provideDispatcher(): IDispatcherProvider {
        return DispatcherProvider()
    }

}
