package com.example.fish.Models

import com.example.fish.Untils.MyDB
import com.example.fish.Untils.Question
import com.google.firebase.database.DataSnapshot

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
        fun deleteQuestion(info:Question){
            ref.child(info.testID).child(info.quesID).removeValue()
        }
    }
}