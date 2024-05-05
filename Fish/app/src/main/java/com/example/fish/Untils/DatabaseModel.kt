package com.example.fish.Untils

data class Role(
    val roleID : Int ,
    val description : String
    // 1 Student
    // 2 Teacher
    // 3 Manager
)
data class User(
    val uid : String = "Init",
    var name : String = "",
    var email : String = "",
    var username : String = "",
    var password : String = "",
    var roleid: Int = 3 ,
    var available:Boolean = true
)
data class Label(
    val labelID : String ,
    val description: String
)
data class Class(
    var classID : String = "0",
    var nameClass : String = "",
    var subtitle : String = "",
    var teacherID : String = "",
    var dateCreate : String = "15/2/2020",
    var labelID: Int = 0 ,
    var available : Boolean = true
)
data class Enrollment(
    val classID : String = "" ,
    val studentID : String = "" ,
    val dateEnroll : String = "25/8/2023"
);
data class Topic(
    var topicID : String = "" ,
    var title:String,
    var classID:String = "1"
);
data class TextBox(
    var textID : String = "",
    var content : String,
    var topicID: String = ""
);

data class Document(
    var docID : String = "" ,
    var discribe : String ,
    var docType : String ,
    var topicID: String = "0"
)
data class Test(
    var testID:String  = "",
    var testName : String = "" ,
    var numberQues : Int = 0,
    var time : Int = 0,
    var topicID :String = "",
)
data class Question(
    var quesID : String = "",
    var detail : String ,
    var testID : String
)
data class Answer(
    var ansID : String = "",
    var detail: String ,
    var isCorrect : Boolean ,
    var quesID: String = ""
)
data class Result(
    var testID: String = "" ,
    var numberCorrect : Int ,
    var attemp : Int ,
    var studentID: String = ""
)