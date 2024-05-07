package com.example.fish.Untils

import com.example.fish.Controllers.enrollClass
import com.example.fish.Controllers.updateAnswer
import com.example.fish.Controllers.updateClass
import com.example.fish.Controllers.updateItemTopic
import com.example.fish.Controllers.updateQuestion
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
            resetAnswer()
            resetQuestion()
        }
        fun initFirebase(){
            initUser()
            addListClass()
            addListEnrollment()
            addListTopic()
            addListQuestion()
            addListAnswer()
        }
        fun initUser(){
            addListStudent()
            pushListStudent()
        }
        fun resetUser(){
            MyDB.user.removeValue()
        }
        fun resetQuestion(){
            MyDB.question.removeValue()
        }
        fun resetAnswer(){
            MyDB.answer.removeValue()
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
                for(j in DemoData.InsideTopic){
                    when(j){
                        is TextBox -> {
                            if(j.topicID == i.topicID)
                                updateItemTopic(i.classID , j)
                        }
                        is Document -> {
                            if(j.topicID == i.topicID)
                                updateItemTopic(i.classID , j)
                        }
                        is Test -> {
                            if(j.topicID == i.topicID)
                                updateItemTopic(i.classID , j)
                        }
                    }
                }
            }
        }

        fun addListQuestion(){
            for(i in DemoData.QuestionList){
                updateQuestion(i)
            }
        }
        fun addListAnswer(){
            for(i in DemoData.AnswerList){
                updateAnswer(i)
            }
        }


    }
}