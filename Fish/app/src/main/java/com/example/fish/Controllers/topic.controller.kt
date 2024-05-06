package com.example.fish.Controllers

import com.example.fish.Models.HandleTopic
import com.example.fish.Untils.ItemTopic
import com.example.fish.Untils.Topic
import com.example.fish.Untils.getTopic

fun newTopic(info: Topic){
    HandleTopic.create(info)
}
fun updateTopic(info:Topic){
    HandleTopic.updateInfo(info)
}
fun deleteTopic(classId:String , id:String){
    HandleTopic.deleteTopic(classId,id)
}
fun addItemToTopic(classId: String , info:ItemTopic){
    HandleTopic.addToTopic(classId , info)
}
fun deleteItemTopic(classId: String , topicId:String , id:String){
    HandleTopic.deleteItemTopic(classId , topicId ,id)
}
fun updateItemTopic(classId:String, item:ItemTopic){
    HandleTopic.updateDetail(classId, item)
}

fun getTopicByClass(classId: String , onGet:(MutableList<getTopic>)->Unit ){
    HandleTopic.getTopicOfClass(classId){
        onGet(it)
    }
}