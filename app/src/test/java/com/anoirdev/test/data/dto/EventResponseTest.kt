package com.anoirdev.test.data.dto

import com.anoirdev.test.data.source.remote.dto.event.Event
import com.anoirdev.test.data.source.remote.dto.event.EventsDto
import com.anoirdev.test.data.source.remote.dto.event.Team
import org.junit.Assert
import org.junit.Test

class EventResponseTest {
    @Test
    fun `should use the right strings for serialized attributes`() {
        Assert.assertEquals("events", EventsDto.TAG_EVENTS)
        Assert.assertEquals("time", Event.TAG_LEFT_TEAM)
        Assert.assertEquals("time", Event.TAG_RIGHT_TEAM)
        Assert.assertEquals("time", Event.TAG_TIME)
        Assert.assertEquals("date", Event.TAG_DATE)
        Assert.assertEquals("name", Team.TAG_NAME)
        Assert.assertEquals("score", Team.TAG_SCORE)
    }
}