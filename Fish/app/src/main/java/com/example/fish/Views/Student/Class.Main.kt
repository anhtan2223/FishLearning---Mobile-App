package com.example.fish.Views.Student

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import com.example.fish.Controllers.getNameUserByID
import com.example.fish.Untils.Back
import com.example.fish.Untils.Class
import com.example.fish.ui.theme.DisplayUI

@Composable
fun ClassScreen(nav: NavController , view : DisplayUI)
{
    val listClass = view.myClass
    Back(nav = nav, view = view)
    LazyColumn()
    {
        items(listClass){
            OneClass(info = it) {
                nav.navigate("RegisterClass");
                view.changePage("RegisterClass");
                view.selectClass(it)
            }
        }
    }
}
@Composable
fun OneClass(info:Class , onClick: ()->Unit)
{
    var nameTeacher by remember {
        mutableStateOf("")
    }
    getNameUserByID(info.teacherID){
        nameTeacher = it
    }
    Box(modifier = Modifier)
    {
        Card(modifier = Modifier
            .padding(5.dp)
            .clickable { onClick() }
            .fillMaxWidth() ,
        ) {
            Text(text = info.nameClass ,
                style = MaterialTheme.typography.titleMedium ,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 18.dp  , bottom = 6.dp , top = 18.dp) )
            Text(text = info.subtitle ,
                style = MaterialTheme.typography.labelMedium ,
                fontSize = 12.sp ,
                modifier = Modifier
                    .padding(start = 18.dp  , bottom = 6.dp)
            )
            Text(text = nameTeacher ,
                style = MaterialTheme.typography.labelLarge ,
                fontSize = 12.sp ,
                modifier =  Modifier
                    .padding(start = 18.dp , bottom = 18.dp)
            )
        }
        IconButton(onClick = onClick ,
                    modifier = Modifier
                        .padding(horizontal = 18.dp)
                        .align(Alignment.CenterEnd)
            ) {
            Icon(
                imageVector = Icons.Rounded.ExitToApp,
                contentDescription = null ,
                modifier = Modifier.size(30.dp)
            )
        }
    }

}
