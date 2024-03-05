package com.example.fish.Student

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.ViewModel
import com.example.fish.Model.Back
import com.example.fish.Model.Class
import com.example.fish.ui.theme.DisplayUI

@Composable
fun DetailClass(nav:NavController , view:DisplayUI)
{
    Back(nav , view)
    InfoClass(view)
}
@Composable
fun InfoClass(view : DisplayUI)
{
    var ClassINFO = view.nowClass
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth() ,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Thông Tin Lớp Học" , style = TextStyle(fontWeight = FontWeight.Bold , fontSize = 18.sp))
        }
        OneLine(title = "Tên Lớp", content = ClassINFO.NameClass)
        OneLine(title = "Giảng Viên", content = ClassINFO.TeacherID)
        OneLine(title = "Ngày Tạo", content = ClassINFO.DateCreate)
    }
}