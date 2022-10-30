package com.anoir.noteanoir.data.source.remote.common.network


import com.anoir.noteanoir.data.source.remote.common.socket.ISocket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.net.InetSocketAddress
import javax.inject.Inject
import javax.net.SocketFactory

/*
Internet Reachability via Socket
 */

class InternetStatus @Inject constructor(
    private val socketFactory: SocketFactory,
    private val socketAddress: InetSocketAddress,
    private val timeOut: Int,
    private val socket: ISocket
) : InternetStatusInterface {
    override fun ping(): Flow<InternetStatusType> {
        return flow {
            socket.getSocket(socketFactory).apply {
                connect(socketAddress, timeOut)
                close()
            }
            emit(InternetStatusType.INTERNET)
        }.catch {
            emit(InternetStatusType.NO_INTERNET)
        }
    }
}
