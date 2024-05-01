package com.example.fish

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fish.Admin.AdminView
import com.example.fish.Controller.registerUser
import com.example.fish.Untils.User
import com.example.fish.Untils.appendMessage
import com.example.fish.Student.ButtonNav
import com.example.fish.Student.OneLineChange
import com.example.fish.Student.StudentView
import com.example.fish.Teacher.TeacherView
import com.example.fish.ui.theme.FishTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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
                        { TeacherView(navFather = nav) }
                        composable("Admin")
                        { AdminView(navFather = nav) }
                        composable("Login")
                        { LoginView(nav) }
                        composable("SignIn")
                        { SignInView(nav) }
                        composable("Test")
                        { TestRoom() }
                    }
                }
            }
        }
    }
}

@Composable
fun LoginView(nav:NavController)
{
    var context = LocalContext.current
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
            ButtonNav(onClick = { nav.navigate("Test") }, content = "Test Room")
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
    val info by remember {
      mutableStateOf(User())
    }
    val context = LocalContext.current
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

            OneLineChange(title = "Tài Khoản", content = "Tài Khoản Đăng Nhập", readOnly = false , onChange = {
                info.username = it
                Log.d("TAG", "SignInView: ${info}")
            })
            OneLineChange(title = "Mật Khẩu", content = "Mật Khẩu Đăng Nhập", readOnly = false , onChange = {
                info.password = it
                Log.d("TAG", "SignInView: ${info}")

            })
            OneLineChange(title = "Nhập Lại Mật Khẩu", content = "Xác nhận Mật Khẩu", readOnly = false , onChange = {
                if (it != info.username)
                    Log.d("Error" , "Wrong Password")
            })
            OneLineChange(title = "Họ Và Tên", content = "Tên của Bạn", readOnly = false , onChange = {
                info.name = it
            } )
            OneLineChange(title = "Email", content = "Email Đăng Ký", readOnly = false , onChange = {
                info.email = it
            } )
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
            ButtonNav(onClick =
            {
//                Log.d("Test", "SignInView: ${info}")
//                Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
                appendMessage(context , "Success")
                registerUser(info)
            }, content = "Đăng Ký")
        }
    }
}
