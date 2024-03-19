package com.example.fish.Student

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.sharp.DateRange
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Model.Back
import com.example.fish.Model.Class
import com.example.fish.Model.DemoData
import com.example.fish.Model.Document
import com.example.fish.Model.Test
import com.example.fish.Model.TextBox
import com.example.fish.Model.Topic
import com.example.fish.Model.goTo
import com.example.fish.R
import com.example.fish.ui.theme.DisplayUI

@Composable
fun DetailClass(nav:NavController , view:DisplayUI)
{
    Back(nav , view)
    val listTopic = DemoData.Topic
    LazyColumn(modifier = Modifier){
        item {
            InfoClass(info = view.nowClass , { goTo(nav, view , "ClassInfo") })
        }
        items(listTopic)
        {
            TopicView(info = it , nav , view)
        }
    }
}
@Composable
fun InfoClass(info : Class , onClick : () -> Unit = {})
{
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
        OneLine(title = "Tên Lớp", content = info.NameClass)
        OneLine(title = "Giảng Viên", content = info.TeacherID)
        OneLine(title = "Ngày Tạo", content = info.DateCreate)
    }
}
@Composable
fun TopicView(info:Topic , nav:NavController , view: DisplayUI)
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
            Text(
                text = info.Title ,
                style = TextStyle(fontWeight = FontWeight.Bold ,
                fontSize = 18.sp))
        }
        for(i in DemoData.InsideTopic)
        {
            when(i) {
                is TextBox  -> if (i.TopicID == info.TopicID) TextBoxView(info = i)
                is Document -> if (i.TopicID == info.TopicID) DocumentView(info = i)
                is Test     -> if (i.TopicID == info.TopicID) TestView(info = i , nav , view)
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
            text = info.Content ,
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
            text = info.Discribe ,
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
            text = info.TestName ,
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
