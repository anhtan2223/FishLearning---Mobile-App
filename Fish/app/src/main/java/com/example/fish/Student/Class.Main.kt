package com.example.fish.Student

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//data class ()
@Composable
fun ClassScreen(modifier: Modifier = Modifier, search:String="", nav: NavController)
{
    val listClass = listOf<ClassInfo>(
        ClassInfo(
            "Math Basic" ,
            "Nam 2023-2024" ,
            "Anh Tan"
        ) ,
        ClassInfo(
            "Machine Learning" ,
            "HK2 - Nam Hoc 2023-2024" ,
            "Nguoi Day 1"
        ) ,
        ClassInfo(
            "OOP" ,
            "Nam 2023-2024" ,
            "Nguoi Day 1"
        ) ,
        ClassInfo(
            "Math Basic" ,
            "Nam 2023-2024" ,
            "Nguoi Day 1"
        ) ,
        ClassInfo(
            "Graph Theory" ,
            "Nam 2023-2024" ,
            "Nguoi Day C"
        ) ,
        ClassInfo(
            "Machine Learning" ,
            "Nam 2023-2024" ,
            "Nguoi Day A"
        ) ,
        ClassInfo(
            "Machine Learning" ,
            "Nam 2023-2024" ,
            "Nguoi Day B"
        ) ,
        ClassInfo(
            "Machine Learning" ,
            "Nam 2023-2024" ,
            "Nguoi Day 2"
        ) ,
        ClassInfo(
            "Machine Learning" ,
            "Nam 2023-2024" ,
            "Nguoi Day 3"
        ) ,
        ClassInfo(
            "Machine Learning" ,
            "Nam 2023-2024" ,
            "Nguoi Day 4"
        ) ,
    )
    LazyColumn()
    {
        items(listClass){
            OneClass(info = it , {nav.navigate("DetailClass")})
        }
    }
}
data class ClassInfo(
        val ClassName : String ,
        val Subtitle : String ,
        val Teacher : String
        )
@Composable
fun OneClass(info: ClassInfo , onClick: ()->Unit)
{
    Box(modifier = Modifier)
    {
        Card(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth() ,
        ) {
            Text(text = info.ClassName ,
                style = MaterialTheme.typography.titleMedium ,
                modifier = Modifier
                    .padding(5.dp))
            Text(text = info.Subtitle ,
                style = MaterialTheme.typography.labelMedium ,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Text(text = info.Teacher ,
                style = MaterialTheme.typography.labelLarge ,
                modifier =  Modifier
                    .padding(5.dp)
            )
        }
        IconButton(onClick = onClick ,
                    modifier = Modifier.padding(horizontal = 8.dp).align(Alignment.CenterEnd)
            ) {
            Icon(
                imageVector = Icons.Rounded.ExitToApp,
                contentDescription = null ,
            )
        }
    }

}
