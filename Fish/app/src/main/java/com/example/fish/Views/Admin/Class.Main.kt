package com.example.fish.Views.Admin

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.fish.Untils.Back
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.OneClass
import com.example.fish.ui.theme.DisplayUI

@Composable
fun AdminHomeView(nav: NavController, view : DisplayUI)
{
    val listClass = view.myClass
    Back(nav = nav, view = view , goTo = "Account")
    LazyColumn()
    {
        items(listClass){
            OneClass(info = it) {
                goTo(nav, view, "DetailClass")
                view.selectClass(it)
            }
        }
    }
}