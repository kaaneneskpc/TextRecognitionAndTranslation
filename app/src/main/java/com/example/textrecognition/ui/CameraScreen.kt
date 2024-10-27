package com.example.textrecognition.ui

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.camera.core.AspectRatio
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions

@Composable
fun CameraScreen() {
    CameraContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CameraContent() {

    val context: Context = LocalContext.current
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val cameraController: LifecycleCameraController =
        remember { LifecycleCameraController(context) }
    var detectedText: String by remember { mutableStateOf("No text detected yet..") }
    var showTranslationDialog by remember { mutableStateOf(false) }
    var translatedText by remember { mutableStateOf("") }
    var showTranslatedTextDialog by remember { mutableStateOf(false) }

    fun onTextUpdated(updatedText: String) {
        detectedText = updatedText
    }

    if (showTranslatedTextDialog) {
        AlertDialog(
            onDismissRequest = { showTranslatedTextDialog = false },
            title = { Text("Translated Text") },
            text = { Text(translatedText) },
            confirmButton = {
                Button(onClick = { showTranslatedTextDialog = false }) {
                    Text("OK")
                }
            }
        )
    }

    if (showTranslationDialog) {
        //Translate the text to Turkish Create Dialog
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text("Text Scanner") }, actions = {
                IconButton(onClick = { showTranslationDialog = true }) {
                    Icon(Icons.Filled.Translate, contentDescription = "Translate")
                }
            })
        },
    ) { paddingValues: PaddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = androidx.compose.ui.Alignment.BottomCenter
        ) {
            //Update Screen Views
        }
    }
}

private fun translateText(text: String, callback: (String) -> Unit) {
    //"Translate the text to Turkish"
}

private fun startTextRecognition(
) {
    //"Start text recognition"
}