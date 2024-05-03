package com.example.fish.Models

import com.example.fish.Untils.MyDB
import com.example.fish.Untils.TextBox
import com.google.firebase.database.DataSnapshot

class HandleText{
    companion object{
        private val ref = MyDB.topic

        fun create(info:TextBox ){
            val newInstance = ref.push()
            val newId = newInstance.key
            newInstance.setValue(info.copy(textID = newId ?: "Nothing"))
        }
        fun update(id:String , info: TextBox){
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