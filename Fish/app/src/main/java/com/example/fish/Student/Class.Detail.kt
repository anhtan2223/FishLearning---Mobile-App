package com.example.fish.Student

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel()
{

}

@Composable
fun DetailClass(nav:NavController)
{
    Text("Detail Class")
}