package com.example.fish.Views.Admin

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.AccountScreen
import com.example.fish.Views.Student.ChangePassword
import com.example.fish.Views.Student.DetailClass
import com.example.fish.Views.Student.HomeScreen
import com.example.fish.Views.Student.UpdateInfo
import com.example.fish.ui.theme.DisplayUI
import com.example.fish.ui.theme.NavItem

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminView(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController : NavHostController = rememberNavController(),
    viewModel: DisplayUI =  viewModel<DisplayUI>(),
    navFather : NavController
) {
    val item = listOf<NavItem>(
        NavItem(
            "Home" ,
            Icons.Default.Home ,
            Icons.Outlined.Home
        ) ,
        NavItem(
            "User" ,
            Icons.Default.Face ,
            Icons.Outlined.Face
        ) ,
        NavItem(
            "Account" ,
            Icons.Default.AccountCircle ,
            Icons.Outlined.AccountCircle
        )
    )
    Scaffold(
        topBar = {
            when(viewModel.Title)
            {
                "Home" , "User" -> {
                    var search by remember { mutableStateOf("") }
                    CenterAlignedTopAppBar(title = {
                        val text = when(viewModel.Title)
                        {
                            "Home" -> "Find Class"
                            "User" -> "Find User"
                            else   -> ""
                        }
                        TextField(
                            value = search,
                            placeholder = { Text(text = text , textAlign = TextAlign.Center , style = MaterialTheme.typography.labelMedium) },
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
                "ChangePass" , "UpdateInfo" , "ChangeQues" -> {}
                else -> {
                    CenterAlignedTopAppBar(
                        title = {
                            val text = when(viewModel.Title)
                            {
                                "DetailClass" -> "Lớp Học"
                                "TestPrepare" -> "Thông Tin Bài Kiểm Tra"
                                "NewClass" -> "Tạo Lớp Mới"
                                "TestSummary" -> "Thống Kê Lớp Học"
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
                                "TestPrepare" , "ClassInfo"  -> "DetailClass"
                                else                        -> "Home"
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
            if(viewModel.Title in listOf<String>("Home" , "Account" , "User" ,"ChangePass" , "UpdateInfo")  ){
                NavigationBar {
                    item.forEachIndexed { index: Int, navItem: NavItem ->
                        NavigationBarItem(
                            selected = viewModel.Title == navItem.title,
                            onClick = {
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
            composable("User")
            { MainUserView(nav = navController , view = viewModel) }
            composable("Account")
            { AccountScreen(nav = navController , view = viewModel , navFather = navFather) }
            composable("UpdateInfo")
            { UpdateInfo(nav = navController , view = viewModel) }
            composable("ChangePass")
            { ChangePassword(nav = navController , view = viewModel) }
            composable("DetailClass")
            { DetailClass(nav = navController , view = viewModel) }
            composable("NewUser")
            { NewUserView(nav = navController, view = viewModel) }
            composable("DetailUser")
            { DetaiUserView(nav = navController, view = viewModel) }
            composable("ClassInfo")
            { ClassInfoView_Admin(nav = navController, view = viewModel) }
            composable("TestPrepare")
            { TestPrepareView_Admin(nav = navController, view = viewModel) }
            composable("TestSummary")
            { SummaryTestView_Admin(navController , viewModel) }
        }
    }
}