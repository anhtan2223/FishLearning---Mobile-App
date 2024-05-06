package com.example.fish.Views.Teacher

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Controllers.deleteItemTopic
import com.example.fish.Controllers.updateItemTopic
import com.example.fish.Untils.AddAlert
import com.example.fish.Untils.Back
import com.example.fish.Untils.Class
import com.example.fish.Untils.Test
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.ButtonNav
import com.example.fish.Views.Student.OneLine
import com.example.fish.ui.theme.DisplayUI

@Composable
fun TestResult(nav :NavController , view:DisplayUI)
{
    Back(nav = nav, view = view , "DetailClass")
    Teacher_DisplayInfo(nav = nav, view = view , classInfo = view.nowClass, testInfo = view.nowTest)
}
@Composable
fun Teacher_DisplayInfo(nav : NavController, view: DisplayUI , classInfo : Class , testInfo:Test)
{
    val context = LocalContext.current
    var isDelete by remember {
        mutableStateOf(false)
    }
    AddAlert(
        isShow = isDelete ,
        content = "Xác Nhận Xoá Lớp Học ${testInfo.testName}" ,
        onCancel = { isDelete = false } ,
        onConfirm = {
            appendMessage(context , "Xoá Bài Kiểm Tra Thành Công")
            deleteItemTopic(view.nowClass.classID , testInfo.topicID , testInfo.testID)
            goTo(nav , view , "DetailClass")
            isDelete= false
        }
    )
    Column(
        modifier = Modifier.padding(start = 20.dp , top = 50.dp)
    ) {
        OneLine(title = "Tên Lớp", content = classInfo.nameClass)
        OneInputBasic(title = "Bài Kiểm Tra", content = testInfo.testName ){
            if(it.isEmpty()){
                appendMessage(context , "Không Thể Để Trống Tên Lớp")
                return@OneInputBasic
            }
            updateItemTopic(view.nowClass.classID , testInfo.copy(testName = it))
            testInfo.testName = it
        }
        OneLine(title = "Số Câu Hỏi", content = testInfo.numberQues.toString() )
        InputTime(view , title = "Thời Gian", time = testInfo.time ){
            if(it.isEmpty()){
                appendMessage(context , "Không Thể Để Trống Thời Gian")
                return@InputTime
            }
            updateItemTopic(view.nowClass.classID , testInfo.copy(time = it.toInt()))
        }
        OneLine(title = "Người Tham Dự", content = "0")
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            ButtonNav(onClick = { goTo(nav , view , "SumTest") }, content = "Tổng Kết Bài Thi" , color = MaterialTheme.colorScheme.primary , contentColor = Color.Black)
            ButtonNav(onClick = { goTo(nav , view , "ChangeQues") }, content = "Chỉnh Sửa Bài Thi" , color = MaterialTheme.colorScheme.primary , contentColor = Color.Black)
        }
        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ButtonNav(
                onClick = {
                          isDelete = true
                } ,
                content = "Xoá Bài Kiểm Tra" ,
                color = Color(0xFFDC0F0F) ,
                contentColor = Color.White
            )

        }

    }
}

@Composable
fun OneInputBasic(title:String , content:String , onChange:(String)->Unit = {} )
{
    var contentInput by remember {
        mutableStateOf(content)
    }
    Row(
        modifier = Modifier.fillMaxWidth() ,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title , style = MaterialTheme.typography.titleMedium ,
            modifier = Modifier
                .weight(4f)
                .padding(5.dp)
        )
        BasicTextField(
            modifier = Modifier
                .weight(7f)
                .padding(5.dp) ,
            value = contentInput ,
            textStyle = TextStyle(
                color = Color.White ,
                fontSize = 16.sp
            ) ,
            onValueChange = {
                contentInput = it
                onChange(contentInput)
            }
        )
    }
}
@Composable
fun InputTime(view: DisplayUI , title:String , time:Int , onChange:(String)->Unit)
{
    var contentInput by remember {
        mutableStateOf(time.toString())
    }
    Row(
        modifier = Modifier.fillMaxWidth() ,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title , style = MaterialTheme.typography.titleMedium ,
            modifier = Modifier
                .weight(4f)
                .padding(5.dp)
        )
        BasicTextField(
            modifier = Modifier
                .weight(2f)
                .padding(5.dp)
                .pointerHoverIcon(
                    icon = PointerIcon.Text
                )
            ,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            value = contentInput ?:"0",
            textStyle = TextStyle(
                color = Color.White ,
                fontSize = 16.sp
            ) ,
            onValueChange = {
                contentInput = it
                onChange(it)
            }
        )
        Text(text = "Phút" , style = MaterialTheme.typography.labelMedium ,
            modifier = Modifier
                .weight(5f)
                .padding(5.dp)
        )
    }
}
