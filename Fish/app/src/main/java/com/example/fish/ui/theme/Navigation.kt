package com.example.fish.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel

data class NavItem(
    val title : String,
    val selected : ImageVector,
    val unselected : ImageVector,
)

class DisplayUI : ViewModel(){
    var Title by mutableStateOf("Home")
        private set
    fun changePage(title: String)
    {
        Title = title
    }

}