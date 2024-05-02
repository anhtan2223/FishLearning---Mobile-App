package com.example.fish

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
import com.example.fish.Controllers.getUserList
import com.example.fish.Controllers.updateUser
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
            Text(text = "Clear User Database")
        }
        Button(onClick = {
            updateUser(DemoData.UserInfo.copy(uid = "admin" , roleid = 1 , username = "admin" , password = "123"))
        }) {
            Text(text = "Push/Reset Default Admin")
        }

        Button(onClick = {
            updateUser(DemoData.UserInfo2.copy(uid = "teacher" , roleid = 2 , username = "teacher" , password = "123"))
        }) {
            Text(text = "Push/Reset Default Teacher")
        }

        Button(onClick = {
            updateUser(DemoData.UserInfo2.copy(uid = "user" , roleid = 3 , username = "user" , password = "123"))
        }) {
            Text(text = "Push/Reset Default Student")
        }
        Button(onClick = {
            for(i in DemoData.ListUser){
                HandleUser.createUser(UserInfo = i)
            }
        }) {
            Text(text = "Push List User")
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