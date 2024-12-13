package com.example.textrecognition.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.textrecognition.util.TranslationClient
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun TextRecognitionScreen() {
    val cameraPermissionState: PermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)
    val context = LocalContext.current

    MainContent(
        hasPermission = cameraPermissionState.status.isGranted,
        onRequestPermission = cameraPermissionState::launchPermissionRequest
    )

    LaunchedEffect(Unit) {
        downloadTranslationModel(context)
    }
}

private fun downloadTranslationModel(context: Context) {
    TranslationClient.translator.downloadModelIfNeeded()
        .addOnSuccessListener {
            // Model downloaded successfully. You can now translate text.
            Toast.makeText(context, "Model downloaded successfully", Toast.LENGTH_SHORT).show()
        }
        .addOnFailureListener { exception ->
            // Model download failed. Handle the error appropriately.
            exception.printStackTrace()
            Toast.makeText(context, "Model download failed", Toast.LENGTH_SHORT).show()
        }
}

@Composable
private fun MainContent(
    hasPermission: Boolean,
    onRequestPermission: () -> Unit
) {
    if (hasPermission) {
        CameraScreen()
    } else {
        NoPermissionScreen(onRequestPermission)
    }
}

@Preview
@Composable
private fun Preview_MainContent() {
    MainContent(
        hasPermission = true,
        onRequestPermission = {}
    )
}