package com.example.fish.ui.theme

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.example.fish.Controllers.getDetailTest
import com.example.fish.Controllers.getUserList
import com.example.fish.Untils.Answer
import com.example.fish.Untils.Class
import com.example.fish.Untils.DemoData
import com.example.fish.Untils.DetailResult
import com.example.fish.Untils.Document
import com.example.fish.Untils.Question
import com.example.fish.Untils.Test
import com.example.fish.Untils.User
import com.example.fish.Untils.goTo

data class NavItem(
    val title : String,
    val selected : ImageVector,
    val unselected : ImageVector,
)

class DisplayUI : ViewModel(){
    var info by mutableStateOf( DemoData.UserInfo )
        private set
    var nowIndexQuestion by mutableStateOf(0)
        private set
    var answerList by mutableStateOf( mutableListOf<String>() )
        private set
    var nowDocument by mutableStateOf(Document())
        private set
    var userList by mutableStateOf(mutableListOf<User>())
        private set
    var myClass by mutableStateOf(mutableListOf<Class>())
        private set
    var listDetailResult by mutableStateOf(mutableListOf<DetailResult>())
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
    fun setDocument(doc:Document){
        nowDocument = doc
    }
    fun getMyClass(list: MutableList<Class> , handle:()->Unit = {}){
        myClass = list
        handle()
    }
    fun filterMyClass(input: String){
        val regexSearchUser = Regex(".*$input.*" , RegexOption.IGNORE_CASE)
        myClass = myClass.filter {
            regexSearchUser.matches(it.nameClass)
        }.toMutableList()
    }
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
    fun changeQuestion(questionIndex : Int)
    {
        nowIndexQuestion = questionIndex
    }
    fun changePage(title: String)
    {
        Title = title
    }
    fun selectClass(selectedClass : Class)
    {
        nowClass = selectedClass
    }
    fun chooseDetailResult(input: MutableList<DetailResult>){
        listDetailResult = input
        answerList.clear()
        for(i in input){
            answerList.add(i.chooseAnswer)
        }
    }
    fun resetTest()
    {
        isTimeout = false
        answerList.clear()
        listDetailResult.clear()
        for(i in 0 until nowTest.numberQues){
            answerList.add("-1")
//            listDetailResult.add(DetailResult(chooseAnswer = "-1"))
        }
        nowIndexQuestion = 0
    }
    fun selectTest(test : Test)
    {
        answerList.clear()
        listDetailResult.clear()
        nowTest = test
        isTimeout = false
        for(i in 0 until nowTest.numberQues ){
            answerList.add("-1")
//            listDetailResult.add(DetailResult(chooseAnswer = "-1"))
        }
    }
    fun chooseAnswer(answerId: String)
    {
        answerList.set(nowIndexQuestion , answerId)
        listDetailResult[nowIndexQuestion].chooseAnswer = answerId
        moveNextQues()
    }

    fun initDetailResult(testId:String){
        listDetailResult = getDetailTest(testId)
    }
    fun moveNextQues()
    {
        if(nowIndexQuestion == nowTest.numberQues-1)
        {
            toogleChoose()
        }
        else changeQuestion(nowIndexQuestion+1)
    }
    fun toogleChoose()
    {
        isChoose = !isChoose
    }
    fun addNewQuestion(){
        nowTest.numberQues = nowTest.numberQues+1
    }
    fun deleteOneQuestion(){
        nowTest.numberQues = nowTest.numberQues-1
    }

}