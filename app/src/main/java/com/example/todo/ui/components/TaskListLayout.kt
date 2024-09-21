package com.example.todo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun TaskListLayout() {
    LazyColumn(
        content = {
            items( count = 50) {
                item -> TaskTile()
            }

        }
    )
}



@Composable
fun TaskTile() {
    var isSelected by remember { mutableStateOf(value = false) }
    Box (
        contentAlignment = Alignment.CenterStart,
        content = {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                content =  {
                    RadioButton(
                        selected = isSelected,
                        onClick = { if (isSelected == true) isSelected = false else isSelected = true}
                    )
                    Column (
                        content = {
                            Text(text = "Title")
                            Text(text = "Description")
                        }
                    )
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "View More")
                }
            )
        }
    )
    HorizontalDivider()
}