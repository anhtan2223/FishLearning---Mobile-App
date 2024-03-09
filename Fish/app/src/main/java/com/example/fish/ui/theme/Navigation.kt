package com.example.fish.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.example.fish.Model.Class
import com.example.fish.Model.Test

data class NavItem(
    val title : String,
    val selected : ImageVector,
    val unselected : ImageVector,
)

class DisplayUI : ViewModel(){
    var Title by mutableStateOf("Home")
        private set
    var nowClass by mutableStateOf( Class() )
        private set
    var nowTest by mutableStateOf( Test() )
        private set
    var isChoose by mutableStateOf( false )
        private set
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
        nowTest = test
    }
    fun toogleChoose()
    {
        isChoose = !isChoose
    }


}