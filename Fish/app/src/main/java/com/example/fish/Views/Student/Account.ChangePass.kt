package com.example.fish.Views.Student

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Controllers.updateUser
import com.example.fish.Untils.Back
import com.example.fish.Untils.ValidValue
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.goTo
import com.example.fish.ui.theme.DisplayUI

@Composable
fun ChangePassword(nav: NavController , view : DisplayUI)
{

    var changePass by remember {
        mutableStateOf(
            object {
                var nowPass = ""
                var newPass = ""
                var reNewPass = ""
            }
        )
    }

    Back(nav = nav , view = view , goTo = "Account")
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val info = view.info

        val context = LocalContext.current
        Card(
            modifier = Modifier
                .padding(20.dp)
                .wrapContentWidth(Alignment.CenterHorizontally) )
        {
            OneLineChange(title = "Tài Khoản", content = info.username , true)
            OneLineChange(title = "Nhập Mậu Khẩu Cũ", content = "Nhập Mật Khẩu Cũ" ,
                visual = PasswordVisualTransformation(),
                onChange ={
                    changePass.nowPass = it
                } ,
                onFocusChange = {
                    if( !it.isFocused && changePass.nowPass.length!=0 && changePass.nowPass != view.info.password)
                        appendMessage(context , "Mật Khẩu Hiện Tại Không Đúng")
                }
            )
            OneLineChange(title = "Mật Khẩu Mới", content = "Nhập Mật Khẩu Mới" ,
                visual = PasswordVisualTransformation(),
                onChange = {
                    changePass.newPass = it
                } ,
                onFocusChange = {
                    if( !it.isFocused && changePass.newPass.length!=0 && !ValidValue.isValidPassword(changePass.newPass))
                        appendMessage(context , "Mật Khẩu Mới Phải Lớn Hơn 8 Ký Tự")
                }
            )
            OneLineChange(title = "Nhập Lại Mật Khẩu Mới", content = "Xác Nhận Mật Khẩu Mới" ,
                visual = PasswordVisualTransformation(),
                onChange = {
                    changePass.reNewPass = it
                } ,
                onFocusChange = {
                    if(!it.isFocused && changePass.reNewPass.length!=0 && changePass.newPass!=changePass.reNewPass)
                        appendMessage(context , "Mật Khẩu Mới Nhập lại Không Đúng")
                }
            )
        }

        Row(Modifier.fillMaxWidth()) {
            ButtonNav(onClick = {

                if(changePass.nowPass != view.info.password ){
                    appendMessage(context,"Mật Khẩu Hiện Tại Không Đúng")
                    return@ButtonNav
                }

                if(!ValidValue.isValidPassword(changePass.newPass)){
                    appendMessage(context,"Mật Khẩu Mới Phải trên 8 Ký Tự")
                    return@ButtonNav
                }

                if(changePass.newPass!=changePass.reNewPass){
                    appendMessage(context,"Mật Khẩu Mới Nhập lại Không Đúng")
                    return@ButtonNav
                }
                val newInfo = view.info.copy(password = changePass.newPass)
                updateUser(newInfo)
                view.setMyInfo(newInfo)
                appendMessage(context,"Thay Đổi Mật Khẩu Thành Công")
                goTo(nav,view,"Account")
            },
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