package com.example.fish.Views.Admin

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Controllers.updateUser
import com.example.fish.Untils.Back
import com.example.fish.Untils.User
import com.example.fish.Untils.ValidValue
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.ButtonNav
import com.example.fish.Views.Student.OneLineChange
import com.example.fish.ui.theme.DisplayUI

@Composable
fun DetaiUserView(nav:NavController , view:DisplayUI)
{
    val context = LocalContext.current
    Back(nav = nav, view = view , "User")
    Column(
        modifier = Modifier.fillMaxSize() ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val info = view.nowUser.copy()
        Log.d("InfoUser", "nowUser : $info")
        ChangeUser(info = info )
        ButtonNav(onClick = {

            if(!ValidValue.isValidEmail(info.email)){
                appendMessage(context , "Email Không Hợp Lệ")
                return@ButtonNav
            }
            if(!ValidValue.isValidName(info.name)){
                appendMessage(context,"Tên Không Vượt Quá 50 Ký tự")
                return@ButtonNav
            }
            if(!ValidValue.isValidPassword(info.password)){
                appendMessage(context,"Mật Khẩu Trên 8 Ký Tự")
                return@ButtonNav
            }
            updateUser(info)
            appendMessage(context,"Đã Cập Nhật Thành Công")
            goTo(nav ,view , "User")

        }, content = "Xác Nhận" , color = Color(0xFF00FC46) )
        ButtonNav(onClick = { /*TODO*/ }, content = "Khoá Tài Khoản" , color = Color(0xFFDC0F0F) , contentColor = Color.White)
    }
}
@Composable
fun ChangeUser(info : User)
{
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(15.dp)
            .wrapContentWidth(Alignment.CenterHorizontally) )
    {
        Spacer(modifier = Modifier.padding(top = 25.dp))
        Text(
            text = "Thông Tin Người Dùng" ,
            style = MaterialTheme.typography.titleSmall ,
            fontSize = 25.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        OneLineChange(title = "Tên", content = info.name ,
            onChange = {
                if(it.length == 0)
                    appendMessage(context , "Không thể để trống Tên")
                info.name = it
            } ,
            onFocusChange = {
                if(!it.isFocused && info.name.isNotEmpty() && !ValidValue.isValidName(info.name) )
                    appendMessage(context , "Tên Không Vượt Quá 50 Ký tự")
            }

            )
        OneLineChange(title = "Email", content = info.email,
            onChange = {
                info.email = it
            } ,
            onFocusChange = {
                if(!it.isFocused && info.email.isNotEmpty() && !ValidValue.isValidEmail(info.email) )
                    appendMessage(context , "Email Không Hợp Lệ")
            }
        )
        OneLineChange(title = "Tài Khoản", content = info.username , readOnly = true)
        OneLineChange(title = "Mật Khẩu", content = "Cấp Mật Khẩu Mới" ,
            onChange = {
                info.password = it
            } ,
            onFocusChange = {
                if(!it.isFocused && info.password.length != 0 && !ValidValue.isValidPassword(info.password) )
                    appendMessage(context , "Mật Khẩu Không Hợp Lệ")
            }

            )
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
    }
}