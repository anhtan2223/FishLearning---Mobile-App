package com.example.fish.Views.Student

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Controllers.getResultByUser
import com.example.fish.Untils.Back
import com.example.fish.Untils.Class
import com.example.fish.Untils.Result
import com.example.fish.Untils.Test
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.formatTime
import com.example.fish.Untils.goTo
import com.example.fish.ui.theme.DisplayUI

@Composable
fun TestPrepareView(nav :NavController , view:DisplayUI)
{
    Back(nav = nav, view = view , "DetailClass")
    DisplayInfo(
        nav = nav ,
        view = view ,
        onclick = {
            view.resetTest()
            goTo(nav,view,"Test")
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayInfo(nav:NavController , view: DisplayUI , onclick : ()->Unit)
{
    var resultList by remember {
        mutableStateOf(mutableListOf(Result()))
    }
    getResultByUser(view.nowTest.testID ,view.info.uid){
        resultList = it
    }
    var context = LocalContext.current
    var openListHistory by remember {
        mutableStateOf(false)
    }

    if(openListHistory){
        AlertDialog(
            onDismissRequest = { /*TODO*/ }) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(color = Color.Transparent)
            ){
                item{
                    Text(
                        text = "Danh Sách Kết Quả",
                        style = MaterialTheme.typography.labelMedium ,
                        fontSize = 30.sp,
                    )
                    Spacer(modifier = Modifier.padding(vertical= 5.dp))
                    if(resultList.isEmpty()){
                        Text(
                            text = "Chưa Có Bài Làm",
                            style = MaterialTheme.typography.labelMedium ,
                            fontSize = 30.sp,
                            modifier = Modifier.padding(vertical = 10.dp)
                        )
                    }
                    else
                        OneLine(title = "Ngày Nộp", content = "Kết Quả")
                }
                items(resultList){
                    OneResultInfo(it){
                        view.chooseDetailResult(it.result)
                        goTo(nav,view,"Result")
                        openListHistory = false
                    }
                }
                item {
                    Spacer(modifier = Modifier.padding(vertical= 5.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth() ,
                        verticalAlignment = Alignment.CenterVertically ,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ButtonNav(
                            onClick = { openListHistory = false },
                            content = "Quay Về" ,
                            color = Color(0xFFDC0F0F) ,
                            contentColor = Color.White
                        )
                    }
                }
            }
        }
    }
    Column(
        modifier = Modifier.padding(start = 20.dp , top = 50.dp)
    ) {
        OneLine(title = "Tên Lớp", content = view.nowClass.nameClass)
        OneLine(title = "Bài Kiểm Tra", content = view.nowTest.testName)
        OneLine(title = "Số Câu Hỏi", content = view.nowTest.numberQues.toString())
        OneLine(title = "Thời Gian", content = formatTime(view.nowTest.time*60) )
        OneLine(title = "Số Lần Làm", content = resultList.size.toString())
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            ButtonNav(
                onClick = {
                    openListHistory = true
                },
                content = "Lịch Sử Bài Làm" ,
                color = MaterialTheme.colorScheme.primary
            )
            ButtonNav(
                onClick = {
                    if(view.nowTest.numberQues == 0){
                        appendMessage(context , "Vui Lòng Đợi Giảng Viên Thêm Câu Hỏi")
                        return@ButtonNav
                    }
                    onclick()
                          },
                content = "Bắt Đầu Bài Thi" ,
                color = Color(0xFF1CCF39) ,
                contentColor = Color.White
            )

        }

    }
}

@Composable
fun OneResultInfo(info: Result , onDetail:()->Unit) {
    Row(
        modifier = Modifier.fillMaxWidth() ,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = info.dateCreate , style = MaterialTheme.typography.titleMedium , modifier = Modifier
            .weight(4f)
            .padding(5.dp))
        Text(text = CountNumberCorrect(info.result.size , info.result) ,
            modifier = Modifier
                .weight(3f)
                .padding(start = 5.dp)
        )
        ButtonNav(
            modifier = Modifier.weight(3f),
            onClick = { onDetail() },
            content = "Chi Tiết"
        )
    }
}




