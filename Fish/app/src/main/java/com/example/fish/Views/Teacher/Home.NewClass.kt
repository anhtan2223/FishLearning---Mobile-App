package com.example.fish.Views.Teacher

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Controllers.createClass
import com.example.fish.Untils.Back
import com.example.fish.Untils.Class
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.getToday
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.ButtonNav
import com.example.fish.Views.Student.OneLineChange
import com.example.fish.ui.theme.DisplayUI

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewClassView(nav:NavController , view:DisplayUI)
{
    val context = LocalContext.current
    val classInfo = Class()
    Back(nav = nav, view = view )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ) {
            OneLineChange(title = "Giảng Viên", content = view.info.name , readOnly = true )
            OneLineChange(title = "Lớp Học", content = "Tên Lớp Học" ,
                onChange = {
                    classInfo.nameClass = it
                }
                )
            OneLineChange(title = "Tiêu Đề", content = "Tiêu Đề Lớp Học" ,
                onChange = {
                    classInfo.subtitle = it
                }
                )
            OneLineChange(title = "Ngày Tạo", content = getToday() , readOnly = true )
            Spacer(modifier = Modifier.padding(10.dp))
        }
        Spacer(modifier = Modifier.padding(15.dp))
        ButtonNav(onClick = {
            classInfo.teacherID = view.info.uid
            classInfo.dateCreate = getToday()
            if(classInfo.nameClass.isEmpty()){
                appendMessage(context , "Không Thể Để Trống Tên Lớp")
                return@ButtonNav
            }

            createClass(classInfo)
            appendMessage(context , "Tạo Lớp Thành Công")
            goTo(nav , view , "Home")

        }, content = "Tạo Lớp")
    }

}