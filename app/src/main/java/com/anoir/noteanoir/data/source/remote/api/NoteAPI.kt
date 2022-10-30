package com.anoir.noteanoir.data.source.remote.api

import com.anoir.noteanoir.data.source.remote.dto.NoteDto
import retrofit2.Response
import retrofit2.http.GET

/*
All API
 */

interface NoteAPI {

    @GET(GET_ALL_NOTE)
    suspend fun getAllNote(): Response<List<NoteDto>>

    companion object {
        const val GET_ALL_NOTE = "technical-test.json"
    }
}