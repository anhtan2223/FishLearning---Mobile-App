package com.example.fish

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun TestRoom(){
    Text(text = "Test Room Here")

    val database = Firebase.database("https://fishlearning-ce8e9-default-rtdb.asia-southeast1.firebasedatabase.app/")
    val myRef = database.getReference("message")

    myRef.setValue("Test 001")

    Button(
        modifier = Modifier.fillMaxSize(),
        onClick = {
        myRef.setValue("Hello, World!")
        Log.d("Test","Hello World")
    }) {
        Text(text = "Add Message")
    }
    
}