package com.example.ecoeyeapp.server

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import java.nio.file.Paths.get

class ServerManager {

    private val server = embeddedServer(
        factory = Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::serverModule
    )

    fun startServer(){
        server.start(wait = false)
    }

    fun closeServer(){
        server.stop()
    }
}