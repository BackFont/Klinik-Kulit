package com.example.klinikkulit.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klinikkulit.models.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val db = Firebase.firestore
    var selectedItem by mutableStateOf("Home")
    var currentUserId by mutableStateOf("")
    var user by mutableStateOf(User())

    fun getUserData(currentUserId: String) {
        viewModelScope.launch {
            db.collection("users").document(currentUserId).get()
                .addOnCompleteListener {
                    user = it.result.toObject(User::class.java)!!
                }
        }
    }
}