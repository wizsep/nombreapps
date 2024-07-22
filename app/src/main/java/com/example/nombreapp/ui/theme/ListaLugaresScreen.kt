package com.example.nombreapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.nombreapp.Lugar
import com.example.nombreapp.viewmodel.LugarViewModel

@Composable
fun ListaLugaresScreen(viewModel: LugarViewModel) {
    val lugares by viewModel.lugares.observeAsState(emptyList())

    Scaffold(
        topBar = { TopAppBar(title = { Text("App Vacaciones") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Navegar a pantalla de agregar lugar */ }) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        LazyColumn {
            items(lugares) { lugar ->
                LugarItem(lugar)
            }
        }
    }
}

@Composable
fun LugarItem(lugar: Lugar) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column {
            Image(
                painter = rememberImagePainter(lugar.imagenUrl),
                contentDescription = null,
                modifier = Modifier.height(180.dp).fillMaxWidth()
            )
            Text(lugar.nombre, style = MaterialTheme.typography.h6)
            Text("Costo x Noche: ${lugar.costoAlojamiento} CLP")
            Text("Traslado: ${lugar.costoTraslados} CLP")
        }
    }
}