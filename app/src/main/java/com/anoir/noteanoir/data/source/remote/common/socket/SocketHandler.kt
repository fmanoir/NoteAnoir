package com.anoir.noteanoir.data.source.remote.common.socket

import java.net.Socket
import javax.net.SocketFactory

/**
 * Il est utile de créer une interface pour la socket sinon
 * les tests yunitaires auront du mal à mocker le createSocket.
 * Ne surtout pas faire le createSocket dans le DI autrement la détection
 * de la perte de la connexion ne sera pas vraiment fonctionnelle car le socket sera close au prochain appel.
 * Je suppose que c'est parce que le socket est unique à travers l'application quand on le fait dans le module NetworkModule.
 */

class SocketHandler : ISocket {
    override fun getSocket(socketFactory: SocketFactory): Socket {
        return socketFactory.createSocket()
    }
}