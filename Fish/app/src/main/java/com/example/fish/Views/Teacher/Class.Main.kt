package com.example.fish.Views.Teacher

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.fish.Untils.Back
import com.example.fish.Views.Student.OneClass
import com.example.fish.ui.theme.DisplayUI

@Composable
fun ClassScreen_Teacher(nav: NavController, view : DisplayUI)
{
    val listClass = view.myClass
    Back(nav = nav, view = view)
    LazyColumn()
    {
        items(listClass){
            OneClass(info = it) {
                nav.navigate("DetailClass");
                view.changePage("DetailClass");
                view.selectClass(it)
            }
        }
    }
}