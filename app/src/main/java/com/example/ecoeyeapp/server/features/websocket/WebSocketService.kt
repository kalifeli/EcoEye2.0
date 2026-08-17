package com.example.ecoeyeapp.server.features.websocket

import io.ktor.server.websocket.DefaultWebSocketServerSession
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import io.ktor.websocket.send

class WebSocketService {

    suspend fun handleConnection(
        session: DefaultWebSocketServerSession
    ){
        println("Client WebSocket connected")

        try {
            for(frame in session.incoming) {
                if(frame is Frame.Text){
                    val message = frame.readText()
                    println("Messaggio ricevuto: $message")
                    session.send(message)
                }
            }
        }finally {
            println("Client WebSocket disconnected")
        }
    }
}