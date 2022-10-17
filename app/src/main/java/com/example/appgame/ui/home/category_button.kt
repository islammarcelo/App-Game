package com.example.appgame.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryButton(category: String) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        modifier = Modifier
            .padding(3.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Text(text = category, color = Color.White)
    }
}