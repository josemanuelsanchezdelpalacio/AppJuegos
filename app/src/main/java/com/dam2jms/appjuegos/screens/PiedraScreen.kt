package com.dam2jms.appjuegos.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dam2jms.appjuegos.data.lista
import com.dam2jms.appjuegos.data.listaEleccionPC

@Composable
fun piedraScreen(navController: NavController) {

    var eleccionJugador by rememberSaveable { mutableStateOf("") }

    var eleccionPC by rememberSaveable { mutableStateOf("") }

    var ganador by rememberSaveable { mutableStateOf("") }
    var mostrarAlertDialog by rememberSaveable { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = eleccionJugador,
            onValueChange = { eleccionJugador = it },
            label = { Text(text = "Elije entre piedra, papel o tijeras") },
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        )

        if (mostrarAlertDialog) {
            AlertDialog(
                text = { Text(text = "Yo he sacado $eleccionPC. Gana $ganador") },
                onDismissRequest = { mostrarAlertDialog = false },
                confirmButton = {
                    TextButton(onClick = {
                        mostrarAlertDialog = false
                    }) { Text(text = "OK") }
                })
        }

        Button(
            onClick = {

                eleccionPC = eleccionAleatoriaPC()

                //si es nones y es impar la suma o si es pares y es par la suma muestra el alertdialog con el ganador segun la suma de los numeros
                if (eleccionJugador.equals(eleccionPC)) {
                    mostrarAlertDialog = true
                    ganador = "mos los dos"
                } else if (
                    (eleccionJugador.equals("piedra") && eleccionPC.equals("tijeras")) ||
                    (eleccionJugador.equals("papel") && eleccionPC.equals("piedra")) ||
                    (eleccionJugador.equals("tijeras") && eleccionPC.equals("papel"))
                ) {
                    mostrarAlertDialog = true
                    ganador = "Jugador"
                } else {
                    mostrarAlertDialog = true
                    ganador = "PC"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Text(text = "JUGAR")
        }
    }
}

//metodo que recorre el hashMap y añade a la lista las preguntas. Despues las devuelve de forma aleatoria
fun eleccionAleatoriaPC():String {
    for (pregunta in lista) {
        listaEleccionPC.add(pregunta.key)
    }
    return listaEleccionPC.shuffle().toString()
}