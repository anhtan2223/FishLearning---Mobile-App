package com.example.fish.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.example.fish.Model.Answer
import com.example.fish.Model.Class
import com.example.fish.Model.Question
import com.example.fish.Model.Test

data class NavItem(
    val title : String,
    val selected : ImageVector,
    val unselected : ImageVector,
)

class DisplayUI : ViewModel(){
    var nowQuestion by mutableStateOf(0)
        private set
    var answerList by mutableStateOf(mutableListOf<Int>())
    var Title by mutableStateOf("Home")
        private set
    var nowClass by mutableStateOf( Class() )
        private set
    var nowTest by mutableStateOf( Test() )
        private set
    var isChoose by mutableStateOf( false )
        private set
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
    fun selectTest(test : Test)
    {
        answerList.clear()
        nowTest = test
        for(i in 0 until nowTest.NumberQues ){
            answerList.add(-1)
        }
    }
    fun chooseAnswer(answer: Int)
    {
        answerList.set(nowQuestion,answer)
        moveNextQues()
    }
    fun moveNextQues()
    {
        if(nowQuestion == nowTest.NumberQues-1) ;
        else changeQuestion(nowQuestion+1)
    }
    fun toogleChoose()
    {
        isChoose = !isChoose
    }


}