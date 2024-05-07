package com.example.fish.Views.Admin

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
import com.example.fish.Untils.Back
import com.example.fish.Untils.Class
import com.example.fish.Untils.Test
import com.example.fish.Untils.formatTime
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.ButtonNav
import com.example.fish.Views.Student.OneLine
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
        OneLine(title = "Thời Gian", content = formatTime(testInfo.time*60) )
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