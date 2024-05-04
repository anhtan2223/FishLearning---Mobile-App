package com.example.fish.Views.Admin

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
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
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
import com.example.fish.Untils.Back
import com.example.fish.Untils.User
import com.example.fish.Untils.goTo
import com.example.fish.ui.theme.DisplayUI

@Composable
fun MainUserView(nav : NavController , view : DisplayUI)
{
    var listUser by remember {
        mutableStateOf(mutableListOf<User>())
    }
//    getUserList {
//        listUser = it
//    }
//    view.getUL()
    listUser = view.userList
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
            val nameRole = when(info.roleid)
            {
                1 -> "Admin"
                2 -> "Người Dạy"
                else -> "Người Học"
            }
            Text(text = info.name ,
                style = MaterialTheme.typography.titleMedium ,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 18.dp  , bottom = 6.dp , top = 18.dp) )
            Text(text = info.email ,
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