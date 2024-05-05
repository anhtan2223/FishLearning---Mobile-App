package com.example.fish.Untils

import com.example.fish.Controllers.addItemToTopic
import com.example.fish.Controllers.enrollClass
import com.example.fish.Controllers.updateClass
import com.example.fish.Controllers.updateTopic
import com.example.fish.Controllers.updateUser
import com.example.fish.Models.HandleUser

class InitValue {
    companion object{
        fun resetAll(){
            resetUser()
            resetClass()
            resetEnrollment()
            resetTopic()
        }
        fun initFirebase(){
            initUser()
            addListClass()
            addListEnrollment()
            addListTopic()
            addItemsTopic()
        }
        fun initUser(){
            addListStudent()
            pushListStudent()
        }
        fun resetUser(){
            MyDB.user.removeValue()
        }
        fun resetEnrollment(){
            MyDB.enrollment.removeValue()
        }
        fun resetClass(){
            MyDB.classInfo.removeValue()
        }
        fun resetTopic(){
            MyDB.topic.removeValue()
        }
        fun pushListStudent(){
            for(i in DemoData.ListUserPush)
                HandleUser.createUser(UserInfo = i)
        }
        fun addListStudent(){
            for(i in DemoData.ListUser)
                updateUser(i)
        }
        fun addListClass(){
            for(i in DemoData.ListClass)
                updateClass(i)
        }
        fun addListEnrollment(){
            for(i in DemoData.ListEnrollment){
                enrollClass(i)
            }
        }
        fun addListTopic(){
            for(i in DemoData.Topic){
                updateTopic(i)
            }
        }
        fun addItemsTopic(){
            for(i in DemoData.InsideTopic){
                addItemToTopic("1" , i)
            }
        }

    }
}