package com.example.fish.Controller

import android.util.Log
import com.example.fish.Untils.User
import com.example.fish.Model.HandleUser

fun registerUser(info: User){
    Log.d("Message" , "Add new User : ${info.toString()}")
    HandleUser.createUser(info)
}
