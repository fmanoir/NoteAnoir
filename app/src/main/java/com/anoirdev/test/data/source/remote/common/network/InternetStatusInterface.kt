package com.anoirdev.test.data.source.remote.common.network

import kotlinx.coroutines.flow.Flow

interface InternetStatusInterface {
    /**
     * You shouldn't use native Android framework method "ConnectivityManager.getActiveNetworkInfo()
     * to check internet availability. It only verifies if a network connection has been made,
     * but does not check that device is connected to the internet.
     */
    fun ping(): Flow<InternetStatusType>
}

