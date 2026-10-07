package com.example.ecoeyeClientSimulator

import com.example.ecoeyeClientSimulator.audio.AudioCapture

fun main(){
    println("EcoEye Client Simulator is running! ")

    val audioCapture = AudioCapture()

    try {
        audioCapture.start()
        repeat(20){index ->
            val chunk = audioCapture.readChunk()
            println("Chunk ${index + 1}: ${chunk.size} bytes")
        }
    }finally {
        audioCapture.stop()
    }
}