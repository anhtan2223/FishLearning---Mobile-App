package com.example.fish

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fish.Admin.AdminView
import com.example.fish.Model.goTo
import com.example.fish.Student.ButtonNav
import com.example.fish.Student.OneLineChange
import com.example.fish.Student.StudentView
import com.example.fish.Teacher.TeacherView
import com.example.fish.ui.theme.DisplayUI
import com.example.fish.ui.theme.FishTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FishTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val nav:NavHostController = rememberNavController()
                    NavHost(
                        navController = nav,
                        startDestination = "Login")
                    {
                        composable("Student")
                        { StudentView(navFather = nav) }
                        composable("Teacher")
                        { TeacherView() }
                        composable("Admin")
                        { AdminView() }
                        composable("Login")
                        { LoginView(nav) }
                        composable("SignIn")
                        { SignInView(nav) }
                    }
                }
            }
        }
    }
}

@Composable
fun LoginView(nav:NavController)
{
    Column(
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ) {
            Spacer(modifier = Modifier.padding(top=15.dp))
            Text(
                text = "Đăng Nhập" ,
                style = MaterialTheme.typography.titleSmall ,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(bottom = 5.dp ))
            OneLineChange(title = "Tài Khoản", content = "Tài Khoản Đăng Nhập", readOnly = false )
            OneLineChange(title = "Mật Khẩu", content = "Tài Khoản Đăng Nhập", readOnly = false , visual = VisualTransformation.None )
            Spacer(modifier = Modifier.padding(top = 30.dp))
            Text(
                text = "Chưa Có Tài Khoản ? Đăng Ký Ngay !" ,
                style = MaterialTheme.typography.labelLarge ,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable { nav.navigate("SignIn") }
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.SpaceAround ,
            modifier =  Modifier.padding(top = 10.dp)
        ) {
            ButtonNav(onClick = { /*TODO*/ }, content = "Đăng Nhập")
        }
    }
    Row(
        verticalAlignment = Alignment.Bottom ,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ButtonNav(onClick = { nav.navigate("Student") }, content = "Student")
        ButtonNav(onClick = { nav.navigate("Teacher") }, content = "Teacher")
        ButtonNav(onClick = { nav.navigate("Admin") }, content = "Admin")
    }
}
@Composable
fun SignInView(nav:NavController)
{
    Column(
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.95f)
        ) {
            Spacer(modifier = Modifier.padding(top = 25.dp))
            Text(
                text = "Đăng Ký" ,
                style = MaterialTheme.typography.titleSmall ,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(bottom = 5.dp))
            OneLineChange(title = "Tài Khoản", content = "Tài Khoản Đăng Nhập", readOnly = false )
            OneLineChange(title = "Mật Khẩu", content = "Mật Khẩu Đăng Nhập", readOnly = false  )
            OneLineChange(title = "Nhập Lại Mật Khẩu", content = "Xác nhận Mật Khẩu", readOnly = false  )
            OneLineChange(title = "Họ Và Tên", content = "Tên của Bạn", readOnly = false  )
            OneLineChange(title = "Email", content = "Email Đăng Ký", readOnly = false  )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Text(
                text = "Đã Có Tài Khoản ? Đăng Nhập Ngay !" ,
                style = MaterialTheme.typography.labelLarge ,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable { nav.navigate("Login") }
            )
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.SpaceAround ,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            ButtonNav(onClick = { /*TODO*/ }, content = "Đăng Ký")
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FishTheme {
//        Surface(Modifier.fillMaxSize()) {
//            ClassScreen()
//        }
////        FishLearning()
//    }
//}