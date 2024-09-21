package com.example.todo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


val titles : List<String> = listOf("In Progress", "Continued", "Canceled", "Delayed")


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
                            item -> TaskCountBox(title = titles[item])
                    }
                }
            )
        }
    )
}


@Composable
fun TaskCountBox(title: String) {

    val backgroundColor = remember { getRandomColor() }
    val textColor = if(isColorDark(color = backgroundColor)) Color.White else Color.Black

    Box (
        modifier = Modifier
        .background(
            color = backgroundColor,
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
                        color = textColor,
                        text = title,
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



fun getRandomColor(): Color {
    val red = Random.nextInt(until = 256)
    val green = Random.nextInt(until = 256)
    val blue = Random.nextInt(until = 256)

    return  Color(red = red / 255f, green = green / 255f, blue = blue / 255f)
}


fun isColorDark(color: Color) : Boolean {
    val red = color.red * 255
    val green = color.green * 255
    val blue = color.blue  * 255

    val luminance = 0.299 * red + 0.587 * green + 0.114 * blue

    return  luminance < 128
}
