package com.example.fish.Models

import com.example.fish.Untils.Document
import com.example.fish.Untils.MyDB
import com.example.fish.Untils.Test
import com.example.fish.Untils.TextBox
import com.example.fish.Untils.Topic
import com.google.firebase.database.DataSnapshot

class HandleTopic{
    companion object{
        private val ref = MyDB.topic

        fun create(info:Topic){
            val newInstance = ref.child(info.classID).push()
            val newKey = newInstance.key
            newInstance.child("info").setValue(newKey?.let { info.copy(topicID = it) })
        }
        fun updateInfo(info:Topic){
            ref.child(info.classID).child(info.topicID).child("info").setValue(info)
        }
        fun updateTitle(info:Topic){
            ref.child(info.classID).child(info.topicID).child("info").child("title").setValue(info.title)
        }
        fun addToTopic(classId: String ,  info:Any){
            when(info){
                is TextBox -> {
                    ref.child(classId).child(info.topicID).push().setValue(info)
                }
                is Document -> {
                    ref.child(classId).child(info.topicID).push().setValue(info)
                }
                is Test -> {
                    ref.child(classId).child(info.topicID).push().setValue(info)
                }
            }
        }
        fun deleteTopic(classId:String , id:String){
            ref.child(classId).child(id).removeValue()
        }
        fun getAll( onGetAllValue:(DataSnapshot)->Unit ){
            ref.get().addOnSuccessListener {
                onGetAllValue(it)
            }
        }
        fun getById(id: String , onGetValue:(DataSnapshot)->Unit){
            ref.child(id).get().addOnSuccessListener{
                onGetValue(it)
            }
        }

    }
}