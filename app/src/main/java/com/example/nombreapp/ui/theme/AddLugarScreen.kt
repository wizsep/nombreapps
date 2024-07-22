package com.example.nombreapp.ui.theme

import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.nombreapp.Lugar
import com.example.nombreapp.viewmodel.LugarViewModel

@Composable
fun AddLugarScreen(viewModel: LugarViewModel, onNavigateBack: () -> Unit) {
    val context = LocalContext.current
    var nombre by remember { mutableStateOf("") }
    var imagenUrl by remember { mutableStateOf("") }
    var latitud by remember { mutableStateOf(0.0) }
    var longitud by remember { mutableStateOf(0.0) }
    var orden by remember { mutableStateOf(0) }
    var costoAlojamiento by remember { mutableStateOf(0) }
    var costoTraslados by remember { mutableStateOf(0) }
    var comentarios by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        TextField(value = imagenUrl, onValueChange = { imagenUrl = it }, label = { Text("URL Imagen") })
        // Agregar campos para latitud, longitud, orden, costoAlojamiento, costoTraslados y comentarios

        Button(onClick = {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf(Manifest.permission.CAMERA),
                    REQUEST_IMAGE_CAPTURE
                )
            } else {
                // Guardar lugar en la base de datos
                viewModel.insert(Lugar(
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
            }
        }) {
            Text("Guardar")
        }
    }
}
