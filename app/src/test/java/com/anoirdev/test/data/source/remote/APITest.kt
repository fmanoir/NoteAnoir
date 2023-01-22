package com.anoirdev.test.data.source.remote

import com.anoirdev.test.data.source.remote.api.EventAPI
import org.junit.Assert
import org.junit.Test

class APITest {
    @Test
    fun `should define the right paths for endpoints`() {
        Assert.assertEquals("events", EventAPI.GET_EVENTS)
    }
}