package com.example.fish.Untils

import android.os.Build
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Views.Student.ButtonNav
import com.example.fish.Views.Student.OneLine
import com.example.fish.ui.theme.DisplayUI
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

@Composable
fun Back(nav: NavController, view: DisplayUI ,  goTo:String = "Home")
{
    BackHandler(enabled = true , onBack = {
        nav.navigate(goTo)
        view.changePage(goTo)
    })
}
fun goTo(nav: NavController , view: DisplayUI , goTo:String )
{
    nav.navigate(goTo)
    view.changePage(goTo)
}
fun formatTime(seconds: Int): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val remainingSeconds = seconds % 60
    return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds)
}
@RequiresApi(Build.VERSION_CODES.O)
fun getToday():String{
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return formatter.format(today)
}
fun stringToDate(input:String):Date{
    return SimpleDateFormat("dd/MM/yyyy").parse(input)
}
fun dateToString(input: Date):String{
//    SimpleDateFormat.getDateInstance()
    return SimpleDateFormat("dd/MM/yyyy").format(input)
}

fun appendMessage(context:android.content.Context , message:String ){
    Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAlert(
        isShow:Boolean ,
        content : String = "",
        onCancel:()->Unit = {} ,
        onConfirm:()->Unit = {} ,
        title :String = "Thông Báo" ,
        confirm :String = "Xác Nhận" ,
        dismiss : String = "Huỷ" ,
){
    if(isShow){
        AlertDialog(
            onDismissRequest = { /*TODO*/ }) {
            Column(
                modifier = Modifier.background(color = Color.Transparent)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium ,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.padding(vertical= 5.dp))
                Text(
                    text = content,
                    style = MaterialTheme.typography.titleSmall ,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.padding(vertical= 5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth() ,
                    verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.Center
                ) {
                    ButtonNav(
                        onClick = { onConfirm() },
                        content = confirm ,
                        color = Color(0xFF00FC46)
                    )
                    ButtonNav(
                        onClick = { onCancel() },
                        content = dismiss ,
                        color = Color(0xFFDC0F0F) ,
                        contentColor = Color.White
                    )
                }
            }
        }
    }
}
