package com.example.ecoeyeClientSimulator.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.withContext

suspend fun captureAudio(out: SendChannel<ByteArray>) = withContext(Dispatchers.IO){

}