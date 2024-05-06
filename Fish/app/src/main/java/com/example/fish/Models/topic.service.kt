package com.example.fish.Models

import android.util.Log
import com.example.fish.TAG
import com.example.fish.Untils.Document
import com.example.fish.Untils.ItemTopic
import com.example.fish.Untils.MyDB
import com.example.fish.Untils.Test
import com.example.fish.Untils.TextBox
import com.example.fish.Untils.Topic
import com.example.fish.Untils.getTopic
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.getValue

class HandleTopic{
    companion object{
        private val ref = MyDB.topic

        fun create(info:Topic){
            val newInstance = ref.child(info.classID).push()
            val newKey = newInstance.key
            newInstance.child("info").setValue(newKey?.let { info.copy(topicID = it) })
        }
        fun updateInfo(info:Topic){
            ref.child(info.classID).child(info.topicID).child("info").setValue(info)
        }
        fun updateTitle(info:Topic){
            ref.child(info.classID).child(info.topicID).child("info").child("title").setValue(info.title)
        }
        fun addToTopic(classId: String ,  info:Any){
            when(info){
                is TextBox -> {
                    val newRef = ref.child(classId).child(info.topicID).child("detail").push()
                    val newKey = newRef.key
                        newRef.setValue(newKey?.let { info.copy(textID = it) })
                }
                is Document -> {
                    val newRef = ref.child(classId).child(info.topicID).child("detail").push()
                    val newKey = newRef.key
                    newRef.setValue(newKey?.let { info.copy(docID = it) })
                }
                is Test -> {
                    val newRef = ref.child(classId).child(info.topicID).child("detail").push()
                    val newKey = newRef.key
                    newRef.setValue(newKey?.let { info.copy(testID = it) })
                }
            }
        }

        fun updateDetail(classId: String , info: Any){
            when(info){
                is TextBox -> {
                    ref.child(classId).child(info.topicID).child("detail").child(info.textID).setValue(info)
                }
                is Document -> {
                    ref.child(classId).child(info.topicID).child("detail").child(info.docID).setValue(info)
                }
                is Test -> {
                    ref.child(classId).child(info.topicID).child("detail").child(info.testID).setValue(info)
                }
            }
        }
        fun deleteTopic(classId:String , id:String){
            ref.child(classId).child(id).removeValue()
        }
        fun getTopicOfClass(classId: String , onGet:(MutableList<getTopic>)->Unit){
            ref.child(classId).get().addOnSuccessListener {
                val result = mutableListOf<getTopic>()
                var value : ItemTopic = TextBox()
                for( i in it.children){
                    val listItems = mutableListOf<ItemTopic>()
                    val info = i.child("info").getValue(Topic::class.java)
                    for(j in i.child("detail").children ){

                        if      (j.child("textID").exists())     value = j.getValue<TextBox>()!!
                        else if (j.child("docID").exists())      value = j.getValue<Document>()!!
                        else if (j.child("testID").exists())     value = j.getValue<Test>()!!

//                        Log.d(TAG, "TestRoom() returned: $value")
                        listItems.add(value)
                    }

                    info?.let { it1 -> getTopic(it1, listItems) }?.let { it2 -> result.add(it2) }
                }
                onGet(result)
            }
        }

    }
}