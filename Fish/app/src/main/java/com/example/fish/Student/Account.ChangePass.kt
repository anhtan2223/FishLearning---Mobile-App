package com.example.fish.Student

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

@Composable
fun CardInfoChangePass(modifier: Modifier = Modifier, info: UserInfo)
{
    Card(
        modifier = Modifier
            .padding(20.dp)
            .wrapContentWidth(Alignment.CenterHorizontally) )
    {
        OneLineChange(title = "Tài Khoản", content = info.Username , true)
        OneLineChange(title = "Nhập Mậu Khẩu Cũ", content = "Nhập Mật Khẩu Cũ" , false)
        OneLineChange(title = "Mật Khẩu Mới", content = "Nhập Mật Khẩu Mới" , false)
        OneLineChange(title = "Nhập Lại Mật Khẩu Mới", content = "Xác Nhận Mật Khẩu Mới" , false)
    }
}
@Composable
fun ChangePassword(nav: NavController)
{
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
        CardInfoChangePass(info = infoTest)
        Row(Modifier.fillMaxWidth()) {
            ButtonNav(onClick = { /*TODO*/ }, content = "Xác Nhận", color = MaterialTheme.colorScheme.primaryContainer , modifier = Modifier.weight(1f))
            ButtonNav(onClick = { nav.popBackStack() }, content = "Quay Lại", color = MaterialTheme.colorScheme.inversePrimary , modifier = Modifier.weight(1f))
        }
    }
}