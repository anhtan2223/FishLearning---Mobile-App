package com.example.fish.Model

data class Role(
    val RoleID : Int ,
    val Description : String
)
data class User(
    val UID : Int = 0,
    val Name : String ,
    val Email : String ,
    val Username : String ,
    val Passwork : String ,
    val RoleID: Int
)
data class Label(
    val LabelID : Int ,
    val Description: String
)
data class Class(
    val ClassID : Int = 0,
    val NameClass : String ,
    val Subtitle : String ,
    val TeacherID : String ,
    val DateCreate : String = "15/2/2020",
    val LabelID: Int = 0
)
data class Enrollment(
    val ClassID : Int ,
    val StudentID : Int ,
    val DateEnroll : String
);
data class Topic(
    val TopicID:Int ,
    val Title:String,
    val ClassID:Int
);
data class TextBox(
    val TextID:Int ,
    val Content:String,
    val TopicID: Int
);
data class DocType(
    val DocType: Int ,
    val Type : String
)
data class Document(
    val DocID : Int ,
    val Discribe : String ,
    val DocType : Int ,
    val TopicID: Int
)
data class Test(
    val TestID:Int,
    val TestName : String ,
    val NumberQues : Int ,
    val Time : Int ,
    val TopicID :Int ,
)
data class Question(
    val QuesID : Int,
    val Detail : String ,
    val TestID : Int
)
data class Answer(
    val AnsID : Int ,
    val Detail: String ,
    val isCorrect : Boolean ,
    val QuesID: Int
)
data class Result(
    val TestID: Int ,
    val NumberCorrect : Int ,
    val TimeDone : Int ,
    val Attemp : Int ,
    val StudentID: Int
)