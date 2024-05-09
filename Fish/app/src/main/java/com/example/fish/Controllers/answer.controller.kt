package com.example.fish.Controllers

import com.example.fish.Models.HandleAnswer
import com.example.fish.Untils.Answer
import com.google.firebase.database.getValue

fun createNewAnswer(info:Answer){
    HandleAnswer.create(info)
}
fun updateAnswer(info: Answer){
    HandleAnswer.update(info)
}
fun getAnswerByListAnswer(listId : MutableList<String> , onGet:(MutableList<Answer>)->Unit){
    HandleAnswer.getAll {
        val listAnswer = mutableListOf<Answer>()
        for(i in it.children){
            var value = i.getValue<Answer>()
            if (value != null) {
                if(value.ansID in listId)
                    listAnswer.add(value)
            }
        }
        onGet(listAnswer)
    }
}
fun getAnswerByQuestion(QID:String , onGet:(MutableList<Answer>)->Unit){
    HandleAnswer.getAll{
        val listAnswer = mutableListOf<Answer>()
        for(i in it.children){
            val value = i.getValue(Answer::class.java)
            if (value != null) {
                if( value.quesID == QID )
                    listAnswer.add(value)
            }
        }
        onGet(listAnswer)
    }
}
fun deleteOneAnswer(id:String){
    HandleAnswer.deleteById(id)
}
fun toggleCorrectAnswer(id:String , nowValue:Boolean){
    HandleAnswer.setIsTrue(id,nowValue)
}
