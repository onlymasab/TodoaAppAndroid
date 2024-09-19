package com.example.todo.ui.components

import android.widget.GridLayout
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskGridLayout () {

    Column (
        content = {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Manage your task",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,

                modifier = Modifier
                    .padding(start = 24.dp)

            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 2),
                contentPadding = PaddingValues(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(space = 4.dp),
                verticalArrangement = Arrangement.spacedBy(space = 4.dp),
                content = {
                    items(count = 4)  {
                            item -> TaskCountBox()
                    }
                }
            )
        }
    )
}


@Composable
fun TaskCountBox() {
    Box (
        modifier = Modifier
        .background(
            color = Color.Red,
            shape = CircleShape
        )
            .padding(vertical = 4.dp, horizontal = 4.dp),


        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Text(
                        text = "In Prograss",
                        modifier = Modifier.padding(start = 12.dp)
                    )
                    TaskCountCircle()

                }
            )
        }

    )
}


@Composable
fun  TaskCountCircle() {
    Box(
        modifier = Modifier
            .background(color = Color.White, shape = CircleShape)

            .padding(vertical = 12.dp, horizontal = 15.dp),
        content = {
            Text(text= "02")
        }
    )
}