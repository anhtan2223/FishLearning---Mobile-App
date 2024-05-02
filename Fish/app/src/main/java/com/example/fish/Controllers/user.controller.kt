package com.example.fish.Controllers

import android.util.Log
import com.example.fish.Untils.User
import com.example.fish.Models.HandleUser
import com.google.firebase.database.DataSnapshot

fun registerUser(info: User)
{
    Log.d("Message" , "Add new User : ${info.toString()}")
    HandleUser.createUser(info)
}
fun getUserList(handle:(DataSnapshot)->Unit){
    HandleUser.getAllUser{
        handle(it)
    }
}
fun isValidUsername(username:String , handle:(Boolean)->Unit)
{
    HandleUser.checkUsername(username , handle )
}
fun login(
    username: String ,
    password:String ,
    onUserTrue:(Boolean , User)->Unit ,
    onUserFalse:()->Unit
) {
    HandleUser.Login(username,password,onUserTrue,onUserFalse)
}
