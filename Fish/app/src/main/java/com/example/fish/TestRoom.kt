package com.example.fish

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.example.fish.Models.HandleTopic
import com.example.fish.Untils.DemoData
import com.example.fish.Untils.Document
import com.example.fish.Untils.InitValue
import com.example.fish.Untils.ItemTopic
import com.example.fish.Untils.Test
import com.example.fish.Untils.TextBox
import com.example.fish.Untils.Topic
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.getTopic
import com.google.firebase.database.getValue

@Composable
fun TestRoom(){
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
            HandleTopic.getTopicOfClass("1"){
                Log.d(TAG, "TestRoom() returned: $it")
            }
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