package com.molette.boondmanager.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Page<T>(
    @SerialName("data")
    val data: List<T>
) {
}