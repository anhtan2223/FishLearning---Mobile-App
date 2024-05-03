package com.example.fish.Models

import com.example.fish.Untils.Class
import com.example.fish.Untils.MyDB
import com.google.firebase.database.DataSnapshot

class HandleClass{
    companion object{
        private val ref = MyDB.classInfo
        fun create(info:Class){
            val newInstance = ref.push()
            val newId = newInstance.key
            newInstance.setValue(info.copy(classID = newId ?: "Nothing"))
        }
        fun update(id:String , info: Class){
            ref.child(id).setValue(info)
        }
        fun delete(id: String){
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