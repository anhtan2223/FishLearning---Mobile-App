package com.example.fish.Views.Teacher

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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Controllers.addItemToTopic
import com.example.fish.Controllers.deleteItemTopic
import com.example.fish.Controllers.deleteTopic
import com.example.fish.Controllers.getTopicByClass
import com.example.fish.Controllers.newTopic
import com.example.fish.Controllers.updateItemTopic
import com.example.fish.Controllers.updateTopic
import com.example.fish.R
import com.example.fish.Untils.AddAlert
import com.example.fish.Untils.Back
import com.example.fish.Untils.Document
import com.example.fish.Untils.Test
import com.example.fish.Untils.TextBox
import com.example.fish.Untils.Topic
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.getTopic
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.DocumentView
import com.example.fish.Views.Student.InfoClass
import com.example.fish.Views.Student.TestView
import com.example.fish.ui.theme.DisplayUI

@Composable
fun Teacher_DetailClass(nav:NavController , view:DisplayUI)
{
    Back(nav , view)
    val context = LocalContext.current
    var listTopic by remember {
        mutableStateOf(mutableListOf<getTopic>())
    }
    getTopicByClass(view.nowClass.classID){
        listTopic = it
    }
    LazyColumn(modifier = Modifier){
        item {
            InfoClass(view , info = view.nowClass) { goTo(nav, view, "ClassInfo") }
        }
        items(listTopic)
        {
            Teacher_TopicView(info = it , nav , view ,
                onUpdate = {
                    getTopicByClass(view.nowClass.classID){
                        listTopic = it
                    }
                }

            )
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
                    onClick = {
                        newTopic(Topic(classID = view.nowClass.classID , title = "Chủ Đề Mới"))
                        getTopicByClass(view.nowClass.classID){
                            listTopic = it
                        }
                        appendMessage(context , "Thêm Topic Mới Thành Công")
                    }
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
fun Teacher_TopicView(info:getTopic , nav:NavController , view: DisplayUI , onUpdate:()->Unit = {})
{
    var context = LocalContext.current
    var isDeleteTopic by remember {
        mutableStateOf(false)
    }

    AddAlert(
        isShow = isDeleteTopic ,
        content = "Xác Nhận Xoá Chủ Đề ${info.info.title}" ,
        onCancel = { isDeleteTopic = false } ,
        onConfirm = {
            deleteTopic(view.nowClass.classID , info.info.topicID)
            appendMessage(context , "Đã Xoá Chủ Đề Thành Công")
            onUpdate()
            isDeleteTopic = false
        }
    )


    //Get More Topic Element By Query IN SQL
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {

        var content by remember {
            mutableStateOf(info.info.title)
        }
        var isSetting by remember {
            mutableStateOf(false)
        }
        Box(
            modifier = Modifier.fillMaxWidth() ,
            contentAlignment = Alignment.TopEnd
        )
        {
            Row {
                if(isSetting){
                    IconButton(onClick = { isDeleteTopic = true } ) {
                        Icon(imageVector = Icons.Filled.Delete , contentDescription = null)
                    }
                }

                IconButton(onClick = { isSetting = !isSetting ; content = info.info.title }) {
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
                if(!isSetting)
                    Text(text = info.info.title , style = TextStyle(fontWeight = FontWeight.Bold , fontSize = 18.sp))
                else
                    BasicTextField(
                        value =  content,
                        textStyle = TextStyle(fontWeight = FontWeight.Bold , fontSize = 18.sp , color = Color.White) ,
                        onValueChange = {
                            content = it
                            info.info.title = it
                            updateTopic(info.info)
                        }
                    )
            }
        }
        for(i in info.detail)
        {
            when(i) {
                is TextBox  -> CorrectText(info = i , view , info.info , onUpdate = onUpdate)
                is Test     -> TestView(info = i , nav , view ,"TestResult")
                is Document -> DocumentView(info = i){ view.setDocument(i) ;  goTo(nav,view,"DocumentDetail") }
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
                    onClick = {
                        addItemToTopic(view.nowClass.classID , Document(topicID = info.info.topicID , discribe = "New Document"))
                        onUpdate()
                    }
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
                    onClick = {
                        addItemToTopic(view.nowClass.classID , TextBox(topicID = info.info.topicID , content = "New Text") )
                        onUpdate()
                    }
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
                    onClick = {
                        addItemToTopic(view.nowClass.classID , Test(topicID = info.info.topicID , testName = "New Test" , time = 5 ) )
                        onUpdate()
                    }
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
fun CorrectText(info : TextBox , view: DisplayUI , infoTopic:Topic , onUpdate: () -> Unit)
{
    var isDeleteTopic by remember {
        mutableStateOf(false)
    }
    var context = LocalContext.current

    var content by remember {
        mutableStateOf(info.content)
    }
    var isCorrect by remember {
        mutableStateOf(false)
    }
    AddAlert(
        isShow = isDeleteTopic ,
        content = "Xác Nhận Xoá Mục Văn Bản" ,
        onCancel = { isDeleteTopic = false } ,
        onConfirm = {
            deleteItemTopic(view.nowClass.classID , infoTopic.topicID , info.textID)
            appendMessage(context , "Xoá Văn Bản Thành Công")
            onUpdate()
            isDeleteTopic = false
            isCorrect = false
        }
    )
    Row {
        Icon(
            imageVector = if(isCorrect) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowRight,
            contentDescription = null ,
            modifier = Modifier
                .padding(start = 15.dp, top = 8.dp)
                .clickable {
                    content = info.content
                    isCorrect = !isCorrect
                }
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
                            .clickable {
                                updateItemTopic(view.nowClass.classID , info.copy(content = content))
                                isCorrect = !isCorrect
                            }
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = null ,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .size(25.dp)
                            .clickable {
                                content = info.content
                                isCorrect = !isCorrect
                            }
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Icon(
                        imageVector = Icons.Default.Delete ,
                        contentDescription = null ,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .size(25.dp)
                            .clickable { isDeleteTopic = true }
                    )
                }
                BasicTextField(
                    modifier = Modifier.padding(bottom = 20.dp),
                    value = content ,
                    onValueChange = {
                        content = it
                    } ,
                    textStyle = TextStyle(
                        color = Color.White ,
                        fontSize = 15.sp
                    )
                )
            }
        else
            Text(
                text = content ,
                style = MaterialTheme.typography.bodyLarge ,
                modifier = Modifier
                    .padding(bottom = 20.dp, top = 8.dp)
                    .clickable { isCorrect = !isCorrect }
            )

    }
}
