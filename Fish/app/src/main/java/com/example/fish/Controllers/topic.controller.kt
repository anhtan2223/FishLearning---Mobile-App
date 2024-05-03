package com.example.fish.Controllers

import com.example.fish.Models.HandleClass
import com.example.fish.Untils.Class
import com.example.fish.Untils.Topic
import com.google.firebase.database.getValue

fun getAllTopic(handle:(MutableList<Topic>)->Unit){
    HandleClass.getAll{
        val list = mutableListOf<Topic>()
        for(i in it.children){
            i.getValue<Topic>()?.let { it1 -> list.add(it1) }
        }
        handle(list)
    }
}
fun getTopic(id:String , value:(Topic)->Unit){
    HandleClass.getById(id){
        it.getValue(Topic::class.java)?.let { it1 -> value(it1) }
    }
}