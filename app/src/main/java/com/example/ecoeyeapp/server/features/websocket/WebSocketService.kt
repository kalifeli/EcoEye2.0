package com.example.ecoeyeapp.server.features.websocket

import io.ktor.server.websocket.DefaultWebSocketServerSession
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import io.ktor.websocket.send
import kotlinx.serialization.json.Json

class WebSocketService {

    suspend fun handleConnection(
        session: DefaultWebSocketServerSession
    ){
        println("Client WebSocket connected")

        try {
            for(frame in session.incoming) {
                when(frame){
                    is Frame.Text -> {
                            val jsonString = frame.readText()
                            val message = try {
                                Json.decodeFromString<WebSocketMessage>(jsonString)
                            } catch (e: Exception){
                                val erroreMessage = WebSocketMessage(
                                    type = MessageType.ERROR,
                                    content = "Formato del messaggio non valido"
                                )
                                session.send(Json.encodeToString(erroreMessage))

                                continue
                            }

                            println("Message Type: ${message.type}")
                            println("Message Content: ${message.content}")


                            val returnMessage = when(message.type){
                                MessageType.PING -> {
                                    WebSocketMessage(
                                        type = MessageType.PONG,
                                        content = message.content
                                    )
                                }

                                MessageType.AUDIO_START -> {
                                    WebSocketMessage(
                                        type = MessageType.ACK,
                                        content = message.content
                                    )
                                }

                                MessageType.PONG -> TODO()
                                MessageType.AUDIO_END -> TODO()
                                MessageType.ACK -> TODO()
                                MessageType.ERROR -> TODO()
                            }

                            val jsonReturnMessage = Json.encodeToString(returnMessage)
                            println(returnMessage)
                            session.send(jsonReturnMessage)
                    }
                    is Frame.Binary -> {

                        val audio = frame.data

                        println("Audio ricevuto!")
                        println("Dimensione audio: ${audio.size}")
                    }

                    else -> {
                        println("Si è verificato un errore!")
                    }
                }
            }
        }finally {
            println("Client WebSocket disconnected")
        }
    }
}