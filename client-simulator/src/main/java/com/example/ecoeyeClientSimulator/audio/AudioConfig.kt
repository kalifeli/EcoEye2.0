package com.example.ecoeyeClientSimulator.audio

import javax.sound.sampled.AudioFormat

const val SAMPLE_RATE = 16_000f // frequenza di campionamento
const val SAMPLE_RATE_BITS = 16
const val CHANNELS = 1
const val CHUNK_DURATION_MS = 100 // duranta di un chunk in ms
const val BYTES_PER_SAMPLE = SAMPLE_RATE_BITS / 8
const val CHUNK_BYTES = (16_000 * BYTES_PER_SAMPLE * CHANNELS * CHUNK_DURATION_MS) / 1000

val AUDIO_FORMAT = AudioFormat(
    SAMPLE_RATE,
    SAMPLE_RATE_BITS, // bit per campione
    CHANNELS, // canali: mono
    true, // campioni con segno
    false // endianess -> little endian
)