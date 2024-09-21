package com.example.todo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todo.ui.components.TaskGridLayout
import com.example.todo.ui.components.TaskListLayout


@Composable
fun App(innerPadding : PaddingValues) {

    Surface (
        modifier =  Modifier
        .padding(innerPadding)
    ) {
        Column (
            content = {
                TaskGridLayout()
                Spacer(Modifier.height(24.dp))
                TaskListLayout()
            }
        )
    }
}