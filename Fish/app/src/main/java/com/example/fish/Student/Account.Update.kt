package com.example.fish.Student

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Model.Back
import com.example.fish.Model.DemoData
import com.example.fish.Model.User
import com.example.fish.ui.theme.DisplayUI

@Composable
fun CardInfoChange(modifier: Modifier = Modifier, info: User)
{
    Card(
        modifier = Modifier
            .padding(5.dp)
            .wrapContentWidth(Alignment.CenterHorizontally) )
    {
        OneLineChange(title = "Tên", content = info.Name , false)
        OneLineChange(title = "Email", content = info.Email , false)
        OneLineChange(title = "Tài Khoản", content = info.Username , true)
    }
}
@Composable
fun OneLineChange(title:String , content:String , readOnly:Boolean , onChange:() -> Unit = {} , visual:VisualTransformation = VisualTransformation.None)
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
            onValueChange = { value = it ; onChange() } ,
            modifier = Modifier.weight(8f) , singleLine = true)
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
            ButtonNav(onClick = { /*TODO*/ }, content = "Xác Nhận", color = MaterialTheme.colorScheme.primaryContainer , modifier = Modifier.weight(1f))
            ButtonNav(onClick = { view.changePage("Account") ; nav.popBackStack() }, content = "Quay Lại", color = MaterialTheme.colorScheme.inversePrimary , modifier = Modifier.weight(1f))
        }
    }
}
@Composable
fun ButtonNav(onClick:()->Unit, content:String, color: Color = Color.Transparent, modifier: Modifier = Modifier)
{
    Button(
        onClick = onClick ,
        border = BorderStroke(2.dp , color),
        modifier = modifier
            .padding(10.dp)
    ) {
        Text(text = content )
    }
}