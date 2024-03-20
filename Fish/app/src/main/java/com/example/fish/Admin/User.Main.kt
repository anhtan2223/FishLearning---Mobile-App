package com.example.fish.Admin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Model.Back
import com.example.fish.Model.DemoData
import com.example.fish.Model.User
import com.example.fish.Model.goTo
import com.example.fish.ui.theme.DisplayUI

@Composable
fun MainUserView(nav : NavController , view : DisplayUI)
{
    val listUser = DemoData.ListUser
    Back(nav = nav, view = view)
    LazyColumn()
    {
        items(listUser){
            OneUser_Admin(info = it , { goTo(nav , view , "DetailUser") ; view.chooseUser(it) })
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp) ,
        contentAlignment = Alignment.BottomEnd
    ){
        FloatingActionButton(
            shape = CircleShape,
            onClick = { goTo(nav , view , "NewUser" ) }
        )
        {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }
    }
}

@Composable
fun OneUser_Admin(info : User , onClick : ()->Unit )
{
    Box(modifier = Modifier)
    {
        Card(modifier = Modifier
            .padding(5.dp)
            .clickable { onClick() }
            .fillMaxWidth() ,
//            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            val nameRole = when(info.RoleID)
            {
                3 -> "Admin"
                2 -> "Người Dạy"
                else -> "Người Học"
            }
            Text(text = info.Name ,
                style = MaterialTheme.typography.titleMedium ,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 18.dp  , bottom = 6.dp , top = 18.dp) )
            Text(text = info.Email ,
                style = MaterialTheme.typography.labelMedium ,
                fontSize = 12.sp ,
                modifier = Modifier
                    .padding(start = 18.dp  , bottom = 6.dp)
            )
            Text(text = nameRole ,
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
                imageVector = Icons.Rounded.Edit,
                contentDescription = null ,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}