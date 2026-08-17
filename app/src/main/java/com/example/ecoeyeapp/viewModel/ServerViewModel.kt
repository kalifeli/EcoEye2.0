package com.example.ecoeyeapp.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecoeyeapp.server.ServerManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServerViewModel : ViewModel() {

    private val serverManager = ServerManager()
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
        viewModelScope.launch(Dispatchers.IO){
            if(_isServerRunning.value){
                serverManager.closeServer()
                _isServerRunning.value = false
            }else{
                serverManager.startServer()
                _isServerRunning.value = true
            }
        }
    }
}

