package com.anoir.noteanoir.data.source.remote.common.socket

import java.net.Socket
import javax.net.SocketFactory

interface ISocket {
    fun getSocket(socketFactory: SocketFactory): Socket
}
