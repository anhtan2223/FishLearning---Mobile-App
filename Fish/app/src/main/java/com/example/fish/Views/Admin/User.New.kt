package com.example.fish.Views.Admin

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Controllers.isValidUsername
import com.example.fish.Controllers.registerUser
import com.example.fish.Untils.Back
import com.example.fish.Untils.User
import com.example.fish.Untils.ValidValue
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.ButtonNav
import com.example.fish.Views.Student.OneLineChange
import com.example.fish.ui.theme.DisplayUI

@Composable
fun NewUserView(nav : NavController , view : DisplayUI)
{
    val info = User()
    val context = LocalContext.current
    Back(nav , view , "User")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ) {
            Spacer(modifier = Modifier.padding(top = 25.dp))
            Text(
                text = "Tạo Tài Khoản" ,
                style = MaterialTheme.typography.titleSmall ,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(bottom = 5.dp))
            OneLineChange(title = "Tài Khoản", content = "Tài Khoản Đăng Nhập" ,
                onChange = {
                    info.username = it
                } ,
                onFocusChange = {
                    if(!it.isFocused && info.username.length !=0)
                    {
                        isValidUsername(info.username){
                            if(it)
                                appendMessage(context , "Tài Khoản Đã Có Người Khác Đăng Ký")
                            else if(!ValidValue.isValidUsername(info.username))
                                appendMessage(context , "Tài Khoản Phải Lớn Hơn 6 Ký tự")
                        }
                    }
                }

                )
            OneLineChange(title = "Mật Khẩu", content = "Mật Khẩu Đăng Nhập",
                onChange = {
                    info.password = it
                } ,
                onFocusChange = {
                    if(!it.isFocused && info.password.length != 0 && !ValidValue.isValidPassword(info.password))
                        appendMessage(context , "Mật Khẩu Phải Lớn Hơn 8 Ký Tự")
                }
                )
            OneLineChange(title = "Họ Và Tên", content = "Tên Người Dùng",
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
            OneLineChange(title = "Email", content = "Email Đăng Ký",
                onChange = {
                    info.email = it
                } ,
                onFocusChange = {
                    if(!it.isFocused && info.email.isNotEmpty() && !ValidValue.isValidEmail(info.email) )
                        appendMessage(context , "Email Không Hợp Lệ")
                }
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            RoleOption(onclick = {
                info.roleid = it
            })
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.SpaceAround ,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            ButtonNav(onClick = {
                if( !ValidValue.isValidUsername(info.username) ) {
                    appendMessage(context , "Tài Khoản Phải Lớn Hơn 6 Ký tự")
                    isValidUsername(info.username){
                        if(it)
                            appendMessage(context , "Tài Khoản Đã Có Người Khác Đăng Ký") ;
                    }
                    return@ButtonNav
                }
                if(!ValidValue.isValidPassword(info.password)){
                    appendMessage(context , "Mật Khẩu Phải Lớn Hơn 8 Ký Tự")
                    return@ButtonNav
                }
                if(!ValidValue.isValidPassword(info.email)){
                    appendMessage(context , "Email Không Hợp Lệ")
                    return@ButtonNav
                }
                registerUser(info)
                appendMessage(context , "Cấp Tài Khoản Thành Công")
                goTo(nav,view,"User")

            }, content = "Tạo Mới")
        }
    }
}

@Composable
fun RoleOption(onclick:(Int)->Unit = {})
{
    val options = listOf("Người Học" , "Người Dạy")
    var selectedOption by remember {
        mutableStateOf("Người Dạy")
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        options.forEach { option ->
            RadioButton(
                selected = (option == selectedOption),
                onClick = {
                    selectedOption = option
                    onclick(if(selectedOption == "Người Học") 3 else 2)
                },
//                colors = RadioButtonDefaults.colors(selectedColor = androidx.compose.ui.graphics.Color.Blue) // Tùy chỉnh màu khi được chọn
            )
            Text(
                modifier = Modifier.clickable {
                    selectedOption = option
                },
                text = option
            )
            Spacer(modifier = Modifier.padding(end = 10.dp))
        }
    }
}
