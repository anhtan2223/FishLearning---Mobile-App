package com.example.fish

import android.app.Activity
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.example.fish.Untils.InitValue
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.downloadPDF
import com.example.fish.Untils.selectPDF
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

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
        Row {
            Button(onClick = { InitValue.resetClass() }) { Text(text = "Reset Class ") }
            Button(onClick = { InitValue.addListClass()}) { Text(text = "Init Class") }
        }

        Button(onClick = {
//            appendMessage(context , "Test Function")
//            getContent.launch("application/pdf")
            downloadPDF(context , "https://firebasestorage.googleapis.com/v0/b/fishlearning-ce8e9.appspot.com/o/pdf%2Fb59d35f7-44ea-4809-b189-880d29853eac.pdf?alt=media&token=30aab310-aaaf-479e-ba4e-0ad2a389f8d2")

        }) {
            Text(text = "Test Function")
        }
    }
}

//fun main(){
//    val strDate = "20/2/2003"
//    val date = Date()
//    println(dateToString(date))
//}