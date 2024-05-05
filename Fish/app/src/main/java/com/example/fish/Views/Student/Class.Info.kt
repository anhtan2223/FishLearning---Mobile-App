package com.example.fish.Views.Student

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
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
import com.example.fish.Controllers.deleteEnrollment
import com.example.fish.Controllers.getlistUserOfClass
import com.example.fish.Untils.AddAlert
import com.example.fish.Untils.Back
import com.example.fish.Untils.User
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.goTo
import com.example.fish.ui.theme.DisplayUI

@Composable
fun ClassInfoView(nav : NavController, view : DisplayUI)
{
    val context = LocalContext.current
    var listUser by remember {
        mutableStateOf(mutableListOf<User>())
    }
    getlistUserOfClass(view.nowClass.classID){
        listUser = it
    }
    Back(nav = nav, view = view , "DetailClass")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(modifier = Modifier.fillMaxHeight(0.9f)) {
            LazyColumn {
                item {
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth() ,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Danh Sách Thành Viên" , style = TextStyle(fontWeight = FontWeight.Bold , fontSize = 18.sp))
                    }
                }
                item {
                    Divider(
                        color = Color.White ,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                items(listUser){
                    OneUser_Student(info = it)
                    Divider(
                        color = Color.White ,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
        var isShow by remember {
            mutableStateOf(false)
        }
        AddAlert(
            isShow = isShow ,
            title = "Xác Nhận Rời Lớp Học" ,
            content = view.nowClass.nameClass ,
            onCancel = { isShow = false } ,
            onConfirm = {
                isShow = false
                deleteEnrollment(view.nowClass.classID , view.info.uid)
                appendMessage(context , "Đã Rời Khỏi Lớp Thành Công")
                goTo(nav , view , "Home")
            }
        )

        ButtonNav(
            onClick = {
                isShow = true
            },
            content = "Rời Lớp" ,
            color = Color(0xFFDC0F0F),
            contentColor = Color.White
        )
    }
}

@Composable
fun OneUser_Student(info : User, onRemove: ()->Unit = {})
{
    val role = when(info.roleid){
        3 -> "Người Học"
        2 -> "Người Giảng Dạy"
        else -> "Admin"
    }
    Box(
        modifier = Modifier.fillMaxWidth() ,
    ) {
        Column(modifier = Modifier
            .padding(horizontal = 15.dp)
            .align(Alignment.CenterStart)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 5.dp),
                text = info.name ,
                style = TextStyle(
                    fontWeight = FontWeight.Bold ,
                    fontSize = 16.sp
                )
            )
            Text(
                modifier = Modifier.padding(vertical = 2.dp),
                text = info.email ,
                style = TextStyle(
                    fontWeight = FontWeight.Bold ,
                    fontSize = 12.sp
                )
            )
            Text(
                modifier = Modifier.padding(bottom = 12.dp),
                text = role ,
                style = TextStyle(
                    fontWeight = FontWeight.Bold ,
                    fontSize = 12.sp
                )
            )
        }
    }
}