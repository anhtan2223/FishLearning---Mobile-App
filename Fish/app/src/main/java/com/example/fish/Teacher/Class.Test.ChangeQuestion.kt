package com.example.fish.Teacher

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.fish.Untils.Answer
import com.example.fish.Untils.DemoData
import com.example.fish.Untils.Question
import com.example.fish.Untils.goTo
import com.example.fish.R
import com.example.fish.Student.ButtonNav
import com.example.fish.Student.OneNumber
import com.example.fish.ui.theme.DisplayUI

@Composable
fun ChangeQuestionView(nav : NavController , view : DisplayUI)
{
    BackHandler {
        view.toogleChoose()
    }
    val listQ = DemoData.QuestionList
    val listA = DemoData.AnswerList
    if(view.isChoose)
        MenuQuestion(nav = nav, view = view)
    QNA_Correct(nav = nav, view = view, listQ[view.nowQuestion] , listA)
}
@Composable
fun QNA_Correct(nav: NavController, view : DisplayUI, Q: Question, A: List<Answer>)
{
    var isSetting by remember {
        mutableStateOf(false)
    }
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    )
    {
        //Heading
        item {
            Box{
                Row(Modifier.padding(10.dp)) {
                    Icon(
                        modifier = Modifier
                            .weight(0.2f)
                            .size(25.dp)
                            .clickable { goTo(nav, view, "TestResult") },
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null)

                    Spacer(modifier = Modifier.weight(0.3f))

                    if(isSetting)
                    {
                        Icon(
                            modifier = Modifier
//                                .weight(0.1f)
                                .size(25.dp)
                                .clickable { isSetting = !isSetting },
                            imageVector = Icons.Filled.Delete ,
                            contentDescription = null)
                        Icon(
                            modifier = Modifier
//                                .weight(0.1f)
                                .size(25.dp)
                                .clickable { isSetting = !isSetting },
                            imageVector = Icons.Filled.Clear ,
                            contentDescription = null)
                        Icon(
                            modifier = Modifier
//                                .weight(0.1f)
                                .size(25.dp)
                                .clickable { isSetting = !isSetting },
                            imageVector = Icons.Filled.Check ,
                            contentDescription = null)
                    }
                    else
                        Spacer(modifier = Modifier.weight(0.3f))
                    Icon(
                        modifier = Modifier
                            .weight(0.1f)
                            .size(25.dp)
                            .clickable { isSetting = !isSetting },
                        imageVector = Icons.Filled.Settings ,
                        contentDescription = null)

                    IconButton(
                        modifier = Modifier
                            .size(25.dp)
                            .weight(0.1f),
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
        //Question
        item {
            ChangeQuestion(nav = nav, view = view, Q = Q , isSetting = isSetting)
        }
        //Answer
        items(A)
        {
            var isChange by remember {
                mutableStateOf(it.isCorrect)
            }
            if (Q.quesID == it.quesID) {
                ChangeAnswer(
                    nav = nav,
                    view = view,
                    A = it,
                    onlick = { isChange = !isChange  } ,
                    isChoose = it.isCorrect ,
                    isSetting = isSetting
                )
            }
        }
        item {
            IconButton(
                modifier = Modifier
                    .padding(10.dp)
                    .border(
                        BorderStroke(3.dp, Color(0xFFF57C00)),
                        shape = CircleShape
                    ) ,
                onClick = {  }
            ) {
                Icon(
                    tint = Color(0xFFF57C00),
                    imageVector = Icons.Default.Add ,
                    contentDescription = null)
            }
        }
    }
}
@Composable
fun MenuQuestion(nav: NavController , view : DisplayUI)
{
    Dialog( onDismissRequest = { /*TODO*/ })
    {
        BackHandler {
            view.toogleChoose()
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center
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
                        onClick = { view.changeQuestion(it) ; view.toogleChoose() },
                        content = (it+1).toString() ,
                        isChoose = false
                    )
//                        Text(text = "${view.answerList[it]}")
                }
            }
            IconButton(
                modifier = Modifier
                    .padding(10.dp)
                    .border(
                        BorderStroke(3.dp, Color(0xFFF57C00)),
                        shape = CircleShape
                    ) ,
                onClick = { view.toogleChoose() }
            ) {
                Icon(
                    tint = Color(0xFFF57C00),
                    imageVector = Icons.Default.Add ,
                    contentDescription = null)
            }
        }
    }
}
@Composable
fun ChangeAnswer(nav: NavController, view : DisplayUI , A : Answer , isChoose: Boolean ,  onlick: () -> Unit , isSetting:Boolean )
{
    val CardColors = if(isChoose) Color(0xFF23DC2D) else Color(0xFF444444)
    val TextColor = if(isChoose) Color.Black else Color.White
    var content by remember {
        mutableStateOf(A.detail)
    }
    Card(
        Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(0.9f)
            .clickable { onlick() }
    ) {
        if(!isSetting)
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
        else
            BasicTextField(
                modifier = Modifier
                    .fillMaxSize()
                    .background(CardColors)
                    .padding(10.dp) ,
                value = content ,
                onValueChange = { content = it } ,
                textStyle = TextStyle(
                    fontSize = 16.sp ,
                    lineHeight = 20.sp ,
                    textAlign = TextAlign.Center ,
                    color = Color.White
                )
            )

    }
}
@Composable
fun ChangeQuestion(nav: NavController, view : DisplayUI , Q:Question , isSetting: Boolean)
{
    var content by remember {
        mutableStateOf(Q.detail)
    }
    Card(
        Modifier
            .padding(bottom = 40.dp, top = 50.dp)
            .fillMaxWidth(0.9f)
            .clickable { if (!isSetting) view.moveNextQues() } ,
        colors = CardDefaults.cardColors(Color(0xFF6D6D6D))
    ) {
        if(!isSetting)
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp) ,
                text = Q.detail ,
                style = MaterialTheme.typography.labelMedium,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                lineHeight = 25.sp ,
                color = Color.White
            )
        else
            BasicTextField(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp) ,
                value = Q.detail ,
                onValueChange = {content = it} ,
                textStyle = TextStyle(
                    fontSize = 20.sp ,
                    lineHeight = 25.sp ,
                    textAlign = TextAlign.Center ,
                    color = Color.White
                )
            )
    }
}