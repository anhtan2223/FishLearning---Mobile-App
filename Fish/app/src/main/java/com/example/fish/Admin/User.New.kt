package com.example.fish.Admin

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Model.Back
import com.example.fish.Student.ButtonNav
import com.example.fish.Student.OneLineChange
import com.example.fish.ui.theme.DisplayUI

@Composable
fun NewUserView(nav : NavController , view : DisplayUI)
{
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
            OneLineChange(title = "Tài Khoản", content = "Tài Khoản Đăng Nhập", readOnly = false )
            OneLineChange(title = "Mật Khẩu", content = "Mật Khẩu Đăng Nhập", readOnly = false  )
            OneLineChange(title = "Họ Và Tên", content = "Tên Người Dùng", readOnly = false  )
            OneLineChange(title = "Email", content = "Email Đăng Ký", readOnly = false )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            RoleOption()
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.SpaceAround ,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            ButtonNav(onClick = { /*TODO*/ }, content = "Tạo Mới")
        }
    }
}

@Composable
fun RoleOption()
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
                onClick = { selectedOption = option },
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
