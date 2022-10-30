package com.anoir.noteanoir.data.source.remote.service

import com.anoir.noteanoir.data.repositories.note.INoteService
import com.anoir.noteanoir.data.source.remote.api.NoteAPI
import com.anoir.noteanoir.data.source.remote.common.error.IApiErrorHandler
import com.anoir.noteanoir.data.source.remote.common.network.InternetStatusInterface
import com.anoir.noteanoir.data.source.remote.dto.NoteDto
import com.anoir.noteanoir.utlis.sealed.Resource
import com.anoir.noteanoir.data.source.remote.common.network.IFlowNetworkRequest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*
Service entre API and Repository
 */

class NoteService @Inject constructor(
    private val noteAPI: NoteAPI,
    private val apiErrorHandler: IApiErrorHandler,
    private val internetStatusInterface: InternetStatusInterface
) : INoteService, IFlowNetworkRequest {

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getAllNote(): Flow<Resource<List<NoteDto>>> {
        return safeCall(
            internetStatusInterface = internetStatusInterface,
            apiErrorHandler = apiErrorHandler
        ) {
            noteAPI.getAllNote()
        }
    }


}