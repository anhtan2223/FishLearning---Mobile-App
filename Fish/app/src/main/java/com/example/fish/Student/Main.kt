package com.example.fish.Student

import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.getSystemService
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fish.ui.theme.DisplayUI

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
    navController : NavHostController = rememberNavController() ,
    viewModel:DisplayUI =  viewModel<DisplayUI>() ,
    onBackPressedDispatcher: OnBackPressedDispatcher
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
            if(viewModel.Title == "Class"){
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
            }
            else if(viewModel.Title == "DetailClass"){
                CenterAlignedTopAppBar(
                    title = { Text(text = "Lớp Học") } ,
                    navigationIcon = {
                        IconButton(onClick = { viewModel.changePage("Home") ; navController.navigate("Home") }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    }
                )
            }
            else if(viewModel.Title == "Home")
            {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Lớp Học Của Tôi" ,
                            style = MaterialTheme.typography.displaySmall)
                    }
                )
            }
            else{
                CenterAlignedTopAppBar(title = {
                    Text(
                        text = if (selected == 0) "Lớp Học Của Tôi" else if(selected == 2) "Tài Khoản Cá Nhân" else "",
                        style = MaterialTheme.typography.displaySmall
                    )
                })
            }
        },
        bottomBar = {
            if(viewModel.Title != "DetailClass"){
                NavigationBar {
                    item.forEachIndexed { index: Int, navItem: NavItem ->
                        NavigationBarItem(
                            selected = viewModel.Title == navItem.title,
                            onClick = {
                                selected = index
                                viewModel.changePage(navItem.title)
                                navController.navigate(viewModel.Title)
                            },
                            icon = {
                                Icon(
                                    imageVector = if (viewModel.Title == navItem.title) navItem.selected else navItem.unselected ,
                                    contentDescription = null )
                            })
                    }
//                    Text(text = viewModel.Title)
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
            { HomeScreen(nav = navController , view = viewModel) }
            composable("Class")
            { ClassScreen(nav = navController , view = viewModel) }
            composable("Account")
            { AccountScreen(nav = navController , view = viewModel) }
            composable("UpdateInfo")
            { UpdateInfo(nav = navController , view = viewModel) }
            composable("ChangePass")
            { ChangePassword(nav = navController , view = viewModel) }
            composable("DetailClass")
            { DetailClass(nav = navController , view = viewModel) }
            composable("TestPrepare")
            { TestPrepareView(nav = navController , view = viewModel) }
        }
    }
}