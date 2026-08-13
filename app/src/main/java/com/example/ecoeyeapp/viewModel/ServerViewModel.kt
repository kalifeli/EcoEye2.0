package com.example.ecoeyeapp.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME

class ServerViewModel(): ViewModel() {
    private val _isServerRunning = mutableStateOf(false)

    private val _ipAddress = mutableStateOf("198.168.1.20")

    private val _port = mutableStateOf(8080)

    val isServerRunning: State<Boolean>
        get() = _isServerRunning

    val ipAddress: State<String>
        get() = _ipAddress

    val port: State<Int>
        get() = _port

    fun onServerButtonClick() {
        _isServerRunning.value = !_isServerRunning.value
    }
}