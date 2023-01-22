package com.anoir.noteanoir.data.source.mappers

import com.anoir.noteanoir.builder.BuilderEvent.Companion.BUILD_EVENT_ENTITY
import com.anoir.noteanoir.builder.BuilderEvent.Companion.BUILD_EVENT_MODEL
import junitparams.JUnitParamsRunner
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(JUnitParamsRunner::class)
class ToDomainTest {

    @Test
    fun `should map EventEntity to EventModel`() {
        val result = BUILD_EVENT_ENTITY.toModel()
        assertEquals(
            BUILD_EVENT_MODEL, result
        )
    }


}