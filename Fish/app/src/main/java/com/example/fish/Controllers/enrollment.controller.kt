package com.example.fish.Controllers

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.fish.Models.HandleEnrollment
import com.example.fish.Models.HandleUser
import com.example.fish.Untils.Class
import com.example.fish.Untils.Enrollment
import com.example.fish.Untils.User
import com.example.fish.Untils.getToday

fun enrollClass(info:Enrollment){
    HandleEnrollment.create(info)
}
fun getlistUserOfClass(classId : String , onGet:(MutableList<User>)->Unit = {}){
    HandleEnrollment.getlistUserByClass(classId){
        val listUser = mutableListOf<String>()
        for (i in it.children){
            Log.d("TAG", "getlistUserOfClass: ${i.key}")
            i.key?.let { it1 ->
                listUser.add(it1)
            }
        }
        HandleUser.getListUserByListId(listUser){
            onGet(it)
        }
    }
}
fun getListClassOfUser(uid:String , handle:(MutableList<Class>)->Unit = {}){
    HandleEnrollment.getAll {
        val listClass = mutableListOf<String>()
        for(i in it.children){
            for(j in i.children)
                if (j.key == uid)
                    i.key?.let { it1 -> listClass.add(it1) }
            Log.d("TAG", "getListClassOfUser: ${i.key}")
        }
        getAllClass(){
            handle(it.filter {
                it.classID in listClass
            }.toMutableList())
        }
    }
}
fun deleteEnrollment(classId: String , uid: String){
    HandleEnrollment.deleteByUID(classId,uid)
}
@RequiresApi(Build.VERSION_CODES.O)
fun registerClass(classId: String, uid: String){
    HandleEnrollment.create(Enrollment(classId , uid , getToday()))
}

fun isInClass(classId: String , uid: String , onCheck:(Boolean)->Unit){
    HandleEnrollment.checkClassHasUser(classId , uid){
        onCheck(it)
    }
}