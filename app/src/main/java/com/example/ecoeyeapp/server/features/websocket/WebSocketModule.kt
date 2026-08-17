package com.example.ecoeyeapp.server.features.websocket

import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import io.ktor.server.websocket.webSocket


fun Application.webSocketModule(){

    val webSocketService = WebSocketService()
    routing {
        webSocket("/ws") {

            webSocketService.handleConnection(this)

        }
    }
}