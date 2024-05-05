package com.example.fish.Views.Student

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Controllers.getNameUserByID
import com.example.fish.Controllers.isInClass
import com.example.fish.Controllers.registerClass
import com.example.fish.Untils.Back
import com.example.fish.Untils.Class
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.goTo
import com.example.fish.ui.theme.DisplayUI

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EnterClassView(nav : NavController, view : DisplayUI)
{
    val context = LocalContext.current
    isInClass(view.nowClass.classID, view.info.uid){
        if(it)
            goTo(nav,view,"DetailClass")
    }
    Back(nav = nav, view = view , "Class")
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        InfoEnterClass(view = view, info = view.nowClass)
        ButtonNav(
            onClick = {
                appendMessage(context , "Đăng Kí Thành Công")
                registerClass(view.nowClass.classID , view.info.uid)
                goTo(nav,view,"DetailClass")
            },
            content = "Đăng Kí Lớp Học" ,
            color = Color(0xFF00FC46),
        )
        ButtonNav(onClick = { goTo(nav , view , "Class") }, content = "Quay Lại" , color = Color(0xFFDC0F0F),contentColor = Color.White)
    }
}

@Composable
fun InfoEnterClass(view: DisplayUI,info:Class)
{
    var nameTeacher by remember {
        mutableStateOf("")
    }
    getNameUserByID(view.nowClass.teacherID){
        nameTeacher = it
    }
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Box(
            modifier = Modifier.fillMaxWidth() ,
            contentAlignment = Alignment.TopEnd
        )
        {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth() ,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Thông Tin Lớp Học" , style = TextStyle(fontWeight = FontWeight.Bold , fontSize = 18.sp))
            }
        }
        OneLine(title = "Tên Lớp", content = info.nameClass)
        OneLine(title = "Giảng Viên", content = nameTeacher)
        OneLine(title = "Ngày Tạo", content = info.dateCreate)
    }
}