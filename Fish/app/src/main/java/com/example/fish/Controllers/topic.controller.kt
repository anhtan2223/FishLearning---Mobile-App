package com.example.fish.Controllers

import com.example.fish.Models.HandleTopic
import com.example.fish.Untils.Topic
import com.example.fish.Untils.getTopic
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.getValue

fun addTopicToClass(info: Topic){
    HandleTopic.create(info)
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
fun updateDetailTopic(classId:String , info:Any){
    HandleTopic.updateDetail(classId, info)
}
fun getTopicByClass(classId: String , onGet:(MutableList<getTopic>)->Unit ){
    HandleTopic.getTopicOfClass(classId){
        onGet(it)
    }
}