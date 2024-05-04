package com.example.fish.Untils

import com.example.fish.Controllers.createClass
import com.example.fish.Controllers.enrollClass
import com.example.fish.Controllers.updateClass
import com.example.fish.Controllers.updateUser
import com.example.fish.Models.HandleClass
import com.example.fish.Models.HandleUser

class InitValue {
    companion object{
        fun resetAll(){
            resetUser()
            resetClass()
            resetEnrollment()
        }
        fun initFirebase(){
            initUser()
            addListClass()
            addListEnrollment()
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

    }
}