package com.example.todo.data

import com.example.todo.model.ToDoTask

class ToDoRepository(private val toDoDao: ToDoDao) {
    suspend fun getTasks(): List<ToDoTask> = toDoDao.getAllTasks()
    suspend fun addTask(task: ToDoTask) = toDoDao.addTask(task)
    suspend fun updateTask(task: ToDoTask) = toDoDao.updateTask(task)
    suspend fun deleteTask(task: ToDoTask) = toDoDao.deleteTask(task)
}