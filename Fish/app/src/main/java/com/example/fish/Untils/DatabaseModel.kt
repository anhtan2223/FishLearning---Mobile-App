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
    var title:String = "",
    var classID:String = "1"
);

sealed class ItemTopic
data class TextBox(
    var textID : String = "",
    var content : String = "",
    var topicID: String = ""
) : ItemTopic()

data class Document(
    var docID : String = "" ,
    var discribe : String = "" ,
    var docType : String = "" ,
    var topicID: String = "0",
    var link : String = ""
) : ItemTopic()
data class Test(
    var testID:String  = "" ,
    var testName : String = "" ,
    var numberQues : Int = 0 ,
    var time : Int = 0 ,
    var topicID :String = "" ,
) : ItemTopic()
data class Question(
    var quesID : String = "",
    var detail : String = "" ,
    var testID : String = ""
)
data class Answer(
    var ansID : String = "",
    var detail: String = "",
    var isCorrect : Boolean = false,
    var quesID: String = ""
)
data class Result(
    var testID: String = "",
    var studentID: String = "",
    var resultID : String = "" ,
    var dateCreate : String = "" ,
    var result: MutableList<DetailResult> = mutableListOf()
)
data class DetailResult(
    var chooseAnswer : String = "-1",//AnsId = "
    var question : String = "",
    var answer : MutableList<Answer> = mutableListOf()
)
data class getTopic(
    var info : Topic ,
    var detail : MutableList<ItemTopic>
)