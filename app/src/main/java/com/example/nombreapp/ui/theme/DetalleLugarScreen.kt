package com.example.nombreapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.rememberImagePainter
import com.example.nombreapp.Lugar
import com.example.nombreapp.viewmodel.LugarViewModel
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

@Composable
fun DetalleLugarScreen(lugar: Lugar, viewModel: LugarViewModel) {
    Column {
        Image(
            painter = rememberImagePainter(lugar.imagenUrl),
            contentDescription = null,
            modifier = Modifier.height(200.dp).fillMaxWidth()
        )
        Text(lugar.nombre, style = MaterialTheme.typography.h4)
        Text("Costo x Noche: ${lugar.costoAlojamiento} CLP")
        Text("Traslado: ${lugar.costoTraslados} CLP")
        Text("Comentarios: ${lugar.comentarios}")

        Button(onClick = { /* Navegar a pantalla de edición */ }) {
            Icon(Icons.Default.Edit, contentDescription = null)
            Text("Editar")