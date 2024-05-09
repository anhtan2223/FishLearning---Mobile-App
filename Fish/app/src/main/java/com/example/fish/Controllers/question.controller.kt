package com.example.fish.Controllers

import com.example.fish.Models.HandleQuestion
import com.example.fish.Models.HandleTopic
import com.example.fish.Untils.DetailResult
import com.example.fish.Untils.Question
import kotlinx.coroutines.runBlocking

fun createNewQuestion(classId:String , topicId:String ,  info: Question){
    HandleQuestion.createQuestion(info)
    HandleTopic.addNewQuestion(classId , topicId , info.testID)
}
fun deleteOneQuestion(classId: String , topicId: String , info: Question){
    HandleQuestion.deleteQuestion(info)
    HandleTopic.deleteOneQuestion(classId , topicId , info.testID)
}
fun updateQuestion(info:Question){
    HandleQuestion.updateQuestion(question = info)
}
fun getQuestionByTest(testId:String , onGet:(MutableList<Question>)->Unit){
    HandleQuestion.getQuestionByTestID(testId){
        val result = mutableListOf<Question>()
        for(i in it.children){
            val value = i.getValue(Question::class.java)
            if (value != null) {
                result.add(value)
            }
        }
        onGet(result)
    }
}
fun getDetailTest(testId: String): MutableList<DetailResult> {
    var value = mutableListOf<DetailResult>()
    runBlocking {
        value = HandleQuestion.getTestDetail(testId)
    }
    return value
}