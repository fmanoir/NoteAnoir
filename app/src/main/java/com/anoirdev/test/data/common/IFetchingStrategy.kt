package com.anoirdev.test.data.common

import com.anoirdev.test.utlis.sealed.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

interface IFetchingStrategy {
    /**
     *
     * @param fetchFromLocal représente la fonction qui renvoit les
     *     données depuis la base de données sous forme de flow
     * @param shouldFetchFromRemote représente la fonction qui détermine
     *     s'il est nécessaire de récupérer les données du WebService
     * @param fetchFromRemote représente la fonction qui récupère
     *     les données depuis le WebService sous forme de flow
     * @param saveRemoteData représente la fonction qui sauvegardera
     *     les données récupérées du WebService dans la base locale
     */
    @ExperimentalCoroutinesApi
    fun <DB : Any, REMOTE : Any> fetching(
        shouldFetchFromRemote: suspend () -> Flow<Boolean>,
        fetchFromLocal: suspend () -> Flow<DB>,
        fetchFromRemote: (suspend () -> Flow<Resource<REMOTE>>)? = null,
        saveRemoteData: (suspend (REMOTE) -> Unit)? = null,
    ): Flow<Resource<DB>> = flow {
        shouldFetchFromRemote().collect { shouldFetch ->

            if (shouldFetch && fetchFromRemote != null && saveRemoteData != null) {
                fetchFromRemote().collect { remoteData ->
                    when (remoteData) {
                        is Resource.OnSuccess -> {
                            saveRemoteData(remoteData.data)
                            emitAll(fetchFromLocal().map { dbData ->
                                Resource.OnSuccess(dbData)
                            })
                        }
                        is Resource.OnFailed -> {
                            emit(Resource.OnFailed(remoteData.failure))
                            emitAll(fetchFromLocal().map { dbData ->
                                Resource.OnSuccess(dbData)
                            })
                        }
                    }
                }
            } else {
                emitAll(fetchFromLocal().map { Resource.OnSuccess(it) })
            }
        }
    }
}
