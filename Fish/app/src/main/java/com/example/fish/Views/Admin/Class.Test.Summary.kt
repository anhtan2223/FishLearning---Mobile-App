package com.example.fish.Views.Admin

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.fish.Untils.Back
import com.example.fish.ui.theme.DisplayUI

@Composable
fun SummaryTestView_Admin(nav : NavController, view : DisplayUI)
{
    Back(nav = nav, view = view , "TestPrepare")
    Text(text = "Hiển Thị Kết Quả Thống Kê Của Lớp Học")
}