package com.example.fish

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.fish.Database.DemoData
import com.example.fish.Database.MyDB
import com.example.fish.Database.User
import com.example.fish.Service.HandleUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.database.values
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.runBlocking

@Composable
fun TestRoom(){
    val user = MyDB.user

    Column(
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(onClick = {
            user.removeValue()
        }) {
            Text(text = "Clear Database")
        }
        Button(onClick = {
            HandleUser.createUser(DemoData.UserInfo)
        }) {
            Text(text = "Push One User")
        }

        Button(onClick = {
            HandleUser.createUser(DemoData.UserInfo2)
        }) {
            Text(text = "Update User")
        }

        var userInfo by remember {
            mutableStateOf(User())
        }
        var message by remember {
            mutableStateOf("Init State")
        }

        Button(onClick = {
            user.child("-NwjasNl0KI-awo2G-_r").addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val info = snapshot.getValue<User>()
                    if (info != null) {
                        userInfo = info
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    message = "Get value Cancel"
                }
            })
        }) {
            Text(text="Add Listener Get UserInfo")
        }
        Button(onClick = {
            HandleUser.getUserById("-NwjasNl0KI-awo2G-_r"){
               message = it.toString()
            }
        }) {
            Text(text = "Get Data By Default")
        }
        Text(text = userInfo.toString())
        Text(text = message)
    }

}