package com.example.fish.Untils

import android.app.Activity
import android.content.Context
import com.example.fish.R
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fish.Views.Student.ButtonNav
import com.example.fish.ui.theme.DisplayUI
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.UUID

@Composable
fun Back(nav: NavController, view: DisplayUI ,  goTo:String = "Home")
{
    BackHandler(enabled = true , onBack = {
        nav.navigate(goTo)
        view.changePage(goTo)
    })
}
fun goTo(nav: NavController , view: DisplayUI , goTo:String )
{
    nav.navigate(goTo)
    view.changePage(goTo)
}
fun formatTime(seconds: Int): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val remainingSeconds = seconds % 60
    return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds)
}
@RequiresApi(Build.VERSION_CODES.O)
fun getToday():String{
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return formatter.format(today)
}
fun stringToDate(input:String):Date{
    return SimpleDateFormat("dd/MM/yyyy").parse(input)
}
fun dateToString(input: Date):String{
//    SimpleDateFormat.getDateInstance()
    return SimpleDateFormat("dd/MM/yyyy").format(input)
}

fun appendMessage(context:android.content.Context , message:String ){
    Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAlert(
        isShow:Boolean ,
        content : String = "",
        onCancel:()->Unit = {} ,
        onConfirm:()->Unit = {} ,
        title :String = "Thông Báo" ,
        confirm :String = "Xác Nhận" ,
        dismiss : String = "Huỷ" ,
){
    if(isShow){
        AlertDialog(
            onDismissRequest = { /*TODO*/ }) {
            Column(
                modifier = Modifier.background(color = Color.Transparent)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium ,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.padding(vertical= 5.dp))
                Text(
                    text = content,
                    style = MaterialTheme.typography.titleSmall ,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.padding(vertical= 5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth() ,
                    verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.Center
                ) {
                    ButtonNav(
                        onClick = { onConfirm() },
                        content = confirm ,
                        color = Color(0xFF00FC46)
                    )
                    ButtonNav(
                        onClick = { onCancel() },
                        content = dismiss ,
                        color = Color(0xFFDC0F0F) ,
                        contentColor = Color.White
                    )
                }
            }
        }
    }
}
@Composable
fun runDispatcherDefault(handle:()->Unit){
    LaunchedEffect(Unit){
        launch(Dispatchers.Default) {
            handle()
        }
    }
}
@Composable
fun WaitingScreen(content: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = content ,
            style = MaterialTheme.typography.titleSmall ,
            fontSize = 20.sp
        )
    }
}

fun selectPDF(activity: Activity){
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.setType("application/pdf")
    intent.addCategory(Intent.CATEGORY_OPENABLE)
    activity.startActivityForResult(Intent.createChooser(intent , "Select PDF File") , 123)
}
fun uploadPDF(data : Uri , onUpload:()->Unit = {}){
    var storeRef = Firebase.storage.reference
    var pdf = storeRef.child("pdf/${UUID.randomUUID()}.pdf")
    pdf.putFile(data)
        .addOnSuccessListener {
            val uriTask = it.storage.downloadUrl
            while (!uriTask.isComplete) ;
            val uri = uriTask.getResult()
            MyDB.document.setValue(uri.toString())
            onUpload()
        }
}
fun downloadPDF(context: Context ,  URL:String){
//    var ref = Firebase.storage.reference
    var uri = Uri.parse(URL)
    val intent = Intent(Intent.ACTION_VIEW , uri)
    context.startActivity(intent)
}
@Composable
fun RecognizeTextIcon(modifier: Modifier = Modifier , onGetText:(String)->Unit){
    var context = LocalContext.current
    selectImage(modifier){
        val recognize = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
        val image:InputImage = getImage(context,it)
        recognize.process(image).addOnSuccessListener {
            onGetText(it.text)
        }
    }
}
@Composable
fun selectImage(modifier:Modifier = Modifier , onGetURI:(Uri)->Unit){
    val chooseImage = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK)
            it.data?.data?.let {
                onGetURI(it)
            }
    }
    IconButton(modifier = modifier , onClick = { openImageChooser(chooseImage) }) {
        Icon(painter = painterResource(id = R.drawable.social_15049667), contentDescription = null)
    }
}
fun getImage(context:Context, uri:Uri): InputImage {
    var image: InputImage
    image = InputImage.fromFilePath(context, uri)
    return image
}
private fun openImageChooser(chooseImageLauncher: ActivityResultLauncher<Intent>) {
    val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    chooseImageLauncher.launch(intent)
}
