package com.example.fish.Student

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    if(view.isChoose)
        ChooseQuestion(view)
    QNA(nav = nav, view = view , listQ[1] , listA )
}
@Composable
fun OneAnswer(nav: NavController, view : DisplayUI , A : Answer)
{
    Card(
        Modifier
            .padding(top = 30.dp)
            .fillMaxWidth(0.9f)
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp) ,
            text = A.Detail ,
            style = MaterialTheme.typography.labelMedium ,
            fontSize = 18.sp ,
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun QNA(nav: NavController, view : DisplayUI , Q:Question , A: List<Answer>)
{
    LazyColumn(
//            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = Modifier.fillMaxSize()
    )
    {
        item{
            IconButton(
                modifier = Modifier
                    .size(25.dp)
                ,
                onClick = { view.toogleChoose() }
            )
            {
                Icon(painter = painterResource(id = R.drawable.list_solid), contentDescription = null)
            }
        }
        item {
            Card(
                Modifier
                    .padding(bottom = 40.dp, top = 60.dp)
                    .fillMaxWidth(0.9f)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp) ,
                    text = Q.Detail ,
                    style = MaterialTheme.typography.labelMedium ,
                    fontSize = 18.sp ,
                    textAlign = TextAlign.Center
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
fun ChooseQuestion(view : DisplayUI)
{
    Dialog(onDismissRequest = { /*TODO*/ })
    {
        ButtonNav(
            onClick = { view.toogleChoose() },
            content = "Đóng" ,
            color = Color.Transparent ,
            contentColor = Color.White
            )
    }
}