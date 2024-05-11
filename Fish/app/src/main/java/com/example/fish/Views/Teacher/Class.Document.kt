package com.example.fish.Views.Teacher

import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fish.Controllers.changeDocument
import com.example.fish.Controllers.deleteItemTopic
import com.example.fish.Controllers.updateItemTopic
import com.example.fish.Untils.AddAlert
import com.example.fish.Untils.Back
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.ButtonNav
import com.example.fish.ui.theme.DisplayUI

@Composable
fun DocumentDetailView(nav:NavController , view:DisplayUI , getContent: ActivityResultLauncher<String>){
    Back(nav = nav, view = view , "DetailClass")
    Spacer(modifier = Modifier.padding(vertical = 25.dp))
    DocumentInfo_Teacher(nav = nav, view = view){
            getContent.launch("application/pdf")
    }
}

@Composable
fun DocumentInfo_Teacher(nav : NavController, view: DisplayUI , onUpdate:()->Unit)
{
    val context = LocalContext.current
    var isDelete by remember {
        mutableStateOf(false)
    }
    AddAlert(
        isShow = isDelete ,
        content = "Xác Nhận Xoá Tài Liệu " ,
        onCancel = { isDelete = false } ,
        onConfirm = {
            appendMessage(context , "Xoá Bài Tài Liệu Thành Công")
            deleteItemTopic(view.nowClass.classID , view.nowDocument.topicID , view.nowDocument.docID)
            goTo(nav , view , "DetailClass")
            isDelete= false
        }
    )
    Column(
        modifier = Modifier.padding(start = 20.dp , top = 50.dp)
    ) {
//        OneLine(title = "Tên Tài Liệu", content = classInfo.nameClass)
        OneInputBasic(title = "Mô Tả ", content = view.nowDocument.discribe ){
            if(it.isEmpty()){
                appendMessage(context , "Không Thể Để Trống Tên Lớp")
                return@OneInputBasic
            }
            updateItemTopic(view.nowClass.classID , view.nowDocument.copy(discribe = it))
        }
//        OneLine(title = "Tài Liệu", content = "Document in Here")

        Spacer(modifier = Modifier.padding(15.dp))
        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ButtonNav(
                onClick = {
                    onUpdate()
                } ,
                content = if(view.nowDocument.link == "") "Tải Tài Liệu Mới" else "Cập Nhật Tài Liệu",
                color = Color(0xFF00FC46)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ButtonNav(
                onClick = {
                    changeDocument(view.nowClass.classID , view.nowDocument)
                    appendMessage(context , "Cập Nhật Tài Liệu Thành Công")
                } ,
                content = "Xác Nhận Cập Nhật Tài Liệu",
                color = Color(0xFF00FC46)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
            ) {
            ButtonNav(
                onClick = {
                    isDelete = true
                },
                content = "Xoá Tài Liệu",
                color = Color(0xFFDC0F0F),
                contentColor = Color.White
            )
        }
    }
}