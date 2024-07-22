package com.example.nombreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nombreapp.ui.theme.ListaLugaresScreen
import com.example.nombreapp.viewmodel.LugarViewModel

class MainActivity : ComponentActivity() {
    private val lugarViewModel: LugarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ListaLugaresScreen(viewModel = lugarViewModel)
            }
        }
    }
}