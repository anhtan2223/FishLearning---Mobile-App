package com.example.fish

import android.app.Activity
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.fish.Untils.InitValue
import com.example.fish.Untils.RecognizeTextIcon

@Composable
fun TestRoom(activity: Activity, getContent: ActivityResultLauncher<String>){
    var context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row {
            Button(onClick = { InitValue.resetAll() }) { Text(text = "Reset Firebase ") }
            Button(onClick = { InitValue.initFirebase()  }) { Text(text = "Init Firebase") }
        }

        var uri by remember {
            mutableStateOf<Uri>(Uri.EMPTY)
        }
        var content by remember {
            mutableStateOf("Uri.EMPTY")
        }

        Button(onClick = {

        }) {
            Text(text = "Test Function")
        }
        RecognizeTextIcon{
            content = it
        }
        Text(text = "Test Recognize : $content")
        AsyncImage(model = uri, contentDescription = null , modifier = Modifier.size(100.dp))
    }
}
