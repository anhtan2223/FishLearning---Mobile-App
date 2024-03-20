package com.example.fish.Teacher

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Model.Back
import com.example.fish.Model.DemoData
import com.example.fish.Model.goTo
import com.example.fish.Student.OneClass
import com.example.fish.ui.theme.DisplayUI

@Composable
fun TeacherHomeScreen(modifier: Modifier = Modifier, nav: NavController, view : DisplayUI)
{
    val listClass = DemoData.myClass
    Back(nav = nav, view = view , goTo = "Account")
    LazyColumn()
    {
        items(listClass){
            OneClass(info = it , {
                goTo(nav , view , "DetailClass")
                view.selectClass(it) })
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp) ,
        contentAlignment = Alignment.BottomEnd
    ){
        FloatingActionButton(
            shape = CircleShape,
            onClick = { goTo(nav , view , "NewClass" ) }
        )
        {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }
    }
}