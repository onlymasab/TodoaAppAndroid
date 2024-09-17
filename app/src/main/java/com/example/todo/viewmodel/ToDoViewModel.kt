package com.example.todo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.ToDoRepository
import com.example.todo.model.ToDoTask
import kotlinx.coroutines.launch

class ToDoViewModel(private val repository: ToDoRepository) : ViewModel() {
    private val _tasks = MutableLiveData<List<ToDoTask>>()
    val tasks: LiveData<List<ToDoTask>> = _tasks

    init {
        getTasks()
    }

    fun getTasks() {
        viewModelScope.launch {
            _tasks.value = repository.getTasks()
        }
    }

    fun addTask(task: String) {
        viewModelScope.launch {
            val newTask = ToDoTask(task = task, isDone = false)
            repository.addTask(newTask)
            getTasks()
        }
    }

    fun toggleTaskStatus(task: ToDoTask) {
        viewModelScope.launch {
            repository.updateTask(task.copy(isDone = !task.isDone))
            getTasks()
        }
    }
}