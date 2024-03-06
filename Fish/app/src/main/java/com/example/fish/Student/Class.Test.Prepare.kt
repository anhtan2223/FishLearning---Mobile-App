package com.example.fish.Student

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Model.Back
import com.example.fish.Model.Class
import com.example.fish.Model.Test
import com.example.fish.ui.theme.DisplayUI

@Composable
fun TestPrepareView(nav :NavController , view:DisplayUI)
{
    Back(nav = nav, view = view , "DetailClass")
    DisplayInfo(classInfo = view.nowClass, testInfo = view.nowTest)
}
@Composable
fun DisplayInfo(classInfo : Class , testInfo:Test)
{
    Column(
        modifier = Modifier.padding(start = 20.dp , top = 50.dp)
    ) {
        OneLine(title = "Tên Lớp", content = classInfo.NameClass)
        OneLine(title = "Bài Kiểm Tra", content = testInfo.TestName)
        OneLine(title = "Số Câu Hỏi", content = testInfo.NumberQues.toString())
        OneLine(title = "Thời Gian", content = testInfo.Time.toString())
        OneLine(title = "Số Lần Làm", content = "0")
        OneLine(title = "Kết Quả", content = "")
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)

        ) {
            ButtonNav(onClick = { /*TODO*/ }, content = "Bắt Đầu Bài Thi" , color = MaterialTheme.colorScheme.primary)
        }

    }
}

