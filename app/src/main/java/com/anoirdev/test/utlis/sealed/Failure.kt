package com.anoirdev.test.utlis.sealed

sealed class Failure {
    sealed class Connection {
        /** When no network connection */
        object Unavailable : Failure()
        object NoBody : Failure()

        /** Any other server problem */
        object TryLater : Failure()
    }
}