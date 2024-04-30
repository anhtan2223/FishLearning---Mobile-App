package com.example.fish.Teacher

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.fish.Database.Back
import com.example.fish.ui.theme.DisplayUI

@Composable
fun SummaryTestView(nav : NavController , view : DisplayUI)
{
    Back(nav = nav, view = view , "TestResult")
    Text(text = "Hiển Thị Kết Quả Thống Kê Của Lớp Học")
}