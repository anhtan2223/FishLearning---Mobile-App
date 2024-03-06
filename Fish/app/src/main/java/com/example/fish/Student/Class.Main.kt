package com.example.fish.Student

import androidx.compose.foundation.layout.Box
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
import com.example.fish.Model.Back
import com.example.fish.Model.Class
import com.example.fish.Model.DemoData
import com.example.fish.ui.theme.DisplayUI

@Composable
fun ClassScreen(modifier: Modifier = Modifier, search:String="", nav: NavController , view : DisplayUI)
{
    val listClass = DemoData.ListClass
    Back(nav = nav, view = view)
    LazyColumn()
    {
        items(listClass){
            OneClass(info = it , {nav.navigate("DetailClass") ; view.changePage("DetailClass") ; view.selectClass(it) })
        }
    }
}
@Composable
fun OneClass(info:Class , onClick: ()->Unit)
{
    Box(modifier = Modifier)
    {
        Card(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth() ,
        ) {
            Text(text = info.NameClass ,
                style = MaterialTheme.typography.titleMedium ,
                modifier = Modifier
                    .padding(5.dp))
            Text(text = info.Subtitle ,
                style = MaterialTheme.typography.labelMedium ,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Text(text = info.TeacherID ,
                style = MaterialTheme.typography.labelLarge ,
                modifier =  Modifier
                    .padding(5.dp)
            )
        }
        IconButton(onClick = onClick ,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.CenterEnd)
            ) {
            Icon(
                imageVector = Icons.Rounded.ExitToApp,
                contentDescription = null ,
            )
        }
    }

}
