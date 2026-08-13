package com.example.ecoeyeapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ecoeyeapp.R
import com.example.ecoeyeapp.viewModel.ServerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenServer(
    serverViewModel: ServerViewModel = viewModel()
){
    val isServerRunning by serverViewModel.isServerRunning
    val ipAddress by serverViewModel.ipAddress
    val port by serverViewModel.port

    Scaffold(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "EcoEye 2",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(
                modifier = Modifier.height(36.dp)
            )

            CardDispositivoCollegato("Magic Leap 2", true && isServerRunning)

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            ServerStatusIndicator(isServerRunning, modifier = Modifier)

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            ServerAddressCard(
                modifier = Modifier,
                ipAddress = ipAddress,
                port = port,
                isServerRunning = isServerRunning
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            Button(
                onClick = {
                    serverViewModel.onServerButtonClick()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(
                    text = if(isServerRunning){
                        "ARRESTA SERVER"
                    }else{
                        "AVVIA SERVER"
                    },
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}

@Composable
fun CardDispositivoCollegato(deviceName: String, connectionStatus: Boolean = false){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = if(connectionStatus){
                "Dispositivo connesso!"
            } else {
                "Nessun Dispositivo connesso"
            },
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Card(
            modifier = Modifier.size(200.dp),
            shape = CircleShape,
            border = BorderStroke(
                width = 5.dp,
                color = MaterialTheme.colorScheme.primary
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            )
        ) {
            if(connectionStatus){
                Image(
                    painter = painterResource(
                        id = R.drawable.magicleap2
                    ),
                    contentDescription = "Dispositivo collegato",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier.fillMaxSize().clip(CircleShape)
                )

                Text(
                    modifier = Modifier.padding(8.dp),
                    text = deviceName,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
@Composable
fun ServerStatusIndicator(
    isServerRunning: Boolean,
    modifier: Modifier
){
    val statusColor = if(isServerRunning){
        Color(0xFF2E7D32)
    }else{
        MaterialTheme.colorScheme.outline
    }

    val statusText = if (isServerRunning) {
        "SERVER ATTIVO"
    } else {
        "SERVER NON ATTIVO"
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .background(
                    color = statusColor,
                    shape = CircleShape
                )
        )

        Spacer(
            modifier = Modifier.width(8.dp)
        )

        Text(
            text = statusText,
            color = statusColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ServerAddressCard(
    ipAddress: String,
    port: Int,
    modifier: Modifier,
    isServerRunning: Boolean
){
    val cardColor = if(isServerRunning){
        MaterialTheme.colorScheme.surface
    }else{
        MaterialTheme.colorScheme.surfaceVariant
    }

    val statusText = if (isServerRunning){
        "Disponibile"
    }else{
        "Non Disponibile"
    }

    val statusColor = if (isServerRunning) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Text(
                text = "INDIRIZZO WEBSOCKET",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "ws://$ipAddress:$port/ws",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = FontFamily.Monospace,
                color = if (isServerRunning) {
                    MaterialTheme.colorScheme.onSurface
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant.copy(
                        alpha = 0.6f
                    )
                }
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = statusText,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = statusColor
            )
        }
    }

}

enum class ServerStatus {
    STOPPED,
    STARTING,
    RUNNING,
    STOPPING,
    ERROR
}

@Preview
@Composable
fun PreviewScreenServer(){
    ScreenServer()
}