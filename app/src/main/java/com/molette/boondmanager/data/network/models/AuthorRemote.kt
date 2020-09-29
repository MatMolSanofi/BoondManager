package com.molette.boondmanager.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AuthorRemote(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("type")
    val type: String,
    @SerialName("photo")
    val photo: String
) {
}