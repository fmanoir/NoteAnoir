package com.anoir.noteanoir.data.source.mappers

import com.anoir.noteanoir.builder.BuilderEvent.Companion.BUILD_EVENT_DTO
import com.anoir.noteanoir.builder.BuilderEvent.Companion.BUILD_EVENT_ENTITY
import org.junit.Assert
import org.junit.Test

class DtoToEntityTest {

    @Test
    fun `should map EventsDto to EventEntity`() {
        val result = BUILD_EVENT_DTO.events[0].toEntity()
        Assert.assertEquals(
            BUILD_EVENT_ENTITY, result
        )
    }


}