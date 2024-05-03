package com.example.fish

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.fish.Controllers.getUserList
import com.example.fish.Untils.InitValue
import com.example.fish.Untils.MyDB
import com.example.fish.Untils.dateToString
import com.example.fish.Untils.stringToDate
import java.util.Date

@Composable
fun TestRoom(){
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
            getUserList {
                for(i in it)
                    Log.d(TAG, "TestRoom: ${i}")
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