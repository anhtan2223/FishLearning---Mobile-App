package com.example.fish.Models

import android.util.Log
import com.example.fish.Untils.MyDB
import com.example.fish.Untils.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

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
        fun getAllUser(onGetAllValue:(DataSnapshot)->Unit){
            user.get().addOnSuccessListener {
                onGetAllValue(it)
            }
        }
        fun deleteUserById(uid:String){
            user.child(uid).removeValue()
        }

        fun updateUserById(uid: String , info: User?){
            user.child(uid).setValue(info)
        }

        fun checkUsername(username:String , onSame:(Boolean)->Unit){
            user.get().addOnSuccessListener {
                for (i in it.children)
                {
                    val usn = i.child("username").getValue(String::class.java)
                    Log.d("TestHere", "checkUsername: $usn $username ${usn == username}")
                    if(usn == username) {
                        onSame(true)
                        return@addOnSuccessListener
                    }
                }
                onSame(false)
            }
        }
    }
}