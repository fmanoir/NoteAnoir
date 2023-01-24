package com.anoirdev.test.presentation.di

import com.anoirdev.test.presentation.event.adapter.EventAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ActivityAdapterModule {

    @Provides
    fun providePriceAdapter(): EventAdapter {
        return EventAdapter()
    }

}