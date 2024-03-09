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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Model.Back
import com.example.fish.Model.DemoData
import com.example.fish.Model.User
import com.example.fish.R
import com.example.fish.ui.theme.DisplayUI

@Composable
fun CardInfoChangePass(modifier: Modifier = Modifier, info: User)
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
fun ChangePassword(nav: NavController , view : DisplayUI)
{
    Back(nav = nav , view = view , goTo = "Account")
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val infoTest = DemoData.UserInfo
        CardInfoChangePass(info = infoTest)
        Row(Modifier.fillMaxWidth()) {
            ButtonNav(onClick = { /*TODO*/ },
                content = "Xác Nhận",
                color = Color(0xFF00FC46),
                modifier = Modifier.weight(1f))
            ButtonNav(onClick = {
                nav.popBackStack() ; view.changePage(("Account")) },
                content = "Quay Lại",
                color = Color(0xFFDC0F0F),
                contentColor = Color.White,
                modifier = Modifier.weight(1f))
        }
    }
}