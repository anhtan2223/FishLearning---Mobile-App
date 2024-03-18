package com.example.fish.Teacher

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Model.Back
import com.example.fish.Model.DemoData
import com.example.fish.Model.Document
import com.example.fish.Model.Test
import com.example.fish.Model.TextBox
import com.example.fish.Model.Topic
import com.example.fish.Model.goTo
import com.example.fish.Student.DocumentView
import com.example.fish.Student.InfoClass
import com.example.fish.Student.TestView
import com.example.fish.Student.TextBoxView
import com.example.fish.ui.theme.DisplayUI

@Composable
fun Teacher_DetailClass(nav:NavController , view:DisplayUI)
{
    Back(nav , view)
    val listTopic = DemoData.Topic
    LazyColumn(modifier = Modifier){
        item {
            InfoClass(info = view.nowClass , { goTo(nav, view , "ClassInfo") })
        }
        items(listTopic)
        {
            Teacher_TopicView(info = it , nav , view)
        }
    }
}
@Composable
fun Teacher_TopicView(info:Topic , nav:NavController , view: DisplayUI)
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
                    fontSize = 18.sp)
            )
        }
        for(i in DemoData.InsideTopic)
        {
            when(i) {
                is TextBox  -> if (i.TopicID == info.TopicID) TextBoxView(info = i)
                is Document -> if (i.TopicID == info.TopicID) DocumentView(info = i)
                is Test     -> if (i.TopicID == info.TopicID) TestView(info = i , nav , view ,"TestResult")
            }
        }
    }
}