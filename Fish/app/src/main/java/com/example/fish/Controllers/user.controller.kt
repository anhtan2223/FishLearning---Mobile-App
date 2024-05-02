package com.example.fish.Controllers

import android.util.Log
import com.example.fish.Untils.User
import com.example.fish.Models.HandleUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.getValue

fun registerUser(info: User)
{
    Log.d("Message" , "Add new User : ${info.toString()}")
    HandleUser.createUser(info)
}
fun getUserList(handle:(MutableList<User>)->Unit){
    HandleUser.getAllUser{
        val listUser = mutableListOf<User>()
        for(i in it.children){
            i.getValue<User>()?.let { it1 -> listUser.add(it1) }
        }
        handle(listUser)
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

fun updateUser(info: User){
    HandleUser.updateUserById(info.uid , info)
}
