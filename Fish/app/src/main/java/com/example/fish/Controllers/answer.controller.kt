package com.example.fish.Controllers

import com.example.fish.Models.HandleAnswer
import com.example.fish.Untils.Answer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun createNewAnswer(info:Answer){
    HandleAnswer.create(info)
}
fun updateAnswer(info: Answer){
    HandleAnswer.update(info)
}
fun getAnswerByQuestion(QID:String , onGet:(MutableList<Answer>)->Unit){
    HandleAnswer.getAnswerByQuestion(QID){
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
suspend fun getList(quesId: String):MutableList<Answer>{
    return withContext(Dispatchers.IO){
        var value = mutableListOf<Answer>()
        getAnswerByQuestion(quesId){
            value = it
        }
        return@withContext value
    }
}