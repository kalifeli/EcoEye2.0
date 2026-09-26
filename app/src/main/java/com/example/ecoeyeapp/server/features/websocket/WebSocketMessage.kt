package com.example.ecoeyeapp.server.features.websocket

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

enum class MessageType{
    @SerialName("ping")
    PING,

    @SerialName("pong")
    PONG,

    @SerialName("audio_start")
    AUDIO_START,

    @SerialName("audio_end")
    AUDIO_END,

    @SerialName("ack")
    ACK,

    @SerialName("error")
    ERROR
}

@Serializable
data class WebSocketMessage(
    val type: MessageType,
    val content: String
)