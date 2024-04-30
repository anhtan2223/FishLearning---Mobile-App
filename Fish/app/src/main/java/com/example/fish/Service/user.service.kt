package com.example.fish.Service

import android.util.Log
import com.example.fish.Database.MyDB
import com.example.fish.Database.User
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class HandleUser {
    companion object{
        var user = MyDB.user
        fun createUser(UserInfo : User = User()){
            val newUser = user.push()
            val newId = newUser.key
            newUser.setValue(UserInfo.copy(uid = newId ?: "Nothing"))
        }
        fun getUserById(uid:String , onSuccess:(info:User?)->Unit ){
            user.child(uid).get().addOnSuccessListener {
                val value = it.getValue(User::class.java)
                onSuccess(value)
                Log.d("Test", value.toString())
            }
        }
        fun deleteUserById(uid:String){
            user.child(uid).removeValue()
        }

        fun updateUserById(uid: String , info: User?){
            user.child(uid).setValue(info)
        }
    }
}