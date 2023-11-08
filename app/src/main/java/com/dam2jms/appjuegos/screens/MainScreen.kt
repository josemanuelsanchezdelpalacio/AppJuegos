package com.dam2jms.appjuegos.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dam2jms.appjuegos.R
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
                image = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Nones"
            )
            SquareButton(
                onClick = { navController.navigate(route = AppScreens.PiedraScreen.route) },
                image = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Piedra, papel y tijeras"
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            SquareButton(
                onClick = { navController.navigate(route = AppScreens.SieteScreen.route) },
                image = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Siete y medio"
            )
            SquareButton(
                onClick = { navController.navigate(route = AppScreens.NonesScreen.route) },
                image = painterResource(R.drawable.ic_launcher_background),
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
        modifier = Modifier.size(100.dp)
    ) {
        Icon(
            painter = image,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize()
        )
    }
}