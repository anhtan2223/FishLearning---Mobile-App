package com.example.fish.Models

import com.example.fish.Untils.Answer
import com.example.fish.Untils.MyDB
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.getValue
import kotlinx.coroutines.tasks.await

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

       fun getAll( onGet:(DataSnapshot)->Unit ){
           ref.get().addOnSuccessListener {
               onGet(it)
           }
       }
       suspend fun getAnswerByQID(QID:String): MutableList<Answer> {
           val snapshot = ref.get().await()
           val listAnswer = mutableListOf<Answer>()
           for(i in snapshot.children){
               var answer = i.getValue<Answer>()
               if (answer != null) {
                   if(answer.quesID == QID){
                        listAnswer.add(answer)
                   }
               }
           }
           return listAnswer
       }





    }
}