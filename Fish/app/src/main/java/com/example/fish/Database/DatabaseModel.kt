package com.example.fish.Database

data class Role(
    val roleID : Int ,
    val description : String
)
data class User(
    val uid : String = "Init",
    val name : String = "",
    val email : String = "",
    val username : String = "",
    val password : String = "",
    val roleid: Int = 3
    // 1 Student
    // 2 Teacher
    // 3 Manager
)
data class Label(
    val labelID : Int ,
    val description: String
)
data class Class(
    val classID : Int = 0,
    val nameClass : String = "",
    val subtitle : String = "",
    val teacherID : String = "",
    val dateCreate : String = "15/2/2020",
    val labelID: Int = 0
)
data class Enrollment(
    val classID : Int ,
    val studentID : Int ,
    val dateEnroll : String
);
data class Topic(
    val topicID:Int ,
    val title:String,
    val classID:Int = 0
);
data class TextBox(
    val textID:Int ,
    val content:String,
    val topicID: Int = 0
);

data class Document(
    val docID : Int ,
    val discribe : String ,
    val docType : String ,
    val topicID: Int = 0
)
data class Test(
    val testID:Int = 0,
    val testName : String = "" ,
    val numberQues : Int = 0,
    val time : Int = 0,
    val topicID :Int = 0,
)
data class Question(
    val quesID : Int,
    val detail : String ,
    val testID : Int
)
data class Answer(
    val ansID : Int = 0,
    val detail: String ,
    val isCorrect : Boolean ,
    val quesID: Int
)
data class Result(
    val testID: Int ,
    val numberCorrect : Int ,
    val attemp : Int ,
    val studentID: Int
)