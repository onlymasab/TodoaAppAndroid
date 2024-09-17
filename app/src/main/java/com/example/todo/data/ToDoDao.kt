package com.example.todo.data


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todo.model.ToDoTask

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table")
    suspend fun getAllTasks(): List<ToDoTask>

    @Insert
    suspend fun addTask(task: ToDoTask)

    @Update
    suspend fun updateTask(task: ToDoTask)

    @Delete
    suspend fun deleteTask(task: ToDoTask)
}