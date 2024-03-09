package com.example.fish.Student

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.fish.Model.Answer
import com.example.fish.Model.DemoData
import com.example.fish.Model.Question
import com.example.fish.Model.Test
import com.example.fish.ui.theme.DisplayUI
import com.example.fish.R


@Composable
fun TestView(modifier: Modifier = Modifier ,  nav: NavController, view : DisplayUI)
{
    val listQ = DemoData.QuestionList
    val listA = DemoData.AnswerList
//    BackHandler {
//        //Do Later
//    }
    if(view.isChoose)
        ChooseQuestion(view)
    QNA(nav = nav, view = view , listQ[0] , listA )
}
@Composable
fun OneAnswer(nav: NavController, view : DisplayUI , A : Answer)
{
    Card(
        Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(0.9f)
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp) ,
            text = A.Detail ,
            style = MaterialTheme.typography.labelMedium ,
            fontSize = 16.sp ,
            textAlign = TextAlign.Center ,
            lineHeight = 20.sp
        )
    }
}
@Composable
fun QNA(nav: NavController, view : DisplayUI , Q:Question , A: List<Answer>)
{
    LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp)
    )
    {
        item{
            Row {
                Spacer(modifier = Modifier.weight(0.8f))
                IconButton(
                    modifier = Modifier
                        .size(25.dp)
                        .weight(0.2f)
                    ,
                    onClick = { view.toogleChoose() }
                )
                {
                    Icon(painter = painterResource(id = R.drawable.list_solid), contentDescription = null)
                }
            }
            
        }
        item {
            Card(
                Modifier
                    .padding(bottom = 40.dp, top = 50.dp)
                    .fillMaxWidth(0.9f)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp) ,
                    text = Q.Detail ,
                    style = MaterialTheme.typography.labelMedium ,
                    fontSize = 20.sp ,
                    textAlign = TextAlign.Center ,
                    lineHeight = 8.sp
                )
            }
        }
        items(A){
            if(Q.QuesID == it.QuesID)
                OneAnswer(nav = nav, view = view, A = it)
        }
    }
}
@Composable
fun OneNumber(onClick : ()-> Unit , content:String )
{
    Box(
        modifier = Modifier
            .padding(10.dp)
            .clickable { onClick() }
            .background(Color.Transparent)
            .border(2.dp, Color.White, CircleShape)
            .graphicsLayer { shape = CircleShape }
        ,
    ){
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            text = content ,
            style = MaterialTheme.typography.labelLarge ,
            fontSize = 25.sp ,
            maxLines = 1
        )
    }
}
@Composable
fun ChooseQuestion(view : DisplayUI)
{
    Dialog( onDismissRequest = { /*TODO*/ })
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
                    items(view.nowTest.NumberQues){
                        OneNumber(
                            onClick = { /*TODO*/ },
                            content = it.toString()
                        )
                    }
                }
            }
    }
}