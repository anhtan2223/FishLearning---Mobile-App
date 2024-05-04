package com.example.fish.Models

import com.example.fish.Untils.Enrollment
import com.example.fish.Untils.MyDB
import com.google.firebase.database.DataSnapshot

class HandleEnrollment{
    companion object{
        private val ref = MyDB.enrollment
        fun create(info: Enrollment){
            val newRef = ref.child(info.classID)
            newRef.child(info.studentID).setValue(info)
        }
        fun update(id:String , info: Enrollment){
            ref.child(id).setValue(info)
        }
        fun getAll(onGet:(DataSnapshot)->Unit){
            ref.get().addOnSuccessListener {
                onGet(it)
            }
        }
        fun deleteByClass(id: String){
            ref.child(id).removeValue()
        }
        fun deleteByUID(info: Enrollment){
            ref.child(info.classID).child(info.studentID).removeValue()
        }
        fun getlistUserByClass(classId:String , onGet:(DataSnapshot)->Unit){
            ref.child(classId).get().addOnSuccessListener {
                onGet(it)
            }
        }


    }
}