package com.example.ecoeyeapp

import com.example.ecoeyeapp.server.features.websocket.WebSocketMessage
import kotlinx.serialization.json.Json
import org.junit.Test

class SerializationTest {

    @Test
    fun testSerialization(){
        val message = WebSocketMessage(
            type = "ping",
            content = "ciao"
        )

        val jsonString = Json.encodeToString(message)
        println(jsonString)

        val decodeMessage = Json.decodeFromString<WebSocketMessage>(jsonString)

        println("TYPE: ${decodeMessage.type}")
        println("TYPE: ${decodeMessage.content}")
    }
}