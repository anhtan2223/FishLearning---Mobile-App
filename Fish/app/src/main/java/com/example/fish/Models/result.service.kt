package com.example.fish.Models

import com.example.fish.Untils.MyDB
import com.example.fish.Untils.Result
import com.google.firebase.database.DataSnapshot

class HandleResult{
    companion object{
        val ref = MyDB.testResult
        fun create(info:Result){
            val newRef = ref.child(info.testID).child(info.studentID).push()
            newRef.setValue(newRef.key?.let { info.copy(resultID = it) })
//
        }
        fun update(info: Result){
            val myRef = ref.child("${info.testID}/${info.studentID}/${info.resultID}")
                myRef.setValue(info)
        }
        fun getAllByUser(testId : String , uid : String , onGet:(DataSnapshot)->Unit){
            ref.child(testId).child(uid).get().addOnSuccessListener(onGet)
        }
    }
}