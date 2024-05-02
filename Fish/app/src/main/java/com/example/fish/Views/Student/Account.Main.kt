package com.example.fish.Views.Student

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Untils.Back
import com.example.fish.Untils.DemoData
import com.example.fish.Untils.User
import com.example.fish.ui.theme.DisplayUI

@Composable
fun AccountScreen(modifier: Modifier = Modifier, nav : NavController , view : DisplayUI , navFather : NavController)
{
    Back(nav = nav, view = view)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize()
    ) {
        val infoTest = view.info
        CardInfo(info = infoTest)
        ButtonNav(onClick = {
            nav.navigate("UpdateInfo") ; view.changePage("UpdateInfo") },
            content = "Cập Nhật Thông Tin" ,
            color = Color(0xFF00FC46),
            modifier = Modifier.fillMaxWidth())
        ButtonNav(onClick = {
            nav.navigate("ChangePass") ; view.changePage("ChangePass")},
            content = "Đổi Mật Khẩu" ,
            color = Color(0xFF00FC46),
            modifier = Modifier.fillMaxWidth())
        ButtonNav(onClick = { navFather.navigate(("LogIn")) },
            content = "Đăng Xuất" ,
            color = Color(0xFFDC0F0F),
            contentColor = Color.White,
            modifier = Modifier.fillMaxWidth())
    }
}
@Composable
fun CardInfo(modifier: Modifier = Modifier , info:User)
{
    Card(
        modifier = Modifier
            .padding(15.dp)
            .wrapContentWidth(Alignment.CenterHorizontally) )
    {
        OneLine(title = "Tên", content = info.name)
        OneLine(title = "Email", content = info.email)
        OneLine(title = "Tài Khoản", content = info.username)
    }
}
@Composable
fun OneLine(title:String , content:String )
{
    Row(
        modifier = Modifier.fillMaxWidth() ,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title , style = MaterialTheme.typography.titleMedium , modifier = Modifier
            .weight(4f)
            .padding(5.dp))
        Text(text = content , modifier =
        Modifier.weight(7f).padding(start = 5.dp)
        )
    }
}