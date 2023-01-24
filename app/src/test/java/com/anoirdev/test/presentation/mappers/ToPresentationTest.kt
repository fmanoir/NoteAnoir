package com.anoirdev.test.presentation.mappers

import com.anoirdev.test.builder.BuilderEvent.Companion.BUILD_EVENT_MODEL
import com.anoirdev.test.builder.BuilderEvent.Companion.BUILD_EVENT_PRESENTATION
import junitparams.JUnitParamsRunner
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(JUnitParamsRunner::class)
class ToPresentationTest {

    @Test
    fun `should map EventEntity to EventModel`() {
        val result = BUILD_EVENT_MODEL.toPresentation()
        assertEquals(
            BUILD_EVENT_PRESENTATION, result
        )
    }


}