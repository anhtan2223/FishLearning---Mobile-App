package com.example.fish.ui.theme

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.example.fish.Controllers.getUserList
import com.example.fish.Untils.Class
import com.example.fish.Untils.DemoData
import com.example.fish.Untils.Test
import com.example.fish.Untils.User

data class NavItem(
    val title : String,
    val selected : ImageVector,
    val unselected : ImageVector,
)

class DisplayUI : ViewModel(){
    var info by mutableStateOf( DemoData.UserInfo )
        private set
    var nowQuestion by mutableStateOf(0)
        private set
    var answerList by mutableStateOf( mutableListOf<String>() )
        private set
    var userList by mutableStateOf(mutableListOf<User>())
        private set
    var Title by mutableStateOf("Home")
        private set
    var nowClass by mutableStateOf( Class() )
        private set
    var nowTest by mutableStateOf( Test() )
        private set
    var nowUser by mutableStateOf( User() )
        private set
    var isChoose by mutableStateOf( false )
        private set
    var isTimeout by mutableStateOf(false)
        private set
    fun getUL(callback:()->Unit = {}){
        getUserList {
            this.userList = it
            callback()
        }
    }
    fun filterUL(input:String){
        getUL(){
            Log.d("TAG", "Reset List")
            val regexSearchUser = Regex(".*$input.*" , RegexOption.IGNORE_CASE)
            userList = userList.filter {
                regexSearchUser.matches(it.name)
            }.toMutableList()
        }
    }
    fun setMyInfo(info: User)
    {
        this.info = info
    }
    fun chooseUser(user: User)
    {
        nowUser = user
    }
    fun timeOut()
    {
        isTimeout = true
    }
    fun changeQuestion(question : Int)
    {
        nowQuestion =  question
    }
    fun changePage(title: String)
    {
        Title = title
    }
    fun selectClass(selectedClass : Class)
    {
        nowClass = selectedClass
    }
    fun resetTest()
    {
        isTimeout = false
        answerList.clear()
        for(i in 0 until nowTest.numberQues)
            answerList.add("-1")
        nowQuestion = 0

    }
    fun selectTest(test : Test)
    {
        answerList.clear()
        nowTest = test
        isTimeout = false
        for(i in 0 until nowTest.numberQues ){
            answerList.add("-1")
        }
    }
    fun chooseAnswer(answerId: String)
    {
        answerList.set(nowQuestion,answerId)
        moveNextQues()
    }
    fun moveNextQues()
    {
        if(nowQuestion == nowTest.numberQues-1)
        {
            toogleChoose()
        }
        else changeQuestion(nowQuestion+1)
    }
    fun toogleChoose()
    {
        isChoose = !isChoose
    }



}