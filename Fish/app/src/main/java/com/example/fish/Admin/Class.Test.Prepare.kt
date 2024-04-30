package com.example.fish.Admin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Database.Back
import com.example.fish.Database.Class
import com.example.fish.Database.Test
import com.example.fish.Database.formatTime
import com.example.fish.Database.goTo
import com.example.fish.Student.ButtonNav
import com.example.fish.Student.OneLine
import com.example.fish.ui.theme.DisplayUI

@Composable
fun TestPrepareView_Admin(nav : NavController, view: DisplayUI)
{
    Back(nav = nav, view = view , "DetailClass")
    DisplayInfo(
        classInfo = view.nowClass ,
        testInfo = view.nowTest ,
        onclick = { view.resetTest() ; goTo(nav,view,"TestSummary") }
    )
}
@Composable
fun DisplayInfo(classInfo : Class, testInfo: Test, onclick : ()->Unit)
{
    Column(
        modifier = Modifier.padding(start = 20.dp , top = 50.dp)
    ) {
        OneLine(title = "Tên Lớp", content = classInfo.nameClass)
        OneLine(title = "Bài Kiểm Tra", content = testInfo.testName)
        OneLine(title = "Số Câu Hỏi", content = testInfo.numberQues.toString())
        OneLine(title = "Thời Gian", content = formatTime(testInfo.time) )
        OneLine(title = "Thực Hiện", content = "0")
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)

        ) {
            ButtonNav(onClick = { onclick() }, content = "Thống Kê Lớp Học" , color = MaterialTheme.colorScheme.primary)
        }

    }
}