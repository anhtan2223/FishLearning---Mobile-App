package com.example.fish.Views.Teacher

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Controllers.getNameUserByID
import com.example.fish.Controllers.getResultByTest
import com.example.fish.Untils.Back
import com.example.fish.Untils.Result
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.ButtonNav
import com.example.fish.Views.Student.CountNumberCorrect
import com.example.fish.ui.theme.DisplayUI

@Composable
fun SummaryTestView(nav : NavController , view : DisplayUI)
{
    Back(nav = nav, view = view , "TestResult")
    var listResult by remember {
        mutableStateOf(mutableListOf(Result()))
    }
    getResultByTest(view.nowTest.testID){
        listResult = it
    }
    if(listResult.isNotEmpty()){
        LazyColumn(
            verticalArrangement = Arrangement.Top ,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item {
                Row(
                    modifier = Modifier.fillMaxWidth() ,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Người Làm",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .weight(4f)
                            .padding(5.dp)
                    )
                    Text(
                        text = "Thời Gian",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .weight(3f)
                            .padding(5.dp)
                    )
                    Text(
                        text = "Số Câu Đúng",
                        modifier = Modifier
                            .weight(2f)
                            .padding(start = 5.dp)
                    )
                    Spacer(
                        modifier = Modifier.weight(3f),
                    )
                }
            }
            items(listResult){
                OneResultInfo_Summary(info = it) {
                    view.chooseDetailResult(it.result)
                    goTo(nav,view,"Result")
                }
            }
        }
    }
    else
        Text(text = "Chưa Có Bài Làm Nào" , style = MaterialTheme.typography.titleMedium ,
            modifier = Modifier
            .padding(5.dp))
}

@Composable
fun OneResultInfo_Summary(info: Result , onDetail:()->Unit) {
    var name by remember {
        mutableStateOf("")
    }
    getNameUserByID(info.studentID){
        name = it
    }
    Row(
        modifier = Modifier.fillMaxWidth() ,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = name , style = MaterialTheme.typography.titleMedium , modifier = Modifier
            .weight(4f)
            .padding(5.dp))
        Text(text = info.dateCreate , style = MaterialTheme.typography.titleMedium , modifier = Modifier
            .weight(2f)
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