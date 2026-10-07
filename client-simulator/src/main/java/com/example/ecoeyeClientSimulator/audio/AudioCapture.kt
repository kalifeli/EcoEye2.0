package com.example.ecoeyeClientSimulator.audio

import javax.sound.sampled.AudioSystem
import javax.sound.sampled.DataLine
import javax.sound.sampled.TargetDataLine

class AudioCapture {

    private var microphone: TargetDataLine? = null

    fun start(){

        val lineInfo = DataLine.Info(
            TargetDataLine::class.java,
            AUDIO_FORMAT
        )

        val line = AudioSystem.getLine(lineInfo) as TargetDataLine
        line.open()
        line.start() // permette alla linea di acquisera dati di I/O

        microphone = line

        println("Acquisizione audio iniziata!")
    }

    fun readChunk(): ByteArray {
        val line = microphone ?: error("L'acquisizione audio non è iniziata")

        val chunk = ByteArray(CHUNK_BYTES)

        var totalBytesRead = 0

        while(totalBytesRead < CHUNK_BYTES) {
            val bytesRead = line.read(
                chunk, // Array di destinazione
                totalBytesRead, // offset
                CHUNK_BYTES - totalBytesRead
            )

            totalBytesRead += bytesRead
        }

        return chunk

    }

    fun stop(){
        microphone?.stop() //arresta l'acquisizione
        microphone?.close() // libera le risorse del sistema audio
        microphone = null
    }
}