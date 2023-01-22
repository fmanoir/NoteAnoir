package com.anoirdev.test.utlis.extensions


/**
 * property TAG extension for Logging
 *
 */
val Any.TAG: String
    get() {
        val tag = javaClass.simpleName
        return if (tag.length <= 23) tag else tag.substring(0, 22)
    }