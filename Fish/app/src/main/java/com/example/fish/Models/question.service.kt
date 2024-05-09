package com.example.fish.Models

import com.example.fish.Untils.Answer
import com.example.fish.Untils.DetailResult
import com.example.fish.Untils.MyDB
import com.example.fish.Untils.Question
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.getValue
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await

//Detail Of Test Include Question And Answer
class HandleQuestion{
    companion object{
        val ref = MyDB.question
        fun createQuestion( question:Question ){
            val newRef = ref.child(question.testID).push()
            val newKey = newRef.key
            newRef.setValue(newKey?.let { question.copy(quesID = it ) })
        }
        fun updateQuestion(question: Question){
            ref.child(question.testID).child(question.quesID).setValue(question)
        }
        fun getQuestionByTestID(testId:String , onGet:(DataSnapshot)->Unit ){
            ref.child(testId).get().addOnSuccessListener {
                onGet(it)
            }
        }
        fun getQuestionByQID(testId: String , QID:String , onGet: (DataSnapshot) -> Unit){
            ref.child(testId).child(QID).get().addOnSuccessListener(onGet)
        }
        fun deleteQuestion(info:Question){
            ref.child(info.testID).child(info.quesID).removeValue()
        }

        suspend fun getTestDetail(testId:String):MutableList<DetailResult> {
            val result : MutableList<DetailResult> = mutableListOf()
            val question = ref.child(testId).get().await()
            for(i in question.children){
                val ques = i.getValue<Question>()
                var listAnswer = mutableListOf<Answer>()
                if (ques != null) {
                        listAnswer = HandleAnswer.getAnswerByQID(ques.quesID)
                        result.add(DetailResult(question = ques.detail , answer = listAnswer))
                }
            }
            return result
        }
    }
}