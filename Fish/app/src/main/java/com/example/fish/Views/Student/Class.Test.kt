package com.example.fish.Views.Student

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.fish.Controllers.addResult
import com.example.fish.R
import com.example.fish.Untils.Answer
import com.example.fish.Untils.Result
import com.example.fish.Untils.formatTime
import com.example.fish.Untils.getToday
import com.example.fish.Untils.goTo
import com.example.fish.ui.theme.DisplayUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TestView( nav: NavController, view : DisplayUI)
{
    BackHandler { view.toogleChoose() }

    if(view.isTimeout)
    {
        view.toogleChoose() ;
        addResult(
            Result(
                studentID = view.info.uid ,
                testID = view.nowTest.testID ,
                result = view.listDetailResult ,
                dateCreate = getToday()
            )
        )
        goTo(nav , view , "Result")
    }
    QNA(
        nav = nav ,
        view = view ,
        goBack = {  view.timeOut() }
    )
}
@Composable
fun OneAnswer(A:Answer , isChoose:Boolean ,  onClick:() -> Unit ,   )
{
    val CardColors = if(isChoose) Color(0xFFFFAB40) else Color(0xFF444444)
    val TextColor = if(isChoose) Color.Black else Color.White

    Card(
        Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(0.9f)
            .clickable { onClick() }
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .background(CardColors)
                .padding(10.dp) ,
            text = A.detail ,
            style = MaterialTheme.typography.labelMedium ,
            fontSize = 16.sp ,
            textAlign = TextAlign.Center ,
            lineHeight = 20.sp ,
            color = TextColor
        )
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun QNA( nav: NavController , view : DisplayUI  ,  goBack:() -> Unit)
{


    var detail by remember {
        mutableStateOf(view.listDetailResult[view.nowIndexQuestion].question)
    }
    var listA by remember {
        mutableStateOf( view.listDetailResult[view.nowIndexQuestion].answer )
    }

    if(view.isChoose)
        ChooseQuestion(nav , view){
            detail = view.listDetailResult[view.nowIndexQuestion].question
            listA = view.listDetailResult[view.nowIndexQuestion].answer
        }

    LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp)
    )
    {
        //Timer
        item {
            Box{
                Timer(time = view.nowTest.time , { goBack() })
                Row(Modifier.padding(10.dp)) {
                    Spacer(modifier = Modifier.weight(0.8f))
                    IconButton(
                        modifier = Modifier
                            .size(25.dp)
                            .weight(0.2f),
                        onClick = { view.toogleChoose() }
                    )
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.list_solid),
                            contentDescription = null
                        )
                    }
                }

            }
        }
        item {
            //Question
            Card(
                Modifier
                    .padding(bottom = 40.dp, top = 50.dp)
                    .fillMaxWidth(0.9f)
                    .clickable {
                        view.moveNextQues()
                        detail = view.listDetailResult[view.nowIndexQuestion].question
                        listA = view.listDetailResult[view.nowIndexQuestion].answer
                    } ,
                colors = CardDefaults.cardColors(Color(0xFF6D6D6D))
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp) ,
                    text = detail,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 25.sp ,
                    color = Color.White
                )
            }
        }
        items(listA) {
                OneAnswer(
                    A = it,
                    onClick = {
                        view.chooseAnswer(it.ansID)
                        detail = view.listDetailResult[view.nowIndexQuestion].question
                        listA = view.listDetailResult[view.nowIndexQuestion].answer
                    } ,
                    isChoose = view.answerList[view.nowIndexQuestion] == it.ansID
                )
        }
    }
}
@Composable
fun OneNumber(onClick : ()-> Unit , content:String , isChoose:Boolean )
{
    var borderColor = when(isChoose){
        true -> Color(0xFF1CCF39)
        false -> Color.White
    }
    Box(
        modifier = Modifier
            .padding(10.dp)
            .clickable { onClick() }
            .background(Color.Transparent)
            .border(2.dp, borderColor, CircleShape)
            .graphicsLayer { shape = CircleShape }
    ){
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            text = content ,
            style = MaterialTheme.typography.labelLarge ,
            fontSize = 25.sp ,
            maxLines = 1 ,
            color = borderColor
        )
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChooseQuestion(nav: NavController , view : DisplayUI , changeQuestion:()->Unit)
{
    Dialog( onDismissRequest = {  })
    {
        BackHandler {
            view.toogleChoose()
        }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonNav(
                    onClick = { view.toogleChoose() },
                    content = "Quay Lại" ,
                    color = Color.Transparent ,
                    contentColor = Color.White
                )
                LazyVerticalGrid(columns = GridCells.Adaptive(60.dp) )
                {
                    items(view.nowTest.numberQues){
                        OneNumber(
                            onClick = {
                                view.changeQuestion(it) ;
                                view.toogleChoose()
                                changeQuestion()
                            },
                            content = (it+1).toString() ,
                            isChoose = view.answerList[it] != "-1"
                        )
                    }
                }
                ButtonNav(
                    onClick = {
                        //End
                        view.toogleChoose() ;
                        addResult(
                            Result(
                                studentID = view.info.uid ,
                                testID = view.nowTest.testID ,
                                result = view.listDetailResult ,
                                dateCreate = getToday()
                            )
                        )
                        goTo(nav , view , "Result")

                              },
                    content = "Kết Thúc Phần Thi" ,
                    color = Color.Transparent ,
                    contentColor = Color.White
                )
            }
    }
}
@Composable
fun Timer(time:Int , goBack : () -> Unit)
{
    var remainTime by remember {
        mutableStateOf(time*60)
    }
    val corountine = rememberCoroutineScope()

    LaunchedEffect(Unit)
    {
        corountine.launch(Dispatchers.Default){
            while (remainTime > 0)
            {
                kotlinx.coroutines.delay(1000)
                remainTime--
            }
            if(remainTime == 0)
                goBack()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = formatTime(remainTime) ,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}