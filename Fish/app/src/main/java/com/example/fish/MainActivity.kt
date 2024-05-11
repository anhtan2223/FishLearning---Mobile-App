package com.example.fish

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fish.Controllers.isValidUsername
import com.example.fish.Controllers.login
import com.example.fish.Controllers.registerUser
import com.example.fish.Models.HandleUser
import com.example.fish.Untils.User
import com.example.fish.Untils.ValidValue
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.uploadPDF
import com.example.fish.Views.Admin.AdminView
import com.example.fish.Views.Student.ButtonNav
import com.example.fish.Views.Student.OneLineChange
import com.example.fish.Views.Student.StudentView
import com.example.fish.Views.Teacher.TeacherView
import com.example.fish.ui.theme.DisplayUI
import com.example.fish.ui.theme.FishTheme

val TAG = "TestInMain"

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = this
        setContent {
            FishTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val nav:NavHostController = rememberNavController()
                    val view = viewModel<DisplayUI>()
                    NavHost(
                        navController = nav,
                        startDestination = "Login")
                    {
                        composable("Student")
                        { StudentView(navFather = nav , viewModel = view ) }
                        composable("Teacher" )
                        { TeacherView(navFather = nav , viewModel = view , getContent = getContent) }
                        composable("Admin" )
                        { AdminView(navFather = nav , viewModel = view) }
                        composable("Login" )
                        { LoginView(nav , view) }
                        composable("SignIn")
                        { SignInView(nav) }
                        composable("Test")
                        { TestRoom(activity , getContent) }
                    }
                }
            }
        }
    }

    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()){
        if (it != null) {
            appendMessage(this , "Đang Upload Tài Liệu Vui Lòng Chờ")
            uploadPDF(it){
                appendMessage(this.baseContext , "Đã Upload Tài Liệu Thành Công")
            }
        }
    }

}

@Composable
fun LoginView(nav:NavController , view:DisplayUI)
{
    var context = LocalContext.current
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
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
            OneLineChange(title = "Tài Khoản", content = "Tài Khoản Đăng Nhập", readOnly = false ,
                onChange = {
                    username = it
                }
                )
            OneLineChange(title = "Mật Khẩu", content = "Mật Khẩu Đăng Nhập", readOnly = false , visual = PasswordVisualTransformation() ,
                onChange = {
                    password = it
                }
            )
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
            ButtonNav(onClick = {
                login(
                    username ,
                    password ,
                    onUserFalse = {
                                  appendMessage(context , "Tài Khoản Không Tồn Tại")
                    } ,
                    onUserTrue = { isTrue , info ->
                            if(isTrue){
                                val destination = when(info.roleid){
                                    3 -> "Student"
                                    2 -> "Teacher"
                                    1 -> "Admin"
                                    else -> "Test"
                                }
                                appendMessage(context,"Chào Mừng $destination ${info.name} Đã Quay Trở lại")
                                view.setMyInfo(info)
                                nav.navigate(destination)
                            }else
                                appendMessage(context,"Mật Khẩu Không Đúng")
                    }
                    )

            }, content = "Đăng Nhập")
            ButtonNav(onClick = { nav.navigate("Test") }, content = "Test Room")
        }
    }
    Row(
        verticalAlignment = Alignment.Bottom ,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ButtonNav(onClick =
        {
            nav.navigate("Student")
            HandleUser.getUserById("user") {
                view.setMyInfo(it ?: User())
            }
        }, content = "Student")
        ButtonNav(onClick = {
            nav.navigate("Teacher")
            HandleUser.getUserById("teacher") {
                view.setMyInfo(it ?: User())
            }
        }, content = "Teacher")
        ButtonNav(onClick = {
            nav.navigate("Admin")
            HandleUser.getUserById("admin") {
                view.setMyInfo(it ?: User())
            }
        }, content = "Admin")
    }
}
@Composable
fun SignInView(nav:NavController)
{
    val info by remember {
      mutableStateOf(User())
    }
    var rePass by remember {
        mutableStateOf("")
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

            OneLineChange(title = "Tài Khoản", content = "Tài Khoản Đăng Nhập", readOnly = false ,
                onChange = {
                    info.username = it
//                    Log.d("TAG", "SignInView: ${info} ${ValidValue.isValidUsername(it)}")
                } ,
                onFocusChange = {
                    if(!it.isFocused && info.username.length !=0)
                    {
                        isValidUsername(info.username){
                            if(it)
                                appendMessage(context , "Tài Khoản Đã Có Người Khác Đăng Ký")
                            else if(!ValidValue.isValidUsername(info.username))
                                appendMessage(context , "Tài Khoản Phải Lớn Hơn 6 Ký tự")
                        }
                    }
                }
            )

            OneLineChange(title = "Mật Khẩu", content = "Mật Khẩu Đăng Nhập", readOnly = false ,
                visual = PasswordVisualTransformation(),
                onChange = {
                    info.password = it
                    Log.d("TAG", "SignInView: ${info}")
                } ,
                onFocusChange = {
                    if(!it.isFocused && info.password.length != 0 && !ValidValue.isValidPassword(info.password))
                        appendMessage(context , "Mật Khẩu Phải Lớn Hơn 8 Ký Tự")
                }
             )

            OneLineChange(title = "Nhập Lại Mật Khẩu", content = "Xác nhận Mật Khẩu", readOnly = false ,
                visual = PasswordVisualTransformation() ,
                onChange = {
                           rePass = it
                    } ,
                onFocusChange = {
                    if(!it.isFocused && rePass.length !=0 && info.password != rePass)
                            appendMessage(context , "Mật Khẩu Nhập Lại Chưa Đúng")
                }
            )
            OneLineChange(title = "Họ Và Tên", content = "Tên của Bạn",
                onChange = {
                    if(it.length == 0)
                        appendMessage(context , "Không thể để trống Tên")
                    info.name = it
                } ,
                onFocusChange = {
                    if(!it.isFocused && info.name.isNotEmpty() && !ValidValue.isValidName(info.name) )
                        appendMessage(context , "Tên Không Vượt Quá 50 Ký tự")
                }
            )
            OneLineChange(title = "Email", content = "Email Đăng Ký",
                onChange = {
                    info.email = it
                } ,
                onFocusChange = {
                    if(!it.isFocused && info.email.isNotEmpty() && !ValidValue.isValidEmail(info.email) )
                        appendMessage(context , "Email Không Hợp Lệ")
                }
            )
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
                if( !ValidValue.isValidUsername(info.username) ) {
                    appendMessage(context , "Tài Khoản Phải Lớn Hơn 6 Ký tự")
                    isValidUsername(info.username){
                        if(it)
                            appendMessage(context , "Tài Khoản Đã Có Người Khác Đăng Ký") ;
                    }
                    return@ButtonNav
                }

                if(!ValidValue.isValidPassword(info.password)){
                    appendMessage(context , "Mật Khẩu Phải Lớn Hơn 8 Ký Tự")
                    return@ButtonNav
                }

                if(info.password != rePass){
                    appendMessage(context , "Mật Khẩu Nhập Lại Không Hợp Lệ")
                    return@ButtonNav
                }
                if(!ValidValue.isValidPassword(info.email)){
                    appendMessage(context , "Email Không Hợp Lệ")
                    return@ButtonNav
                }

                registerUser(info)
                appendMessage(context , "Tạo Tài Khoản Thành Công")
                nav.navigate("Login")

            }, content = "Đăng Ký")
        }
    }
}
