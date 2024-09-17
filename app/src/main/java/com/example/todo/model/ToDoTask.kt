package com.example.todo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDoTask(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val task: String,
    val isDone: Boolean
)