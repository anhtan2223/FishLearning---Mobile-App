package com.example.fish.Student

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.fish.Untils.Answer
import com.example.fish.Untils.Back
import com.example.fish.Untils.DemoData
import com.example.fish.Untils.Question
import com.example.fish.ui.theme.DisplayUI

@Composable
fun ResultView(nav : NavController , view : DisplayUI)
{
    Back(nav = nav, view = view , goTo = "TestPrepare")
    val classInfo = view.nowClass
    val testInfo = view.nowTest
    val listQ = DemoData.QuestionList
    val listA = DemoData.AnswerList
    if(view.isChoose)
        showAnswer( nav , view , listQ[view.nowQuestion] , listA )
    Column(
        modifier = Modifier.padding(start = 20.dp , top = 50.dp)
    ) {
        OneLine(title = "Tên Lớp", content = classInfo.nameClass)
        OneLine(title = "Bài Kiểm Tra", content = testInfo.testName)
        OneLine(title = "Số Câu Đúng", content = CountNumberCorrect(testInfo.numberQues , view.answerList))
        OneLine(title = "Chi Tiết ", content = "")
        DetailResult(nav = nav, view = view)
    }
}

@Composable
fun DetailResult(nav: NavController , view: DisplayUI)
{
    LazyVerticalGrid(columns = GridCells.Adaptive(60.dp) )
    {
        items(view.nowTest.numberQues){
            val answer = view.answerList[it]
            val isTrue = (DemoData.AnswerList.find { it.ansID == answer })?.isCorrect ?: false
                OneRepareAnswer(
                    onClick = { view.changeQuestion(it) ; view.toogleChoose() },
                    content = (it+1).toString() ,
                    isChoose = answer != -1 ,
                    isTrue = isTrue
                )
//                        Text(text = "${view.answerList[it]}")
        }
    }
}
@Composable
fun showAnswer(nav :NavController , view: DisplayUI , Q:Question , A : List<Answer>)
{
    Dialog( onDismissRequest = { /*TODO*/ })
    {
        BackHandler {
            view.toogleChoose()
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp)
        )
         {
            item{
                Card(
                    Modifier
                        .padding(bottom = 40.dp, top = 50.dp)
                        .fillMaxWidth(0.9f)
                        .clickable { view.moveNextQues() } ,
                    colors = CardDefaults.cardColors(Color(0xFF6D6D6D))
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp) ,
                        text = Q.detail,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 25.sp ,
                        color = Color.White
                    )
                }
            }
             items(A) {
                 val isChoose = view.answerList[view.nowQuestion] == it.ansID
                 if (Q.quesID == it.quesID) {
                     RepairOneAnswer(
                         nav = nav,
                         view = view,
                         A = it,
                         isChoose = isChoose)
                 }
             }
        }
    }
}
@Composable
fun OneRepareAnswer(onClick : ()-> Unit , content:String , isChoose:Boolean , isTrue:Boolean )
{
    var borderColor = when(isChoose){
        true -> if(isTrue) Color(0xFF1CCF39) else Color(0xFFFF2D2D)
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
fun CountNumberCorrect(numberQuestion : Int , answerList : List<Int> ) : String
{
    var correct = 0
    for(i in answerList)
    {
        for( j in DemoData.AnswerList)
        {
            if(i == j.ansID){
                if(j.isCorrect) correct++
            }
        }
    }
    return "$correct / $numberQuestion"
}
@Composable
fun RepairOneAnswer(nav: NavController, view : DisplayUI , A : Answer , isChoose: Boolean )
{
    val CardColors = if(A.isCorrect)
        Color(0xFF31DB38)
    else if(isChoose)
        Color(0xFFFFAB40)
    else
        Color(0xFF444444)
    val TextColor = if(isChoose) Color.Black else Color.White

    Card(
        Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(0.9f)
            .clickable { }
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
