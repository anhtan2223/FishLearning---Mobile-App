package com.example.fish.Untils

import android.os.Build
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.fish.ui.theme.DisplayUI
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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

fun appendMessage(context:android.content.Context , message:String ){
    Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
}