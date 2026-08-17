package com.example.ecoeyeapp.server

import com.example.ecoeyeapp.server.features.websocket.webSocketModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.server.websocket.WebSockets

fun Application.serverModule(){
    install(WebSockets)

    routing {

        get("/"){
            call.respondText {"EcoEye is running!"}
        }
    }

    webSocketModule()
}