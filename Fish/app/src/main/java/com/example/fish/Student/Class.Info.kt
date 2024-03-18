package com.example.fish.Student

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Model.Back
import com.example.fish.Model.DemoData
import com.example.fish.Model.User
import com.example.fish.Model.goTo
import com.example.fish.Teacher.OneUser
import com.example.fish.ui.theme.DisplayUI

@Composable
fun ClassInfoView(nav : NavController, view : DisplayUI)
{
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
                items(DemoData.ListUser){
                    Divider(
                        color = Color.White ,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    OneUser_Student(info = it)
                }
            }
        }
        ButtonNav(
            onClick = { goTo(nav , view , "Home") },
            content = "Rời Lớp" ,
            color = Color(0xFFDC0F0F),
            contentColor = Color.White
        )
    }
}

@Composable
fun OneUser_Student(info : User, onRemove: ()->Unit = {})
{
    val role = when(info.RoleID){
        1 -> "Người Học"
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
                text = info.Name ,
                style = TextStyle(
                    fontWeight = FontWeight.Bold ,
                    fontSize = 16.sp
                )
            )
            Text(
                modifier = Modifier.padding(vertical = 2.dp),
                text = info.Email ,
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