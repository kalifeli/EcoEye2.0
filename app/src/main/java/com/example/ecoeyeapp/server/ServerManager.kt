package com.example.ecoeyeapp.server

import io.ktor.server.application.Application
import io.ktor.server.engine.EmbeddedServer
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine

class ServerManager {
    private var server: EmbeddedServer<NettyApplicationEngine, NettyApplicationEngine.Configuration>? = null



    fun startServer(){
        if(server != null){
            return
        }
        server = embeddedServer(
            factory = Netty,
            port = 8080,
            host = "0.0.0.0",
            module = Application::serverModule
        )

        server?.start(wait = false)
    }

    fun closeServer(){
        server?.stop()
        server = null
    }
}