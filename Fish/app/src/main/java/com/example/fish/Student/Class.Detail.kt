package com.example.fish.Student

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.ViewModel
import com.example.fish.Model.Back
import com.example.fish.Model.Class
import com.example.fish.Model.DemoData
import com.example.fish.Model.Topic
import com.example.fish.ui.theme.DisplayUI

@Composable
fun DetailClass(nav:NavController , view:DisplayUI)
{
    Back(nav , view)
    val listTopic = DemoData.Topic
    InfoClass(info = view.nowClass)
    LazyColumn(modifier = Modifier.padding(top = 150.dp)){
        item {
            InfoClass(info = view.nowClass)
        }
        items(listTopic)
        {
            TopicView(info = it)
        }
    }
}
@Composable
fun InfoClass(info : Class)
{
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth() ,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Thông Tin Lớp Học" , style = TextStyle(fontWeight = FontWeight.Bold , fontSize = 18.sp))
        }
        OneLine(title = "Tên Lớp", content = info.NameClass)
        OneLine(title = "Giảng Viên", content = info.TeacherID)
        OneLine(title = "Ngày Tạo", content = info.DateCreate)
    }
}
@Composable
fun TopicView(info:Topic)
{
    //Get More Topic Element By Query IN SQL
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth() ,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = info.Title , style = TextStyle(fontWeight = FontWeight.Bold , fontSize = 18.sp))
        }
    }
}