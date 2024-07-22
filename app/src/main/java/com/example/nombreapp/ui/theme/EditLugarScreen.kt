package com.example.nombreapp.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nombreapp.Lugar
import com.example.nombreapp.viewmodel.LugarViewModel

@Composable
fun EditLugarScreen(lugar: Lugar, viewModel: LugarViewModel, onNavigateBack: () -> Unit) {
    var nombre by remember { mutableStateOf(lugar.nombre) }
    var imagenUrl by remember { mutableStateOf(lugar.imagenUrl) }
    var latitud by remember { mutableStateOf(lugar.latitud) }
    var longitud by remember { mutableStateOf(lugar.longitud) }
    var orden by remember { mutableStateOf(lugar.orden) }
    var costoAlojamiento by remember { mutableStateOf(lugar.costoAlojamiento) }
    var costoTraslados by remember { mutableStateOf(lugar.costoTraslados) }
    var comentarios by remember { mutableStateOf(lugar.comentarios) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        TextField(value = imagenUrl, onValueChange = { imagenUrl = it }, label = { Text("URL Imagen") })
        // Agregar campos para latitud, longitud, orden, costoAlojamiento, costoTraslados y comentarios

        Button(onClick = {
            viewModel.update(lugar.copy(
                nombre = nombre,
                imagenUrl = imagenUrl,
                latitud = latitud,
                longitud = longitud,
                orden = orden,
                costoAlojamiento = costoAlojamiento,
                costoTraslados = costoTraslados,
                comentarios = comentarios
            ))
            onNavigateBack()
        }) {
            Text("Guardar Cambios")
        }
    }
}
