package com.example.fish.Views.Teacher

import android.util.Log
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.fish.Controllers.createNewAnswer
import com.example.fish.Controllers.createNewQuestion
import com.example.fish.Controllers.deleteItemTopic
import com.example.fish.Controllers.deleteOneAnswer
import com.example.fish.Controllers.deleteOneQuestion
import com.example.fish.Controllers.getAnswerByQuestion
import com.example.fish.Controllers.getQuestionByTest
import com.example.fish.Controllers.toggleCorrectAnswer
import com.example.fish.Controllers.updateAnswer
import com.example.fish.Controllers.updateQuestion
import com.example.fish.R
import com.example.fish.Untils.AddAlert
import com.example.fish.Untils.Answer
import com.example.fish.Untils.Back
import com.example.fish.Untils.DemoData
import com.example.fish.Untils.MyDB
import com.example.fish.Untils.Question
import com.example.fish.Untils.appendMessage
import com.example.fish.Untils.goTo
import com.example.fish.Views.Student.ButtonNav
import com.example.fish.Views.Student.OneNumber
import com.example.fish.ui.theme.DisplayUI
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@Composable
fun ChangeQuestionView(nav : NavController , view : DisplayUI)
{
    val context = LocalContext.current
    var listQ by remember {
        mutableStateOf(mutableListOf<Question>( Question(detail = "Init Value") ))
    }
    getQuestionByTest(view.nowTest.testID){
        listQ = it
    }
    BackHandler {
        view.toogleChoose()
    }
    if(listQ.isEmpty()){
        EmptyList(nav , view){
            createNewQuestion(
                view.nowClass.classID ,
                view.nowTest.topicID ,
                Question(detail = "New Question" , testID = view.nowTest.testID )
            )
            view.addNewQuestion()
            getQuestionByTest(view.nowTest.testID){ listQ = it }
            appendMessage(context , "Thêm Câu Hỏi Mới Thành Công")
            view.changeQuestion(view.nowTest.numberQues-1)
        }

    }
    else{
        val nowQuestion = listQ[view.nowIndexQuestion]
        QNA_Correct(nav = nav , view = view , nowQuestion ,
            onDelete = {
                if(view.nowTest.numberQues == 0)
                    listQ = mutableListOf()
                else
                    getQuestionByTest(view.nowTest.testID){ listQ = it }
            } ,
            onNewAnswer = {
                createNewAnswer(
                    Answer(detail ="New Answer" , quesID = nowQuestion.quesID )
                )
            } ,
            onChangeQuestion = {
                nowQuestion.detail = it
                updateQuestion(nowQuestion)
            } ,
            onUpdateMenu = {
                createNewQuestion(
                    view.nowClass.classID ,
                    view.nowTest.topicID ,
                    Question(detail = "New Question" , testID = view.nowTest.testID )
                )
                view.addNewQuestion()
                getQuestionByTest(view.nowTest.testID){
                    listQ = it
                }
                appendMessage(context , "Thêm Câu Hỏi Mới Thành Công")
                view.changeQuestion(view.nowTest.numberQues-1)
            }
        )
    }
}
@Composable
fun EmptyList(nav: NavController, view : DisplayUI , addNew:()->Unit){
    Back(nav = nav, view = view , "TestResult")
    Column(
        Modifier.fillMaxSize() ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Vui Lòng Thêm Câu Hỏi Mới" ,
            fontSize = 25.sp ,
            style = MaterialTheme.typography.labelSmall
        )
        IconButton(
            modifier = Modifier
                .padding(10.dp)
                .border(BorderStroke(3.dp, Color(0xFFF57C00)), shape = CircleShape) ,
            onClick = { addNew() }
        ) {
            Icon(
                tint = Color(0xFFF57C00),
                imageVector = Icons.Default.Add ,
                contentDescription = null)
        }
    }
}

@Composable
fun QNA_Correct(nav: NavController, view : DisplayUI, Q:Question ,
                onDelete:()->Unit = {} ,
                onNewAnswer:()->Unit = {} ,
                onChangeQuestion: (String) -> Unit = {} ,
                onUpdateMenu: ()->Unit = {} ,
)
{
    val context = LocalContext.current
    var isSetting by remember {
        mutableStateOf(false)
    }
    var listA by remember {
        mutableStateOf(mutableListOf<Answer>())
    }

    getAnswerByQuestion(Q.quesID){
        listA = it
    }

    if(view.isChoose)
        MenuQuestion(
            view = view ,
            onUpdate = { onUpdateMenu() } ,
            onChoose = { listA.clear() }
        )

    var isDelete by remember {
        mutableStateOf(false)
    }
    AddAlert(
        isShow = isDelete ,
        content = "Xác Nhận Xoá Câu Hỏi",
        onCancel = { isDelete = false } ,
        onConfirm = {
            deleteOneQuestion(view.nowClass.classID , view.nowTest.topicID , Q)
            appendMessage(context , "Xoá Câu Hỏi Thành Công")
            view.deleteOneQuestion()
            isDelete = false
            if(view.nowIndexQuestion == view.nowTest.numberQues){
                if(view.nowTest.numberQues != 0)
                    view.changeQuestion(view.nowTest.numberQues-1)
            }
            onDelete()
        }
    )

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    )
    {
        //Heading
        item {
            Heading(
                isSetting = isSetting ,
                onDelete = {isSetting = !isSetting; isDelete = true} ,
                onBack = {goTo(nav, view, "TestResult")} ,
                onMenu = { view.toogleChoose() } ,
                onSetting = { isSetting = !isSetting }
            )
        }
        //Question
        item {
            ChangeQuestion(
                view = view, Q = Q,
                isSetting = isSetting ,
                onChangeQuestion = { onChangeQuestion(it) } ,
                onNextQues = { listA.clear() }
            )
        }
        //Answer
        items(listA)
        {
            var isChange by remember {
                mutableStateOf(it.isCorrect)
            }
            ChangeAnswer(
                A = it,
                toogleResult = {
                    toggleCorrectAnswer(it.ansID ,isChange)
                    isChange = !isChange
                } ,
                isChoose = isChange ,
                isSetting = isSetting ,
                onDeleteAnswer = {id ->
                        deleteOneAnswer(id)
                        listA = listA.filter {
                            it.ansID != id
                        }.toMutableList()
                        isSetting = !isSetting
                        isChange = false
                } ,
                onUpdate = {value ->
                    it.detail = value
                    updateAnswer(it)
                }
            )
        }
        //Add New Answer
        item {
            IconButton(
                modifier = Modifier
                    .padding(10.dp)
                    .border(
                        BorderStroke(3.dp, Color(0xFFF57C00)),
                        shape = CircleShape
                    ) ,
                onClick = {
                    runBlocking {
                        onNewAnswer()
                        getAnswerByQuestion(Q.quesID){
                                listA = it
                        }

                    }
                }
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
fun MenuQuestion(view : DisplayUI , onChoose:()->Unit = {} , onUpdate:()->Unit )
{
    Dialog( onDismissRequest = {  })
    {
        BackHandler { view.toogleChoose() }
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
                        onClick = {
                            onChoose()
                            view.toogleChoose()
                            view.changeQuestion(it)
                        },
                        content = (it+1).toString() ,
                        isChoose = (view.nowIndexQuestion == it)
                    )
                }
            }
            IconButton(
                modifier = Modifier
                    .padding(10.dp)
                    .border(BorderStroke(3.dp, Color(0xFFF57C00)), shape = CircleShape) ,
                onClick = {
                    onUpdate()
                    view.toogleChoose()
                }
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
fun ChangeAnswer( A : Answer , isChoose: Boolean ,
                  toogleResult:() -> Unit ,
                  isSetting:Boolean ,
                  onUpdate: (String) -> Unit = {} ,
                  onDeleteAnswer:(String)->Unit)
{
    var context = LocalContext.current

    val CardColors = if(isChoose) Color(0xFF23DC2D) else Color(0xFF444444)
    val TextColor = if(isChoose) Color.Black else Color.White

    var isDelete by remember {
        mutableStateOf(false)
    }
    AddAlert(
        isShow = isDelete ,
        content = "Xác Nhận Xoá Câu Hỏi" ,
        onCancel = { isDelete = false } ,
        onConfirm = {
            appendMessage( context, "Xoá Câu Hỏi Thành Công")
            onDeleteAnswer(A.ansID)
            isDelete= false
        }
    )

    Card(
        Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(0.9f)
    ) {
        if(!isSetting)
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .background(CardColors)
                    .padding(10.dp)
                    .clickable { toogleResult() }
                ,
                text = A.detail ,
                style = MaterialTheme.typography.labelMedium ,
                fontSize = 16.sp ,
                textAlign = TextAlign.Center ,
                lineHeight = 20.sp ,
                color = TextColor
            )
        else{
            var content by remember {
                mutableStateOf(A.detail)
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(CardColors)
                    .padding(10.dp)
            ) {

                BasicTextField(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(CardColors)
                        .weight(0.9f)
//                        .padding(10.dp)
                    ,
                    value = content ,
                    onValueChange = {
                        content = it ;
                        onUpdate(it)
                    } ,
                    textStyle = TextStyle(
                        fontSize = 16.sp ,
                        lineHeight = 20.sp ,
                        textAlign = TextAlign.Center ,
                        color = TextColor
                    )
                )

                Icon(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .size(20.dp)
                        .weight(0.1f)
                        .clickable {
                            isDelete = true
                        },
                    tint = TextColor,
                    imageVector = Icons.Filled.Delete ,
                    contentDescription = null
                )

            }
        }
    }
}
@Composable
fun ChangeQuestion( view : DisplayUI , Q : Question , isSetting: Boolean , onChangeQuestion:(String)->Unit , onNextQues:()->Unit)
{
    Card(
        Modifier
            .padding(bottom = 40.dp, top = 50.dp)
            .fillMaxWidth(0.9f)
            .clickable {
                if (!isSetting) {
                    view.moveNextQues()
                    onNextQues()
                }
            } ,
        colors = CardDefaults.cardColors(Color(0xFF6D6D6D))
    ) {

        if(!isSetting){
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp) ,
                text = Q.detail ,
                style = MaterialTheme.typography.labelMedium, fontSize = 20.sp, textAlign = TextAlign.Center, lineHeight = 25.sp , color = Color.White
            )
        }
        else{
            var content by remember {
                mutableStateOf( Q.detail )
            }
            BasicTextField(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp) ,
                value = content ,
                onValueChange = {
                    content = it
                    onChangeQuestion(it)
                } ,
                textStyle = TextStyle(fontSize = 20.sp , lineHeight = 25.sp , textAlign = TextAlign.Center , color = Color.White)
            )
        }
    }
}
@Composable
fun Heading(
    isSetting: Boolean ,
    onDelete: () -> Unit ,
    onBack: ()->Unit = {},
    onMenu : ()->Unit = {},
    onSetting : ()->Unit = {}
){
    Box{
        Row(Modifier.padding(10.dp)) {
            Icon(
                modifier = Modifier
                    .weight(0.2f)
                    .size(25.dp)
                    .clickable { onBack() },
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null
            )

            Spacer(modifier = Modifier.weight(0.5f))

            if(isSetting)
            {
                Icon(
                    modifier = Modifier
                        .weight(0.1f)
                        .size(25.dp)
                        .clickable { onDelete() },
                    imageVector = Icons.Filled.Delete ,
                    contentDescription = null)
            }
            else
                Spacer(modifier = Modifier.weight(0.1f))
            Icon(
                modifier = Modifier
                    .weight(0.1f)
                    .size(25.dp)
                    .clickable { onSetting() },
                imageVector = Icons.Filled.Settings ,
                contentDescription = null)

            IconButton(
                modifier = Modifier
                    .size(25.dp)
                    .weight(0.1f),
                onClick = { onMenu() }
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