package com.example.fish.Models

import com.example.fish.Untils.Answer
import com.example.fish.Untils.MyDB
import com.example.fish.Untils.Question
import com.google.firebase.database.DataSnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HandleAnswer{
    companion object{
        var ref = MyDB.answer
       fun create(info:Answer){
           val newRef = ref.push()
           val newKey = newRef.key
           newRef.setValue(newKey?.let { info.copy(ansID = it) })
       }
       fun update(info: Answer){
           ref.child(info.ansID).setValue(info)
       }

       fun deleteById(aid : String){
           ref.child(aid).removeValue()
       }
        fun setIsTrue(id:String , nowValue:Boolean){
            ref.child(id).child("correct").setValue(!nowValue)
        }

       fun getAnswerByQuestion(quesId:String , onGet:(DataSnapshot)->Unit){
           ref.get().addOnSuccessListener {
               onGet(it)
           }
       }




    }
}