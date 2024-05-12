package com.example.usercentrics.presentation.composeComponent

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun CustomText(modifier : Modifier = Modifier,text: String, fontSize: TextUnit, fontWeight: FontWeight, color: Color) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = fontWeight,
            color = color
        )
    )
}