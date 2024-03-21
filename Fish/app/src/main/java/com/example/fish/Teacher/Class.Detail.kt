package com.example.fish.Teacher

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.example.fish.R
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
        item {
            //Add New Topic
            Row(
                modifier = Modifier
                    .fillMaxWidth() ,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(10.dp)
                        .border(
                            BorderStroke(3.dp, Color(0xFFF57C00)),
                            shape = CircleShape
                        ) ,
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        tint = Color(0xFFF57C00),
                        imageVector = Icons.Default.Add ,
                        contentDescription = null)
                }
            }
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

        var isSetting by remember {
            mutableStateOf(false)
        }
        Box(
            modifier = Modifier.fillMaxWidth() ,
            contentAlignment = Alignment.TopEnd
        )
        {
            Row {
                if(isSetting)
                    IconButton(onClick = {  } ) {
                      Icon(imageVector = Icons.Filled.Delete , contentDescription = null)
                    }
                IconButton(onClick = { isSetting = !isSetting }) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
                }
            }
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth() ,
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                var content by remember {
                    mutableStateOf(info.Title)
                }
                if(!isSetting)
                    Text(text = info.Title , style = TextStyle(fontWeight = FontWeight.Bold , fontSize = 18.sp))
                else
                    BasicTextField(
                        value =  content,
                        textStyle = TextStyle(fontWeight = FontWeight.Bold , fontSize = 18.sp , color = Color.White) ,
                        onValueChange = { content = it }
                    )
            }
        }
        for(i in DemoData.InsideTopic)
        {
            when(i) {
                is TextBox  -> if (i.TopicID == info.TopicID) CorrectText(info = i)
                is Test     -> if (i.TopicID == info.TopicID) TestView(info = i , nav , view ,"TestResult")
//                is TextBox  -> if (i.TopicID == info.TopicID) TextBoxView(info = i)
                is Document -> if (i.TopicID == info.TopicID) DocumentView(info = i)
//                is Test     -> if (i.TopicID == info.TopicID) TestView(info = i , nav , view ,"TestResult")
            }
        }
        if(isSetting)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Center
            ) {
                //Document
                IconButton(
                    modifier = Modifier
                        .padding(10.dp)
                        .border(
                            BorderStroke(3.dp, Color(0xFF00E5FF)),
                            shape = CircleShape
                        ) ,
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.file_regular),
                        tint = Color(0xFF00E5FF) ,
                        contentDescription = null ,
                        modifier = Modifier
                            .size(20.dp)
                    )

                }
                //Text
                IconButton(
                    modifier = Modifier
                        .padding(10.dp)
                        .border(
                            BorderStroke(3.dp, Color(0xFF00E5FF)),
                            shape = CircleShape
                        ) ,
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        tint = Color(0xFF00E5FF),
                        imageVector = Icons.Default.Add ,
                        contentDescription = null)

                }
                //Test
                IconButton(
                    modifier = Modifier
                        .padding(10.dp)
                        .border(
                            BorderStroke(3.dp, Color(0xFF00E5FF)),
                            shape = CircleShape
                        ) ,
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.pencil_solid),
                        tint = Color(0xFF00E5FF),
                        contentDescription = null ,
                        modifier = Modifier
                            .size(20.dp)
                            .rotate(270F)
                    )

                }
            }
    }
}
@Composable
fun CorrectText(info : TextBox)
{
    var setting by remember {
        mutableStateOf(info.Content)
    }
    var isCorrect by remember {
        mutableStateOf(false)
    }
    Row {
        Icon(
            imageVector = if(isCorrect) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowRight,
            contentDescription = null ,
            modifier = Modifier
                .padding(start = 15.dp, top = 8.dp)
                .clickable { isCorrect = !isCorrect }
        )
        if(isCorrect)
            Column {
                Row(modifier = Modifier.padding(horizontal = 5.dp)) {
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null ,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .size(25.dp)
                            .clickable { isCorrect = !isCorrect }
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = null ,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .size(25.dp)
                            .clickable { isCorrect = !isCorrect }
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Icon(
                        imageVector = Icons.Default.Delete ,
                        contentDescription = null ,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .size(25.dp)
                            .clickable { isCorrect = !isCorrect }
                    )
                }
                BasicTextField(
                    modifier = Modifier.padding(bottom = 20.dp),
                    value = setting ,
                    onValueChange = { setting = it } ,
                    textStyle = TextStyle(
                        color = Color.White ,
                        fontSize = 15.sp
                    )
                )
            }
        else
            Text(
                text = info.Content ,
                style = MaterialTheme.typography.bodyLarge ,
                modifier = Modifier
                    .padding(bottom = 20.dp, top = 8.dp)
                    .clickable { isCorrect = !isCorrect }
            )

    }
}
