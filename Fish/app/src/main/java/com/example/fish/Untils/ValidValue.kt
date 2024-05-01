package com.example.fish.Untils

class ValidValue {
    companion object{
        private val regexEmail      = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        private val regexName       = Regex("[\\p{L}\\s]{1,50}")
        private val regexUsername   = Regex("\\S{6,}")
        private val regexPassword   = Regex("\\S{8,}")
//        private val regexPassword   = Regex("\\S{8,}")
        fun isValidEmail(input:String):Boolean = regexEmail.matches(input)
        fun isValidName(input:String):Boolean = regexName.matches(input)
        fun isValidUsername(username: String): Boolean = regexUsername.matches(username)
        fun isValidPassword(username: String): Boolean = regexPassword.matches(username)
    }
}