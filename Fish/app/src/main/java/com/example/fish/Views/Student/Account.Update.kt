package com.example.fish.Views.Student

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Untils.Back
import com.example.fish.Untils.DemoData
import com.example.fish.Untils.User
import com.example.fish.ui.theme.DisplayUI

@Composable
fun CardInfoChange(modifier: Modifier = Modifier, info: User)
{
    Card(
        modifier = Modifier
            .padding(5.dp)
            .wrapContentWidth(Alignment.CenterHorizontally) )
    {
        OneLineChange(title = "Tên", content = info.name , false)
        OneLineChange(title = "Email", content = info.email , false)
        OneLineChange(title = "Tài Khoản", content = info.username , true)
    }
}
@Composable
fun OneLineChange(
    title:String ,
    content:String ,
    readOnly:Boolean ,
    onChange:(String) -> Unit = {} ,
    onFocusChange:(FocusState) -> Unit = {},
    visual:VisualTransformation = VisualTransformation.None ,
    keyboard:KeyboardOptions = KeyboardOptions.Default)
{
    Row(
        modifier = Modifier.fillMaxWidth() ,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title , style = MaterialTheme.typography.titleMedium , modifier = Modifier
            .weight(3f)
            .padding(5.dp)
        )
        var value by remember {
            mutableStateOf("")
        }
        TextField(
            value = value,
            placeholder = { Text(content) } ,
            readOnly = readOnly ,
            visualTransformation = visual,
            keyboardOptions = keyboard,
            onValueChange = { value = it ; Log.d("Test","Input : $it") ; onChange(value) } ,
            modifier = Modifier
                .onFocusChanged {
                    onFocusChange(it)
                }
                .weight(8f) , singleLine = true
        )
    }
}
@Composable
fun UpdateInfo(nav: NavController ,  view : DisplayUI)
{
    Back(nav = nav , view = view , goTo = "Account")
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val infoTest = DemoData.UserInfo
        CardInfoChange(info = infoTest)
        Row(Modifier.fillMaxWidth()) {
            ButtonNav(onClick = { /*TODO*/ },
                content = "Xác Nhận",
                color = Color(0xFF00FC46),
                modifier = Modifier.weight(1f))
            ButtonNav(
                onClick = { view.changePage("Account") ; nav.popBackStack() },
                content = "Quay Lại",
                color = Color(0xFFDC0F0F),
                contentColor = Color.White,
                modifier = Modifier.weight(1f))
        }
    }
}
@Composable
fun ButtonNav(
    modifier: Modifier = Modifier,
    onClick : ()-> Unit,
    content : String,
    color   : Color = Color(0xFF28FFFF),
    contentColor : Color = Color.DarkGray
            )
{
    Button(
        onClick = onClick ,
        border = BorderStroke(2.dp , color),
        modifier = modifier
            .padding(10.dp)
        ,
        colors = ButtonDefaults.buttonColors( containerColor = color , contentColor = contentColor)
    ) {
        Text(text = content )
    }
}