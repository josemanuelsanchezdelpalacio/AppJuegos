package com.dam2jms.appjuegos.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dam2jms.appjuegos.navigation.AppScreens

@Composable
fun mainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            SquareButton(
                onClick = { navController.navigate(route = AppScreens.NonesScreen.route) },
                image = painterResource(R.drawable.nones_image), // Reemplaza con tu propia imagen
                contentDescription = "Nones"
            )
            SquareButton(
                onClick = { navController.navigate(route = AppScreens.PiedraScreen.route) },
                image = painterResource(R.drawable.piedra_image), // Reemplaza con tu propia imagen
                contentDescription = "Piedra, papel y tijeras"
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            SquareButton(
                onClick = { navController.navigate(route = AppScreens.SieteScreen.route) },
                image = painterResource(R.drawable.siete_image), // Reemplaza con tu propia imagen
                contentDescription = "Siete y medio"
            )
            SquareButton(
                onClick = { navController.navigate(route = AppScreens.NonesScreen.route) },
                image = painterResource(R.drawable.empty_image), // Reemplaza con tu propia imagen o usa una imagen transparente
                contentDescription = ""
            )
        }
    }
}

@Composable
fun SquareButton(
    onClick: () -> Unit,
    image: Painter,
    contentDescription: String
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(100.dp) // Ajusta el tamaño cuadrado aquí
    ) {
        Icon(
            painter = image,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize()
        )
    }
}