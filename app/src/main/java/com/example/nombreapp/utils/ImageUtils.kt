package com.example.nombreapp.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.FileProvider
import java.io.File

@Composable
fun rememberCameraLauncher(onImageCaptured: (Uri) -> Unit) {
    val context = LocalContext.current
    return remember {
        context.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            result.data?.data?.let { uri -> onImageCaptured(uri) }
        }
    }
}

fun takePictureIntent(context: Context, photoFile: File): Intent {
    val photoURI: Uri = FileProvider.getUriForFile(context, "${context.packageName}.provider", photoFile)
    return Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
        putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
    }
}
