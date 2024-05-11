package com.example.fish.Views.Teacher

import android.os.Build
import androidx.activity.result.ActivityResultLauncher
import androidx.annotation.RequiresApi
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
import com.example.fish.Controllers.getClassByTeacher
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.AccountScreen
import com.example.fish.Views.Student.ChangePassword
import com.example.fish.Views.Student.NavItem
import com.example.fish.Views.Student.ResultView
import com.example.fish.Views.Student.UpdateInfo
import com.example.fish.ui.theme.DisplayUI

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeacherView(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController : NavHostController = rememberNavController(),
    viewModel: DisplayUI =  viewModel<DisplayUI>(),
    navFather : NavController ,
    getContent: ActivityResultLauncher<String>
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
        Scaffold(
            topBar = {
                when(viewModel.Title)
                {
                    "Home" , "Class" -> {
                        var search by remember { mutableStateOf("") }
                        CenterAlignedTopAppBar(title = {
                            TextField(
                                value = search,
                                placeholder = { Text(text = "Find Class" , textAlign = TextAlign.Center) },
                                onValueChange = { values ->
                                    search = values
                                    if(viewModel.Title == "Home"){
                                        getClassByTeacher(viewModel.info.uid){
                                            viewModel.getMyClass(it){
                                                viewModel.filterMyClass(values)
                                            }
                                        }
                                    }
                                    else{
                                        getAllClass{
                                            viewModel.getMyClass(it){
                                                viewModel.filterMyClass(values)
                                            }
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
                                    "TestResult" -> "Kết Quả Kiểm Tra"
                                    "NewClass" -> "Tạo Lớp Mới"
                                    "DocumentDetail" -> "Thông Tin Tài Liệu"
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
                                    "TestResult" , "ClassInfo" ,"DocumentDetail"  -> "DetailClass"
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
                if(viewModel.Title in listOf<String>("Home" , "Account" , "Class" ,"ChangePass" , "UpdateInfo")  ){
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
                {
                    getClassByTeacher(viewModel.info.uid){
                        viewModel.getMyClass(it)
                    }
                    TeacherHomeScreen(nav = navController , view = viewModel)
                }
                composable("Class")
                {
                    getAllClass(){
                        viewModel.getMyClass(it)
                    }
                    ClassScreen_Teacher(nav = navController , view = viewModel)
                }
                composable("Account")
                { AccountScreen(nav = navController , view = viewModel , navFather = navFather) }
                composable("UpdateInfo")
                { UpdateInfo(nav = navController , view = viewModel) }
                composable("ChangePass")
                { ChangePassword(nav = navController , view = viewModel) }
                composable("DetailClass")
                { Teacher_DetailClass(nav = navController , view = viewModel) }
                composable("TestResult")
                { TestResult(nav = navController , view = viewModel) }
                composable("NewClass")
                { NewClassView(nav = navController, view = viewModel) }
                composable("ClassInfo")
                { ClassInfoView(nav = navController, view = viewModel) }
                composable("ChangeQues")
                { ChangeQuestionView(nav = navController, view = viewModel) }
                composable("SumTest")
                { SummaryTestView(nav = navController, view = viewModel) }
                composable("DocumentDetail")
                { DocumentDetailView(nav = navController, view = viewModel , getContent = getContent) }
                composable("Result")
                { ResultView(nav = navController, view = viewModel) }
            }
        }
    }