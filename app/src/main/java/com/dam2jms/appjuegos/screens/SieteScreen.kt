package com.dam2jms.appjuegos.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun sieteScreen(navController: NavController) {
    var puntajeJugador by rememberSaveable { mutableStateOf(0.0) }
    var mostrarAlertDialog by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Puntaje del Jugador: $puntajeJugador")

        if (mostrarAlertDialog) {
            AlertDialog(
                text = { Text(text = "Puntaje del Jugador: $puntajeJugador\nEl juego ha terminado.") },
                onDismissRequest = { mostrarAlertDialog = false },
                confirmButton = {
                    TextButton(onClick = {
                        mostrarAlertDialog = false
                        puntajeJugador = 0.0
                    }) {
                        Text(text = "Reiniciar")
                    }
                }
            )
        }

        Button(
            onClick = {
                val carta = obtenerCartaAleatoria()
                puntajeJugador += obtenerValorCarta(carta)

                if (puntajeJugador >= 7.5) {
                    mostrarAlertDialog = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Tomar Carta")
        }
    }
}

//metodo para obtener una carta aleatoria con su valor
fun obtenerCartaAleatoria(): String {
    val cartas = listOf("1", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey")
    return cartas.random()
}

//metodo para obtener el valor de una carta
fun obtenerValorCarta(carta: String): Double {
    return when (carta) {
        "Sota", "Caballo", "Rey" -> 0.5
        else -> carta.toDouble()
    }
}
