package com.cyrex.animationswithrecyclerview

import com.google.gson.annotations.SerializedName

data class Beer(
    val id: Int,
    val name: String,
    @SerializedName("tagline")
    val tagLine: String
)