package com.example.ecoeyeapp.server

import io.ktor.server.application.Application
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.serverModule(){

    routing {

        get("/"){
            call.respondText {"EcoEye is running!"}
        }
    }
}