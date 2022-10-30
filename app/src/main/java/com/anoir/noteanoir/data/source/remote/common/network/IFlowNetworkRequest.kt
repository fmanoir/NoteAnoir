package com.anoir.noteanoir.data.source.remote.common.network

import com.anoir.noteanoir.data.source.remote.common.error.IApiErrorHandler
import com.anoir.noteanoir.utlis.sealed.ErrorFailure
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import retrofit2.Response

private typealias NetworkAPIInvoke<T> = suspend () -> Response<T>

interface IFlowNetworkRequest {
    @ExperimentalCoroutinesApi
    fun <T : Any> safeCall(
        internetStatusInterface: InternetStatusInterface,
        apiErrorHandler: IApiErrorHandler,
        networkApiCall: NetworkAPIInvoke<T>,
    ): Flow<Resource<T>> {
        return flow {

            val internetStatus = internetStatusInterface.ping().single()
            if (internetStatus == InternetStatusType.NO_INTERNET) {
                emit(Resource.OnFailed(ErrorFailure.Connection.Unavailable))
                return@flow
            }

            val response = networkApiCall()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.OnSuccess(it))
                }?:emit(Resource.OnFailed(ErrorFailure.Connection.NoBody))
                return@flow
            }
            emit(Resource.OnFailed(ErrorFailure.Connection.NoBody))
            return@flow
        }.catch { e ->
            emit(Resource.OnFailed(apiErrorHandler.getError(e)))
            return@catch
        }
    }
}