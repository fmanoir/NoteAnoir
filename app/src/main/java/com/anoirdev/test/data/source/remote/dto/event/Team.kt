package com.anoirdev.test.data.source.remote.dto.event

import com.google.gson.annotations.SerializedName


data class Team(
    @SerializedName(TAG_NAME)
    val name: String,
    @SerializedName(TAG_SCORE)
    val score: Int
) {
    companion object {
        const val TAG_NAME = "name"
        const val TAG_SCORE = "score"
    }
}