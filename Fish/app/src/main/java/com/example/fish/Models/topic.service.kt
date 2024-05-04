package com.example.fish.Models

import com.example.fish.Untils.MyDB
import com.example.fish.Untils.Topic
import com.google.firebase.database.DataSnapshot

class HandleTopic{
    companion object{
        private val ref = MyDB.topic

        fun create(info:Topic){
            val newInstance = ref.push()
            val newId = newInstance.key
            newInstance.setValue(info.copy(topicID = newId ?: "Nothing"))
        }
        fun update(id:String , info:Topic){
            ref.child(id).setValue(info)
        }
        fun delete(id:String){
            ref.child(id).removeValue()
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