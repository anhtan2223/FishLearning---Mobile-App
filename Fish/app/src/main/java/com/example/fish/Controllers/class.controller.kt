package com.example.fish.Controllers

import com.example.fish.Models.HandleClass
import com.example.fish.Models.HandleEnrollment
import com.example.fish.Models.HandleTopic
import com.example.fish.Untils.Class
import com.google.firebase.database.getValue

fun createClass(info:Class){
    HandleClass.create(info)
}
fun updateClass(info: Class){
    HandleClass.update(info.classID,info)
}
fun getAllClass(handle:(MutableList<Class>)->Unit){
    HandleClass.getAll{
        val list = mutableListOf<Class>()
        for(i in it.children){
            i.getValue<Class>()?.let { it1 -> list.add(it1) }
        }
        handle(list)
    }
}
fun getClassByTeacher(teacherID:String , handle:(MutableList<Class>)->Unit){
    getAllClass {
        val listClass = it.filter {
            it.teacherID == teacherID
        }.toMutableList()
        handle(listClass)
    }
}


fun deleteClass(classid:String){
    HandleClass.delete(classid)
    HandleEnrollment.deleteByClass(classid)
    HandleTopic.deleteTopicOfClass(classid)
}



