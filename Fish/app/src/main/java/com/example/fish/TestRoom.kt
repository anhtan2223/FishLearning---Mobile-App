package com.example.fish

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.example.fish.Controllers.getDetailTest
import com.example.fish.Untils.DetailResult
import com.example.fish.Untils.InitValue
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.runDispatcherDefault

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

            val detail : MutableList<DetailResult> = getDetailTest("13")
            Log.d(TAG, "TestRoom: $detail")
            appendMessage(context , detail.toString())

        }) {
            Text(text = "Test Function")
        }
        var content by remember {
            mutableStateOf("Hello")
        }
        runDispatcherDefault {
            content = getDetailTest("13").toString()
        }

        Text(text = content)
    }
}
//fun main(){
//    val strDate = "20/2/2003"
//    val date = Date()
//    println(dateToString(date))
//}