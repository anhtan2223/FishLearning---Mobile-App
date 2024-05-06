package com.example.fish.Views.Student

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Controllers.getNameUserByID
import com.example.fish.Controllers.getTopicByClass
import com.example.fish.R
import com.example.fish.Untils.Back
import com.example.fish.Untils.Class
import com.example.fish.Untils.DemoData
import com.example.fish.Untils.Document
import com.example.fish.Untils.Test
import com.example.fish.Untils.TextBox
import com.example.fish.Untils.Topic
import com.example.fish.Untils.getTopic
import com.example.fish.Untils.goTo
import com.example.fish.ui.theme.DisplayUI

@Composable
fun DetailClass(nav:NavController , view:DisplayUI)
{
    var topicOfClass by remember {
        mutableStateOf(mutableListOf<getTopic>())
    }
    getTopicByClass(view.nowClass.classID){
        topicOfClass = it
    }
    Back(nav , view)
    LazyColumn(modifier = Modifier){
        item {
            InfoClass(view , info = view.nowClass) { goTo(nav, view, "ClassInfo") }
        }
        items(topicOfClass)
        {
            TopicView(info = it , nav , view)
        }
    }
}
@Composable
fun InfoClass(view: DisplayUI , info : Class , onClick : () -> Unit = {})
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
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
            }
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
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
    }
}
@Composable
fun TopicView(info:getTopic, nav:NavController , view: DisplayUI)
{
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth() ,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = info.info.title ,
                style = TextStyle(fontWeight = FontWeight.Bold ,
                fontSize = 20.sp))
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        for(i in info.detail)
        {
            when(i) {
                is TextBox  -> TextBoxView(info = i)
                is Document -> DocumentView(info = i)
                is Test     -> TestView(info = i , nav , view)
            }
        }
    }
}

@Composable
fun TextBoxView(info:TextBox)
{
    Row {
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null ,
            modifier = Modifier.padding(start = 15.dp)
        )
        Text(
            text = info.content ,
            style = MaterialTheme.typography.bodyLarge ,
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
}
@Composable 
fun DocumentView(info:Document)
{
    Row(
        modifier = Modifier.padding(start = 15.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.file_regular),
            contentDescription = null ,
            modifier = Modifier
                .size(20.dp)
        )
        Text(
            text = info.discribe ,
            style = MaterialTheme.typography.bodyLarge ,
            modifier = Modifier.padding(start = 5.dp , bottom = 20.dp)
        )
    }
}
@Composable
fun TestView(info:Test , nav:NavController , view: DisplayUI , destination:String = "TestPrepare")
{
    Row(
        modifier = Modifier.padding(start = 15.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.pencil_solid),
            contentDescription = null ,
            modifier = Modifier
                .size(20.dp)
                .rotate(270F)
        )
        Text(
            text = info.testName ,
            style = MaterialTheme.typography.bodyLarge ,
            modifier = Modifier
                .padding(start = 5.dp, bottom = 20.dp)
                .clickable {
                    goTo(
                        nav = nav,
                        view = view,
                        goTo = destination
                    ); view.selectTest(info)
                }
        )
    }
}
