package com.example.fish.Student

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.fish.Model.Back
import com.example.fish.ui.theme.DisplayUI

@Composable
fun HomeScreen(modifier: Modifier = Modifier, nav: NavController , view : DisplayUI)
{
    val listClass = listOf<ClassInfo>(
        ClassInfo(
            "Math Basic" ,
            "Nam 2023-2024" ,
            "Anh Tan"
        ) ,
        ClassInfo(
            "Graph Theory" ,
            "Nam 2023-2024" ,
            "Giang Vien 1"
        ) ,
        ClassInfo(
            "Machine Learning" ,
            "Nam 2023-2024" ,
            "Giang Vien 2"
        )
    )
    Back(nav = nav, view = view , goTo = "Account")
    LazyColumn()
    {
        items(listClass){
            OneClass(info = it , {nav.navigate("DetailClass") ; view.changePage("DetailClass")})
        }
    }
}