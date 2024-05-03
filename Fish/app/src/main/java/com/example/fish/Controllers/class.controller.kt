package com.example.fish.Controllers

import com.example.fish.Models.HandleClass
import com.example.fish.Models.HandleUser
import com.example.fish.Untils.Class
import com.example.fish.Untils.MyDB
import com.example.fish.Untils.User
import com.google.firebase.database.getValue

fun createClass(info:Class){
    HandleClass.create(info)
}
fun updateClass(info: Class){
    HandleClass.update(info.classID,info)
}
fun getAllClass(handle:(MutableList<Class>)->Unit){
    HandleClass.getAll{
        val list = mutableListOf<Class>()
        for(i in it.children){
            i.getValue<Class>()?.let { it1 -> list.add(it1) }
        }
        handle(list)
    }
}
fun getClass(id:String , value:(Class)->Unit){
    HandleClass.getById(id){
        it.getValue(Class::class.java)?.let { it1 -> value(it1) }
    }
}
fun deleteClass(id:String){
    HandleClass.delete(id)
}
fun updateClass(id: String,info: Class){
    HandleClass.update(id, info)
}

