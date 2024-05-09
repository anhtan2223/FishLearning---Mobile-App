package com.example.fish.Controllers

import com.example.fish.Models.HandleResult
import com.example.fish.Untils.Result

fun addResult(info:Result){
    HandleResult.create(info)
}
fun updateResult(info:Result){
    HandleResult.update(info)
}
fun getResultByUser(testId:String , uid:String , onGet:(MutableList<Result>)->Unit){
    HandleResult.getAllByUser(testId , uid){
        var listResult = mutableListOf<Result>()
        for(i in it.children){
            i.getValue(Result::class.java)?.let { it1 -> listResult.add(it1) }
        }
        onGet(listResult)
    }
}