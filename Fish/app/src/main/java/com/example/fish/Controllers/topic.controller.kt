package com.example.fish.Controllers

import com.example.fish.Models.HandleTopic
import com.example.fish.Untils.Topic
import com.google.firebase.database.getValue

fun getAllTopic(handle:(MutableList<Topic>)->Unit){
    HandleTopic.getAll{
        val list = mutableListOf<Topic>()
        for(i in it.children){
            i.getValue<Topic>()?.let { it1 -> list.add(it1) }
        }
        handle(list)
    }
}
fun getTopic(id:String , value:(Topic)->Unit){
    HandleTopic.getById(id){
        it.getValue(Topic::class.java)?.let { it1 -> value(it1) }
    }
}
fun updateTopic(id: String , info:Topic){
    HandleTopic.update(id,info)
}
fun deleteTopic(id:String){
    HandleTopic.delete(id)
}