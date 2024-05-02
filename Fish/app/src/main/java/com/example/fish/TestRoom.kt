package com.example.fish

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
import com.example.fish.Untils.DemoData
import com.example.fish.Untils.MyDB
import com.example.fish.Untils.User
import com.example.fish.Models.HandleUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

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
            HandleUser.createUser(DemoData.UserInfo.copy(roleid = 1 , username = "admin" , password = "123"))
        }) {
            Text(text = "Push One Admin")
        }

        Button(onClick = {
            HandleUser.createUser(DemoData.UserInfo2.copy(roleid = 2 , username = "teacher" , password = "123"))
        }) {
            Text(text = "Push One Teacher")
        }

        Button(onClick = {
            HandleUser.createUser(DemoData.UserInfo2.copy(roleid = 3 , username = "emca" , password = "123"))
        }) {
            Text(text = "Push One Student")
        }
    }

}