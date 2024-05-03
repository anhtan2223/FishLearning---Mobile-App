package com.example.fish.Controllers

import com.example.fish.Models.HandleText
import com.example.fish.Untils.TextBox

fun updateText(id:String , info:TextBox){
    HandleText.update(id,info)
}
fun deleteText(id: String){
    HandleText.delete(id)
}