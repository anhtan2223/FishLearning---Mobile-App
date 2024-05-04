package com.example.fish.Controllers

import android.util.Log
import com.example.fish.Models.HandleClass
import com.example.fish.Models.HandleEnrollment
import com.example.fish.Models.HandleUser
import com.example.fish.Untils.Class
import com.example.fish.Untils.Enrollment
import com.example.fish.Untils.User
import com.google.firebase.database.getValue

fun enrollClass(info:Enrollment){
    HandleEnrollment.create(info)
}
fun getlistUserOfClass(classId : String , onGet:(MutableList<User>)->Unit = {}){
    HandleEnrollment.getlistUserByClass(classId){
        val listUser = mutableListOf<String>()
        for (i in it.children){
            Log.d("TAG", "getlistUserOfClass: ${i.key}")
            i.key?.let { it1 ->
                listUser.add(it1)
            }
        }
        HandleUser.getListUserByListId(listUser){
            onGet(it)
        }
    }
}
fun getListClassOfUser(uid:String , handle:(MutableList<Class>)->Unit = {}){
    HandleEnrollment.getAll {
        val listClass = mutableListOf<String>()
        for(i in it.children){
            for(j in i.children)
                if (j.key == uid)
                    i.key?.let { it1 -> listClass.add(it1) }
            Log.d("TAG", "getListClassOfUser: ${i.key}")
        }
        getAllClass(){
            handle(it.filter {
                it.classID in listClass
            }.toMutableList())
        }
    }
}
