package com.example.fish.Student

import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Model.Back
import com.example.fish.ui.theme.DisplayUI

@Composable
fun AccountScreen(modifier: Modifier = Modifier, nav : NavController , view : DisplayUI)
{
    Back(nav = nav, view = view)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val infoTest = UserInfo(
            Name = "Le Sy Anh Tan" ,
            Email = "anhtan3332@gmail.com" ,
            Username = "anhtan2003" ,
            Password = "12345"
        )
        CardInfo(info = infoTest)
        ButtonNav(onClick = {
            nav.navigate("UpdateInfo") ; view.changePage("UpdateInfo") }, content = "Cập Nhật Thông Tin" , color = MaterialTheme.colorScheme.secondary , modifier = Modifier.fillMaxWidth())
        ButtonNav(onClick = {
            nav.navigate("ChangePass") ; view.changePage("ChangePass")}, content = "Đổi Mật Khẩu" , color = MaterialTheme.colorScheme.onSurface , modifier = Modifier.fillMaxWidth())
        ButtonNav(onClick = { /*TODO*/ }, content = "Đăng Xuất" , color = MaterialTheme.colorScheme.onError , modifier = Modifier.fillMaxWidth())
    }
}
@Composable
fun CardInfo(modifier: Modifier = Modifier , info:UserInfo)
{
    Card(
        modifier = Modifier
            .padding(20.dp)
            .wrapContentWidth(Alignment.CenterHorizontally) )
    {
        OneLine(title = "Tên", content = info.Name)
        OneLine(title = "Email", content = info.Email)
        OneLine(title = "Tài Khoản", content = info.Username)
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
            .weight(3f)
            .padding(5.dp))
        Text(text = content , modifier = Modifier.weight(8f) )
    }
}