package com.example.taskmasterkotlin.data

data class Task(
    val id: Int,
    val title: String,
    val description: String? = null, // null safety
    var isCompleted: Boolean = false
)