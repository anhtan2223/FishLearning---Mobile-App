package com.example.fish.Controllers

import com.example.fish.Models.HandleTopic
import com.example.fish.Untils.Topic
import com.google.firebase.database.getValue

fun addTopicToClass(info: Topic){
    HandleTopic.create(info)
}
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
fun updateTopic(info:Topic){
    HandleTopic.updateInfo(info)
}
fun deleteTopic(classId:String , id:String){
    HandleTopic.deleteTopic(classId,id)
}
fun addItemToTopic(classId: String , info:Any){
    HandleTopic.addToTopic(classId , info)
}