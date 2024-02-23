package com.example.fish.Student

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

data class NavItem(
    val title : String,
    val selected : ImageVector,
    val unselected : ImageVector,
)
data class UserInfo(
    val Name:String ,
    val Email:String ,
    val Username:String ,
    val Password:String
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentView(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController : NavHostController = rememberNavController()
)
{
    val item = listOf<NavItem>(
        NavItem(
            "Home" ,
            Icons.Default.Home ,
            Icons.Outlined.Home
        ) ,
        NavItem(
            "Class" ,
            Icons.Default.Search ,
            Icons.Outlined.Search
        ) ,
        NavItem(
            "Account" ,
            Icons.Default.AccountCircle ,
            Icons.Outlined.AccountCircle
        )
    )
    var selected by remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            if(selected == 1){
                var search by remember { mutableStateOf("") }
                CenterAlignedTopAppBar(title = {
                    TextField(
                        value = search,
                        placeholder = { Text(text = "Find Class" , textAlign = TextAlign.Center) },
                        onValueChange = {
                            search = it
                        },
                        shape = CircleShape,
                        modifier = Modifier
                            .padding(5.dp) ,
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                    )
                })
            }else{
                CenterAlignedTopAppBar(title = {
                    Text(
                        text = if (selected == 0) "Lớp Học Của Tôi" else if(selected == 2) "Tài Khoản Cá Nhân" else "",
                        style = MaterialTheme.typography.displaySmall
                    )
                })
            }
        },
        bottomBar = {
            NavigationBar {
                item.forEachIndexed { index: Int, navItem: NavItem ->
                    NavigationBarItem(
                        selected = selected == index,
                        onClick = {
                            selected = index
                            navController.navigate(navItem.title)
                        },
                        icon = {
                            Icon(
                                imageVector = if (selected == index) navItem.selected else navItem.unselected ,
                                contentDescription = null )
                        })
                }
            }
        }
    ) {
        NavHost(
            navController = navController ,
            startDestination = "Home" ,
            modifier = Modifier.padding(it)
        ){
            composable("Home")
            { HomeScreen(nav = navController) }
            composable("Class")
            { ClassScreen(nav = navController) }
            composable("Account")
            { AccountScreen(nav = navController) }
            composable("UpdateInfo")
            { UpdateInfo(nav = navController) }
            composable("ChangePass")
            { ChangePassword(nav = navController) }
            composable("DetailClass")
            { DetailClass(nav = navController) }
        }
    }
}