package com.anoirdev.test.presentation.base

import androidx.annotation.CallSuper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anoirdev.test.utlis.dispatcher.IDispatcherProvider
import com.anoirdev.test.utlis.resource.IResourceProvider
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule

@ExperimentalCoroutinesApi
abstract class BaseTestViewModel {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @MockK
    lateinit var dispatcherProvider: IDispatcherProvider

    @RelaxedMockK
    lateinit var resources: IResourceProvider


    protected lateinit var baseViewModel: BaseViewModel

    @Before
    @CallSuper
    open fun setUp() {
        MockKAnnotations.init(this)
        every { dispatcherProvider.io } returns coroutineRule.dispatcher
    }


}