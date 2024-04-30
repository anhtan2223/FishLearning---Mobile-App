package com.example.fish.Teacher

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Database.Back
import com.example.fish.Database.DemoData
import com.example.fish.Database.getToday
import com.example.fish.Database.goTo
import com.example.fish.Student.ButtonNav
import com.example.fish.Student.OneLineChange
import com.example.fish.ui.theme.DisplayUI

@Composable
fun NewClassView(nav:NavController , view:DisplayUI)
{
    Back(nav = nav, view = view )
    Column(
        modifier = Modifier.padding(start = 20.dp , end = 20.dp , top = 40.dp) ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        OneLineChange(title = "Giảng Viên", content = DemoData.UserInfo.name, readOnly = true )
        OneLineChange(title = "Lớp Học", content = "Tên Lớp Học" , readOnly = false )
        OneLineChange(title = "Tiêu Đề", content = "Tiêu Đề Lớp Học" , readOnly = false )
        OneLineChange(title = "Ngày Tạo", content = getToday() , readOnly = true )
        Spacer(modifier = Modifier.padding(10.dp))
        ButtonNav(onClick = { goTo(nav , view , "Home") }, content = "Tạo Lớp")
    }

}