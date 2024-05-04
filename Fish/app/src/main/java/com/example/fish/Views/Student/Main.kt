package com.example.fish.Views.Student

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fish.Controllers.getAllClass
import com.example.fish.Controllers.getListClassOfUser
import com.example.fish.Untils.goTo
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
    navFather : NavController
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
            when(viewModel.Title)
            {
                "Class" -> {
                    var search by remember { mutableStateOf("") }
                    CenterAlignedTopAppBar(title = {
                        TextField(
                            value = search,
                            placeholder = { Text(text = "Find Class" , textAlign = TextAlign.Center) },
                            onValueChange = {
                                search = it
                                getAllClass{
                                    viewModel.getMyClass(it){
                                        viewModel.filterMyClass(search)
                                    }
                                }
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
                "Home" -> {
                    CenterAlignedTopAppBar({
                            Text(text = "Lớp Học Của Tôi" ,
                                style = MaterialTheme.typography.labelLarge ,
                                fontSize = 28.sp
                            )
                        }
                    )
                }
                "Account" -> {
                    CenterAlignedTopAppBar({
                        Text(
                            text = "Tài Khoản Cá Nhân" ,
                            style = MaterialTheme.typography.labelLarge ,
                            fontSize = 28.sp
                        )
                    }
                    )
                }
                "ChangePass" , "UpdateInfo" , "Test"  -> {}
                else -> {
                    CenterAlignedTopAppBar(
                        title = {
                            val text = when(viewModel.Title)
                            {
                                "DetailClass" -> "Lớp Học"
                                "TestPrepare" -> "Bài Kiểm Tra"
                                "Result"      -> "Chi Tiết Bài Kiểm Tra"
                                else -> " "
                            }
                            Text(
                                text = text ,
                                style = MaterialTheme.typography.labelMedium ,
                                fontSize = 28.sp
                                )
                        } ,
                        navigationIcon = {
                            val goWhere = when(viewModel.Title)
                            {
                                "TestPrepare"   -> "DetailClass"
                                "Result"        -> "TestPrepare"
                                else            -> "Home"
                            }
                            IconButton(onClick = { goTo(navController , viewModel , goWhere) }) {
                                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                            }
                        }
                    )
                }
            }
        },
        bottomBar = {
            if(viewModel.Title in listOf<String>("Home" , "Account" , "Class" ,"ChangePass" , "UpdateInfo")  ){
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
            {
                getListClassOfUser(viewModel.info.uid){
                    viewModel.getMyClass(it)
                }
                HomeScreen(nav = navController , view = viewModel)
            }
            composable("Class")
            {
                getAllClass {
                    viewModel.getMyClass(it)
                }
                ClassScreen(nav = navController , view = viewModel)
            }
            composable("Account")
            { AccountScreen(nav = navController , view = viewModel , navFather = navFather) }
            composable("UpdateInfo")
            { UpdateInfo(nav = navController , view = viewModel) }
            composable("ChangePass")
            { ChangePassword(nav = navController , view = viewModel) }
            composable("DetailClass")
            { DetailClass(nav = navController , view = viewModel) }
            composable("TestPrepare")
            { TestPrepareView(nav = navController , view = viewModel) }
            composable("Test")
            { TestView(nav = navController , view = viewModel) }
            composable("Result")
            { ResultView(nav = navController, view = viewModel) }
            composable("ClassInfo")
            { ClassInfoView(nav = navController, view = viewModel) }
        }
    }
}