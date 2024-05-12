package com.example.usercentrics.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.usercentrics.R

// Set of Material typography styles to start with
val Gotham = FontFamily(
    Font(R.font.gotham_medium),
    Font(R.font.gotham_large, FontWeight.Bold)
)


val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily =  Gotham,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
//        lineHeight = 0.46.sp,
//        letterSpacing = 0.5.sp
    ),
    bodyMedium  = TextStyle(
        fontFamily =  Gotham,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
//        lineHeight = 0.46.sp,

    )
)